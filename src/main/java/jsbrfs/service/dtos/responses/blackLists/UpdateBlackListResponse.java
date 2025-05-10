package jsbrfs.service.dtos.responses.blackLists;

import java.time.LocalDate;

public record UpdateBlackListResponse(Long id,
                                      Long applicantId,
                                      String reason,
                                      LocalDate date) {
}
