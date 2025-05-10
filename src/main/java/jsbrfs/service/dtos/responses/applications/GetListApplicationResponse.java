package jsbrfs.service.dtos.responses.applications;

import jsbrfs.entity.enums.ApplicationState;

public record GetListApplicationResponse(Long id,
                                         Long applicantId,
                                         Long bootcampId,
                                         ApplicationState applicationState) {
}
