package jsbrfs.service.concretes;

import jsbrfs.entity.Employee;
import jsbrfs.repository.EmployeeRepository;
import jsbrfs.service.abstracts.EmployeeService;
import jsbrfs.service.dtos.requests.employees.CreateEmployeeRequest;
import jsbrfs.service.dtos.requests.employees.UpdateEmployeeRequest;
import jsbrfs.service.dtos.responses.employees.CreateEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.GetByIdEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.GetListEmployeeResponse;
import jsbrfs.service.dtos.responses.employees.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        Employee employee = mapToEmployee(request);
        employee = repository.save(employee);
        return mapToCreateResponse(employee);
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
        Employee employee = repository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        updateEmployeeFromRequest(employee, request);
        employee = repository.save(employee);
        return mapToUpdateResponse(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        repository.delete(employee);
    }

    @Override
    public GetByIdEmployeeResponse getById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToGetByIdResponse(employee);
    }

    @Override
    public List<GetListEmployeeResponse> getAll() {
        return repository.findAll().stream()
                .map(this::mapToGetListResponse)
                .collect(Collectors.toList());
    }



    private Employee mapToEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setUserName(request.getUserName());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setNationalIdentity(request.getNationalIdentity());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPosition(request.getPosition());
        return employee;
    }

    private void updateEmployeeFromRequest(Employee employee, UpdateEmployeeRequest request) {
        employee.setUserName(request.getUserName());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setNationalIdentity(request.getNationalIdentity());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        
        employee.setPosition(request.getPosition());
    }

    private CreateEmployeeResponse mapToCreateResponse(Employee employee) {
        return new CreateEmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPosition()
        );
    }

    private UpdateEmployeeResponse mapToUpdateResponse(Employee employee) {
        return new UpdateEmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPosition()
        );
    }

    private GetByIdEmployeeResponse mapToGetByIdResponse(Employee employee) {
        return new GetByIdEmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPosition()
        );
    }

    private GetListEmployeeResponse mapToGetListResponse(Employee employee) {
        return new GetListEmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPosition()
        );
    }
}
