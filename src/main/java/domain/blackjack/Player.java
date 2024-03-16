package domain.blackjack;

import domain.card.Deck;
import domain.card.RandomCardSelectStrategy;

public class Player extends Gamer {
    private final String name;
    private final BettingMoney bettingMoney;

    private Player(String name, BlackJackGameMachine blackJackGameMachine, int bettingMoney) {
        super(blackJackGameMachine);
        this.name = name;
        this.bettingMoney = new BettingMoney(bettingMoney);
    }

    static Player from(String name, HoldingCards holdingCards) {
        return new Player(name, new BlackJackGameMachine(holdingCards), 0);
    }

    static Player from(String name, HoldingCards holdingCards, int bettingMoney) {
        return new Player(name, new BlackJackGameMachine(holdingCards), bettingMoney);
    }

    @Override
    DrawResult draw(Deck deck) {
        return blackJackGameMachine.draw(deck, RandomCardSelectStrategy.INSTANCE,
                new PlayerCardDrawCondition(blackJackGameMachine));
    }

    public String getRawName() {
        return name;
    }

    final EarningMoney calculateEarningMoney(GameResult gameResult) {
        return bettingMoney.calculateEarningMoney(gameResult);
    }
}
