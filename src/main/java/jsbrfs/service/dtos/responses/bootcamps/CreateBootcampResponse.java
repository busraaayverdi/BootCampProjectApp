package jsbrfs.service.dtos.responses.bootcamps;

import jsbrfs.entity.enums.BootcampState;
import java.time.LocalDate;

public record CreateBootcampResponse(Long id,
                                     String name,
                                     Long instructorId,
                                     LocalDate startDate,
                                     LocalDate endDate,
                                     BootcampState bootcampState) {
}
