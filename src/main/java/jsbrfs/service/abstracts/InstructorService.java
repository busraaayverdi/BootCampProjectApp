package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.instructors.CreateInstructorRequest;
import jsbrfs.service.dtos.requests.instructors.UpdateInstructorRequest;
import jsbrfs.service.dtos.responses.instructors.CreateInstructorResponse;
import jsbrfs.service.dtos.responses.instructors.UpdateInstructorResponse;
import jsbrfs.service.dtos.responses.instructors.GetListInstructorResponse;
import jsbrfs.service.dtos.responses.instructors.GetByIdInstructorResponse;

import java.util.List;

public interface InstructorService {
    CreateInstructorResponse add(CreateInstructorRequest request);
    UpdateInstructorResponse update(UpdateInstructorRequest request);
    void delete(Long id);
    List<GetListInstructorResponse> getAll();
    GetByIdInstructorResponse getById(Long id);
}
