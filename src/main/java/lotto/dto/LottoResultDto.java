package lotto.dto;

import lotto.domain.Prize;

import java.util.Map;

public class LottoResultDto {
    private final Map<Prize, Long> prizeAndCount;
    private final long profitPercent;

    public LottoResultDto(Map<Prize, Long> prizeAndCount, long profitPercent) {
        this.prizeAndCount = prizeAndCount;
        this.profitPercent = profitPercent;
    }

    public long getProfitPercent() {
        return profitPercent;
    }

    public Map<Prize, Long> getPrizeAndCount() {
        return prizeAndCount;
    }
}
