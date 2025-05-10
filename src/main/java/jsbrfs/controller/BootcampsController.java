package jsbrfs.controller;

import jsbrfs.entity.enums.BootcampState;
import jsbrfs.service.abstracts.BootcampService;
import jsbrfs.service.dtos.requests.bootcamps.CreateBootcampRequest;
import jsbrfs.service.dtos.requests.bootcamps.UpdateBootcampRequest;
import jsbrfs.service.dtos.responses.bootcamps.CreateBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.GetByIdBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.GetListBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.UpdateBootcampResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampsController {
    private final BootcampService bootcampService;

    public BootcampsController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBootcampResponse> getAll() {
        return bootcampService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdBootcampResponse getById(@PathVariable Long id) {
        return bootcampService.getById(id);
    }

    @GetMapping("state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBootcampResponse> getByState(@PathVariable BootcampState state) {
        return bootcampService.getByState(state);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateBootcampResponse update(@RequestBody UpdateBootcampRequest request) {
        return bootcampService.update(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBootcampResponse add(@RequestBody CreateBootcampRequest request) {
        return bootcampService.add(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        bootcampService.delete(id);
    }
}
