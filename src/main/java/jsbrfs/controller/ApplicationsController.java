package jsbrfs.controller;

import jsbrfs.service.abstracts.ApplicationService;
import jsbrfs.service.dtos.requests.applications.CreateApplicationRequest;
import jsbrfs.service.dtos.requests.applications.UpdateApplicationRequest;
import jsbrfs.service.dtos.responses.applications.CreateApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetByIdApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetListApplicationResponse;
import jsbrfs.service.dtos.responses.applications.UpdateApplicationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {
    private final ApplicationService applicationService;

    public ApplicationsController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListApplicationResponse> getAll() {
        return applicationService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdApplicationResponse getById(@PathVariable Long id) {
        return applicationService.getById(id);
    }

    @GetMapping("applicant/{applicantId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListApplicationResponse> getByApplicantId(@PathVariable Long applicantId) {
        return applicationService.getByApplicantId(applicantId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateApplicationResponse update(@RequestBody UpdateApplicationRequest request) {
        return applicationService.update(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateApplicationResponse add(@RequestBody CreateApplicationRequest request) {
        return applicationService.add(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        applicationService.delete(id);
    }
}
