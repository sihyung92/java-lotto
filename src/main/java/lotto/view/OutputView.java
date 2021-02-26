package lotto.view;

import lotto.domain.Prize;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketDto;
import lotto.dto.LottoTicketsDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INFORM_SIZE_MSG = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DASHES = "---------";
    private static final String INFORM_RESULT_AND_BONUS_MSG_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String INFORM_RESULT_MSG_FORMAT = "%d개 일치(%d원) - %d개";
    private static final String INFORM_PROFIT_RATIO_MSG_FORMAT = "총 수익률은 %d%%입니다.";
    private static final String COMMA = ",";
    private static final String TICKET_PREFIX = "[";
    private static final String TICKET_SUFFIX = "]";

    public void printTicketsSize(int manualSize, int autoSize) {
        System.out.printf(INFORM_SIZE_MSG, manualSize, autoSize);
    }

    public void printAllLottoTickets(LottoTicketsDto lottoTicketsDto) {
        lottoTicketsDto.getLottoTickets().forEach(lottoTicket ->
                System.out.println(makeEachLottoTicketToString(lottoTicket))
        );
    }

    private String makeEachLottoTicketToString(LottoTicketDto lottoTicketDto) {
        return lottoTicketDto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA, TICKET_PREFIX, TICKET_SUFFIX));
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DASHES);
        printWinningResult(lottoResultDto);
        printProfitRatio(lottoResultDto.getProfitPercent());
    }

    public void printWinningResult(LottoResultDto lottoResultDto) {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.LOSING)
                .sorted(Comparator.comparing(Prize::getRank))
                .sorted(Comparator.reverseOrder())
                .forEach(prize ->
                        System.out.println(makeWinningResultMessage(prize, lottoResultDto))
                );
    }

    public String makeWinningResultMessage(Prize prize, LottoResultDto lottoResultDto) {
        return String.format(findFormat(prize), prize.getMatchCount(), prize.getPrizeMoney(),
                lottoResultDto.getPrizeAndCount().getOrDefault(prize, 0L));
    }

    public String findFormat(Prize prize) {
        if (Prize.SECOND == prize) {
            return INFORM_RESULT_AND_BONUS_MSG_FORMAT;
        }
        return INFORM_RESULT_MSG_FORMAT;
    }

    public void printProfitRatio(long profitPercentage) {
        System.out.printf(INFORM_PROFIT_RATIO_MSG_FORMAT, profitPercentage);
    }
}
