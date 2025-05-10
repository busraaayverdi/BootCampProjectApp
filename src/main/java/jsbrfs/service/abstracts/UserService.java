package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.users.CreateUserRequest;
import jsbrfs.service.dtos.requests.users.UpdateUserRequest;
import jsbrfs.service.dtos.responses.users.CreateUserResponse;
import jsbrfs.service.dtos.responses.users.GetByIdUserResponse;
import jsbrfs.service.dtos.responses.users.GetListUserResponse;
import jsbrfs.service.dtos.responses.users.UpdateUserResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse add(CreateUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    void delete(Long id);

    List<GetListUserResponse> getAll();
    GetByIdUserResponse getById(Long id);
}
