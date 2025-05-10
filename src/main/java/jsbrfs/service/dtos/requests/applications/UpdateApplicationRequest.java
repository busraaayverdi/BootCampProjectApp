package jsbrfs.service.dtos.requests.applications;

import jsbrfs.entity.enums.ApplicationState;

public record UpdateApplicationRequest(Long id,
                                       Long applicantId,
                                       Long bootcampId,
                                       ApplicationState applicationState) {
}
