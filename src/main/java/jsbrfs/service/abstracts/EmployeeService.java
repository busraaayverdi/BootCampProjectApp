package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.employees.CreateEmployeeRequest;
import jsbrfs.service.dtos.requests.employees.UpdateEmployeeRequest;
import jsbrfs.service.dtos.responses.employees.CreateEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.GetByIdEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.GetListEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    CreateEmployeeResponse add(CreateEmployeeRequest request);
    UpdateEmployeeResponse update(UpdateEmployeeRequest request);
    void delete(Long id);
    List<GetListEmployeeResponse> getAll();
    GetByIdEmployeeResponse getById(Long id);
}
