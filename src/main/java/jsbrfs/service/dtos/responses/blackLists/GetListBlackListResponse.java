package jsbrfs.service.dtos.responses.blackLists;

import java.time.LocalDate;

public record GetListBlackListResponse(Long id,
                                       String reason,
                                       LocalDate date,
                                       Long applicantId) {
}
