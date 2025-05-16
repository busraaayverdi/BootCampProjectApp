package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.applications.CreateApplicationRequest;
import jsbrfs.service.dtos.requests.applications.UpdateApplicationRequest;
import jsbrfs.service.dtos.responses.applicants.DeleteApplicantResponse;
import jsbrfs.service.dtos.responses.applications.*;

import java.util.List;

public interface ApplicationService {
    CreateApplicationResponse add(CreateApplicationRequest request);
    UpdateApplicationResponse update(UpdateApplicationRequest request);
    void delete(Long id);
    GetByIdApplicationResponse getById(Long id);
    List<GetListApplicationResponse> getAll();
    List<GetListApplicationResponse> getApplicationsByApplicantUsername(String username);
    List<GetByIdApplicationResponse> getApplicationsByApplicantId(Long applicantId);
    DeleteApplicationResponse softDelete(int id);


}
