import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @DisplayName("숫자 + 숫자")
    @Test
    void 숫자카드_더하기_숫자카드() {
        // given
        int result = Application.cardScore("7", "8");
        // when

        // then
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("숫자 + 궁정")
    @Test
    void 숫자카드_더하기_궁정카드() {
        // given
        int result = Application.cardScore("4", "K");
        // when

        // then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("궁정 + 궁정")
    @Test
    void 궁정카드_더하기_궁정카드() {
        // given
        int result = Application.cardScore("K", "J");
        // when

        // then
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("A + 숫자")
    @Test
    void ACE_더하기_숫자카드() {
        // given
        int result = Application.cardScore("A", "3");
        // when

        // then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("A + A")
    @Test
    void ACE_더하기_ACE() {
        // given
        int result = Application.cardScore("A", "A");
        // when

        // then
        assertThat(result).isEqualTo(22);
    }

    @DisplayName("A + 궁정")
    @Test
    void ACE_더하기_궁정카드() {
        // given
        int result = Application.cardScore("A", "Q");
        // when

        // then
        assertThat(result).isEqualTo(21);
    }

    @DisplayName("카드 값이 1미만이면 예외를 발생한다.")
    @Test
    void 카드_값이_1미만면_예외를_발생한다() {
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateScore(0);
        });
    }

    @DisplayName("카드 값이 11초과면 예외를 발생한다.")
    @Test
    void 카드_값이_11초과면_예외를_발생한다() {
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateScore(12);
        });
    }
}
