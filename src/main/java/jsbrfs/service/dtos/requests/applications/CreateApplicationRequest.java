package jsbrfs.service.dtos.requests.applications;

import jsbrfs.entity.enums.ApplicationState;

public record CreateApplicationRequest(Long applicantId,
                                       Long bootcampId,
                                       ApplicationState applicationState) {
}
