package jsbrfs.service.dtos.requests.bootcamps;

import jsbrfs.entity.enums.BootcampState;
import java.time.LocalDate;

public record CreateBootcampRequest(String name,
                                    Long instructorId,
                                    LocalDate startDate,
                                    LocalDate endDate,
                                    BootcampState bootcampState) {
}
