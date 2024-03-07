package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Hand;
import blackjack.domain.Player;
import blackjack.domain.Players;

import java.util.stream.Collectors;

public class MessageResolver {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SEPARATOR = ", ";

    public String resolveHandOutEventMessage(Players players, int handOutCount) {
        String namesMessage = resolveNamesMessage(players);
        return String.format("딜러와 %s에게 %d장을 나누었습니다.", namesMessage, handOutCount);
    }

    private String resolveNamesMessage(Players players) {
        return players.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.joining(SEPARATOR));
    }

    public String resolvePlayerHandMessage(Player player) {
        return String.format("%s 카드: %s", player.getName(), resolveHandMessage(player.getHand()));
    }

    private String resolveHandMessage(Hand hand) {
        return hand.getCards().stream()
                .map(this::resolveCardMessage)
                .collect(Collectors.joining(SEPARATOR));
    }

    private String resolveCardMessage(Card card) {
        return String.format("%d%s", card.getCardNumber(), card.getCardShape());
    }

    public String resolveDealerPopCountMessage(int dealerDrawThreshold, int popCount) {
        return String.format("딜러는 %d이하라 %d장의 카드를 더 받았습니다.", dealerDrawThreshold, popCount);
    }

    public String resolvePlayersScoreMessage(Players players) {
        return players.getPlayers().stream()
                .map(this::resolvePlayerScoreMessage)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String resolvePlayerScoreMessage(Player player) {
        String handMessage = resolveHandMessage(player.getHand());
        int sum = player.calculateHandSum();
        return String.format("%s - 결과: %d", handMessage, sum);
    }
}
