package jsbrfs.service.dtos.requests.blackLists;

import java.time.LocalDate;

public record UpdateBlackListRequest(Long id,
                                     Long applicantId,
                                     String reason,
                                     LocalDate date) {
}
