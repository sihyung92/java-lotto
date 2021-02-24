package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @DisplayName("로또번호가 숫자를 인자로 받아 생성되는지 테스트")
    @Test
    void 로또번호_생성_테스트() {
        int testNumber = 1;
        LottoNumber testLottoNumber = LottoNumber.createLottoNumber(testNumber);

        assertThat(testLottoNumber).isEqualTo(LottoNumber.createLottoNumber(testNumber));
    }
}