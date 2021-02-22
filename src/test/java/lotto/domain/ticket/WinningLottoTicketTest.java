package lotto.domain.ticket;

import lotto.domain.Prize;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.WinningLottoTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {

    private static WinningLottoTicket winningTicket;

    @BeforeAll
    static void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningTicket = new WinningLottoTicket(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호 비교 결과 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,3,8,9,10,FIFTH", "1,2,3,4,8,9,FOURTH", "1,2,3,4,5,8,THIRD", "1,2,3,4,5,7,SECOND", "1,2,3,4,5,6,FIRST", "7,8,9,10,11,12,LOSING"})
    void 당첨_번호_비교_결과_테스트(int first, int second, int third, int fourth, int fifth, int sixth,
                         Prize expectedResult) {
        List<Integer> lottoNumbers = Arrays.asList(first, second, third, fourth, fifth, sixth);
        LottoTicket lottoTicket = LottoTicket.createLottoTicket(lottoNumbers);

        assertThat(winningTicket.compareNumbers(lottoTicket))
                .isEqualTo(expectedResult);
    }

    @DisplayName("보너스 숫자와 당첨 숫자 중복 테스트")
    @Test
    public void 보너스_숫자와_당첨_숫자_중복_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;
        assertThatThrownBy(() -> new WinningLottoTicket(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}