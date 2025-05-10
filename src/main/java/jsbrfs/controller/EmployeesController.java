package jsbrfs.controller;

import jsbrfs.service.abstracts.EmployeeService;
import jsbrfs.service.dtos.requests.employees.CreateEmployeeRequest;
import jsbrfs.service.dtos.requests.employees.UpdateEmployeeRequest;
import jsbrfs.service.dtos.responses.employees.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.add(request));
    }

    @PutMapping
    public ResponseEntity<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetListEmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdEmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }
}
