package blackjack.domain.player;

import java.util.Objects;

public class PlayerName {

    private final String value;

    public PlayerName(String value) {
        validateNotEmpty(value);
        this.value = value;
    }

    private void validateNotEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름이 빈 문자열입니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
