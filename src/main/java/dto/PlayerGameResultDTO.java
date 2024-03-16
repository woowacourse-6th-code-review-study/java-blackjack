package dto;

import domain.blackjack.GameResult;

public class PlayerGameResultDTO {
    private final String gamerName;
    private final GameResult gameResult;

    public PlayerGameResultDTO(String gamerName, GameResult gameResult) {
        this.gamerName = gamerName;
        this.gameResult = gameResult;
    }

    public String getGamerName() {
        return gamerName;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
