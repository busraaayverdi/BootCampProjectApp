package jsbrfs.service.dtos.requests.blackLists;

import java.time.LocalDate;

public record CreateBlackListRequest(Long applicantId,
                                     String reason,
                                     LocalDate date) {
}
