package jsbrfs.controller;

import jsbrfs.service.abstracts.UserService;
import jsbrfs.service.dtos.requests.users.CreateUserRequest;
import jsbrfs.service.dtos.requests.users.UpdateUserRequest;
import jsbrfs.service.dtos.responses.users.CreateUserResponse;
import jsbrfs.service.dtos.responses.users.GetByIdUserResponse;
import jsbrfs.service.dtos.responses.users.GetListUserResponse;
import jsbrfs.service.dtos.responses.users.UpdateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListUserResponse> getUsers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdUserResponse getByIdUser(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse add(@PathVariable CreateUserRequest request){
        return service.add(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateUserResponse update(@PathVariable UpdateUserRequest request){
        return service.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
