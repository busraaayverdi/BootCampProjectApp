package jsbrfs.controller;

import jsbrfs.service.abstracts.InstructorService;
import jsbrfs.service.dtos.requests.instructors.CreateInstructorRequest;
import jsbrfs.service.dtos.requests.instructors.UpdateInstructorRequest;
import jsbrfs.service.dtos.responses.instructors.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorsController {

    private final InstructorService instructorService;

    public InstructorsController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.add(request));
    }

    @PutMapping
    public ResponseEntity<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instructorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetListInstructorResponse>> getAll() {
        return ResponseEntity.ok(instructorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdInstructorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getById(id));
    }
}
