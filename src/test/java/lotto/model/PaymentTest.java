package lotto.model;

import lotto.exception.NotMultipleOfThousandException;
import lotto.exception.OverRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @ParameterizedTest
    @CsvSource(value = {"0", "999", "100001"})
    @DisplayName("Payment 범위가 초과 되었을 때")
    void Payment(int value) {
        assertThatThrownBy(() -> {
            new Payment(value);
        }).isInstanceOf(OverRangeException.class)
                .hasMessage("범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("Payment 단위가 천이 아닐 경우")
    void Payment_Unit_exception() {
        assertThatThrownBy(() -> {
            new Payment(9999);
        }).isInstanceOf(NotMultipleOfThousandException.class)
                .hasMessage("천 단위로 입력하세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "10000, 10", "33000, 33", "58000, 58"})
    @DisplayName("금액에 맞는 티켓 갯수 반환")
    void countTickets(int payment, int count) {
        assertThat(new Payment(payment).countTickets()).isEqualTo(count);
    }
}
