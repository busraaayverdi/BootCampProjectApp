package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.applications.CreateApplicationRequest;
import jsbrfs.service.dtos.requests.applications.UpdateApplicationRequest;
import jsbrfs.service.dtos.responses.applications.CreateApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetByIdApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetListApplicationResponse;
import jsbrfs.service.dtos.responses.applications.UpdateApplicationResponse;

import java.util.List;

public interface ApplicationService {
    CreateApplicationResponse add(CreateApplicationRequest request);
    UpdateApplicationResponse update(UpdateApplicationRequest request);
    void delete(Long id);

    GetByIdApplicationResponse getById(Long id);
    List<GetListApplicationResponse> getAll();
    List<GetListApplicationResponse> getByApplicantId(Long applicantId);
}
