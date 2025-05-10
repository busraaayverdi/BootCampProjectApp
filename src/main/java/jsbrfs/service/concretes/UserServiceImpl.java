package jsbrfs.service.concretes;

import jsbrfs.core.entities.User;
import jsbrfs.repository.UserRepository;
import jsbrfs.service.abstracts.UserService;
import jsbrfs.service.dtos.requests.users.CreateUserRequest;
import jsbrfs.service.dtos.requests.users.UpdateUserRequest;
import jsbrfs.service.dtos.responses.users.CreateUserResponse;
import jsbrfs.service.dtos.responses.users.GetByIdUserResponse;
import jsbrfs.service.dtos.responses.users.GetListUserResponse;
import jsbrfs.service.dtos.responses.users.UpdateUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user = repository.save(user);

        return mapToCreateUserResponse(user);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = repository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Not Found"));

        user.setUserName(request.getUserName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user = repository.save(user);

        return mapToUpdateUserResponse(user);
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        repository.delete(user);
    }

    @Override
    public List<GetListUserResponse> getAll() {
        List<User> userList = repository.findAll();

        return userList.stream().map(this::mapToGetListUserResponse)
                .collect(Collectors.toList());

    }

    @Override
    public GetByIdUserResponse getById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        return mapToGetByIdUserResponse(user);
    }


    private CreateUserResponse mapToCreateUserResponse(User user) {
        return new CreateUserResponse(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getNationalIdentity(),
                user.getEmail()
        );
    }

    private UpdateUserResponse mapToUpdateUserResponse(User user) {
        return new UpdateUserResponse(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getNationalIdentity(),
                user.getEmail()
        );
    }

    private GetListUserResponse mapToGetListUserResponse(User user) {
        return new GetListUserResponse(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getNationalIdentity(),
                user.getEmail()
        );
    }

    private GetByIdUserResponse mapToGetByIdUserResponse(User user) {
        return new GetByIdUserResponse(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getNationalIdentity(),
                user.getEmail()
        );
    }
}
