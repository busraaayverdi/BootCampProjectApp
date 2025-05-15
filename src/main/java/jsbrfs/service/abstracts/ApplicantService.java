package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.applicants.CreateApplicantRequest;
import jsbrfs.service.dtos.requests.applicants.UpdateApplicantRequest;
import jsbrfs.service.dtos.responses.applicants.*;

import java.util.List;

public interface ApplicantService {
    CreateApplicantResponse add(CreateApplicantRequest request);
    UpdateApplicantResponse update(UpdateApplicantRequest request);
    void delete(Long id);
    List<GetListApplicantResponse> getAll();
    GetByIdApplicantResponse getById(Long id);
}
