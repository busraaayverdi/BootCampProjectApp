package jsbrfs.controller;

import jsbrfs.service.abstracts.ApplicantService;
import jsbrfs.service.dtos.requests.applicants.CreateApplicantRequest;
import jsbrfs.service.dtos.requests.applicants.UpdateApplicantRequest;
import jsbrfs.service.dtos.responses.applicants.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantsController {

    private final ApplicantService applicantService;

    public ApplicantsController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest request) {
        return ResponseEntity.ok(applicantService.add(request));
    }

    @PutMapping
    public ResponseEntity<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest request) {
        return ResponseEntity.ok(applicantService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        applicantService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetListApplicantResponse>> getAll() {
        return ResponseEntity.ok(applicantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdApplicantResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(applicantService.getById(id));
    }
}
