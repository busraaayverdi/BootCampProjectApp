package jsbrfs.service.dtos.responses.applications;

import jsbrfs.entity.enums.ApplicationState;

public record UpdateApplicationResponse(Long id,
                                        Long applicantId,
                                        Long bootcampId,
                                        ApplicationState applicationState) {
}
