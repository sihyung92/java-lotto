package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets){
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> list(){
        return new ArrayList<>(lottoTickets);
    }

    public int size(){
        return lottoTickets.size();
    }
}
