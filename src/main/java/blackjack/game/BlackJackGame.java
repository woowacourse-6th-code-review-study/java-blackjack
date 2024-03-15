package blackjack.game;

import blackjack.card.Deck;
import blackjack.player.Dealer;
import blackjack.player.Player;
import blackjack.player.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackJackGame {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackJackGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Deck deck = Deck.createShuffledFullDeck();
        Dealer dealer = new Dealer();

        Players players = createPlayers();
        initializeGame(deck, dealer, players);
        proceedPlayersTurn(deck, players);
        proceedDealerTurn(deck, dealer);

        showCardsWithScore(dealer, players);
        showMatchResult(dealer, players);
    }

    private Players createPlayers() {
        outputView.printNamesRequest();
        List<String> names = inputView.readNames();
        Players players = new Players(names);
        outputView.printNewLine();
        return players;
    }

    private void initializeGame(Deck deck, Dealer dealer, Players players) {
        players.doInitialDraw(deck);
        dealer.doInitialDraw(deck);
        outputView.printInitializeBlackJack(players.getNames());
        showInitialCard(dealer, players);
    }

    private void showInitialCard(Dealer dealer, Players players) {
        outputView.printDealerFirstCard(dealer.getFirstCard());

        for (Player player : players.getPlayers()) {
            outputView.printPlayerCards(player.getName(), player.getCards());
        }
        outputView.printNewLine();
    }

    private void proceedPlayersTurn(Deck deck, Players players) {
        for (Player player : players.getPlayers()) {
            proceedPlayerTurn(deck, player);
        }
        outputView.printNewLine();
    }

    private void proceedPlayerTurn(Deck deck, Player player) {
        Command command = askPlayerToDrawMore(player);
        if (command.isNo()) {
            return;
        }
        player.drawCard(deck);
        outputView.printPlayerCards(player.getName(), player.getCards());

        if (player.hasDrawableScore()) {
            proceedPlayerTurn(deck, player);
        }
    }

    private Command askPlayerToDrawMore(Player player) {
        outputView.printDrawMoreCardRequest(player.getName());
        String input = inputView.readCommand();
        return Command.from(input);
    }

    private void proceedDealerTurn(Deck deck, Dealer dealer) {
        while (dealer.hasDrawableScore()) {
            dealer.drawCard(deck);
            outputView.printDealerDrawCard();
            outputView.printNewLine();
        }
    }

    private void showCardsWithScore(Dealer dealer, Players players) {
        outputView.printDealerCardsWithScore(dealer.getCards(), dealer.getScore());
        for (Player player : players.getPlayers()) {
            outputView.printPlayerCardsWithScore(player.getName(), player.getCards(), player.getScore());
        }
        outputView.printNewLine();
    }

    private void showMatchResult(Dealer dealer, Players players) {
        MatchResults matchResults = calculateMatchResults(dealer, players);
        outputView.printResultStart();
        showDealerResult(matchResults);
        showPlayersResult(players, matchResults);
    }

    private MatchResults calculateMatchResults(Dealer dealer, Players players) {
        MatchResults matchResults = new MatchResults();
        for (Player player : players.getPlayers()) {
            matchResults.addResult(player.getName(), player.getScore(), dealer.getScore());
        }
        return matchResults;
    }

    private void showDealerResult(MatchResults matchResults) {
        outputView.printDealerResult(
                matchResults.getResultCount(MatchResult.DEALER_WIN),
                matchResults.getResultCount(MatchResult.TIE),
                matchResults.getResultCount(MatchResult.PLAYER_WIN)
        );
    }

    private void showPlayersResult(Players players, MatchResults matchResults) {
        for (Player player : players.getPlayers()) {
            String playerName = player.getName();
            MatchResult result = matchResults.getResultByName(playerName);
            outputView.printPlayerResult(playerName, result);
        }
    }
}
