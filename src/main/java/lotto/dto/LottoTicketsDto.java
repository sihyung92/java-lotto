package lotto.dto;

import java.util.List;

public class LottoTicketsDto {
    private final List<LottoTicketDto> lottoTickets;

    public LottoTicketsDto(List<LottoTicketDto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets;
    }
}
