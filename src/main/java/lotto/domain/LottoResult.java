package lotto.domain;

import lotto.domain.machine.AutoLottoMachine;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private final Map<Prize, Long> lottoResult;

    public LottoResult(Map<Prize, Long> lottoResult) {
        this.lottoResult = new EnumMap<>(lottoResult);
    }

    public long calculatePrizeMoney() {
        return lottoResult.keySet().stream()
            .mapToLong(key -> key.getPrizeMoney() * lottoResult.get(key))
            .sum();
    }

    public long get(Prize prize){
        return lottoResult.getOrDefault(prize, 0L);
    }

    public long calculateProfitPercent(){
        return (calculatePrizeMoney() * 100)
                / ((long) lottoResult.values().size() * AutoLottoMachine.LOTTO_PRICE);
    }
}
