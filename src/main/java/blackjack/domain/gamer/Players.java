package blackjack.domain.gamer;

import blackjack.domain.card.Deck;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 8;

    private final List<Player> players;

    public Players(List<String> names) {
        validateNames(names);

        this.players = names.stream()
                .map(name -> new Player(new Name(name)))
                .toList();
    }

    private void validateNames(List<String> names) {
        validateDuplicate(names);
        validateCount(names.size());
    }

    private void validateCount(int count) {
        if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    "플레이어는 최소 " + MIN_PLAYER_COUNT + "명에서 최대 " + MAX_PLAYER_COUNT + "명까지 가능합니다"
            );
        }
    }

    private void validateDuplicate(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);

        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public void initAllPlayersCard(Deck deck) {
        players.forEach(player -> player.initCard(deck));
    }

    public Map<Name, GameResult> collectPlayerGameResults(int dealerScore) {
        Map<Name, GameResult> playerGameResults = new LinkedHashMap<>();
        players.forEach(player -> playerGameResults.put(player.getName(), player.isWin(dealerScore)));

        return playerGameResults;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }
}
