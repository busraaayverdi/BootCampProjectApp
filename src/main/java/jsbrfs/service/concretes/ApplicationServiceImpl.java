package jsbrfs.service.concretes;

import jsbrfs.entity.Application;
import jsbrfs.repository.ApplicationRepository;
import jsbrfs.service.abstracts.ApplicationService;
import jsbrfs.service.dtos.requests.applications.CreateApplicationRequest;
import jsbrfs.service.dtos.requests.applications.UpdateApplicationRequest;
import jsbrfs.service.dtos.responses.applications.CreateApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetByIdApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetListApplicationResponse;
import jsbrfs.service.dtos.responses.applications.UpdateApplicationResponse;
import jsbrfs.service.mappers.ApplicationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository repository;

    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateApplicationResponse add(CreateApplicationRequest request) {
        Application application = ApplicationMapper.INSTANCE.applicationFromCreateRequest(request);
        application = repository.save(application);
        return ApplicationMapper.INSTANCE.createResponseFromApplication(application);
    }

    @Override
    public UpdateApplicationResponse update(UpdateApplicationRequest request) {
        Application existing = repository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Application not found by id: " + request.id()));

        Application updated = ApplicationMapper.INSTANCE.applicationFromUpdateRequest(request);
        updated.setId(existing.getId());
        Application saved = repository.save(updated);

        return ApplicationMapper.INSTANCE.updateResponseFromApplication(saved);
    }

    @Override
    public void delete(Long id) {
        Application application = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found by id: " + id));

        repository.delete(application);
    }

    @Override
    public GetByIdApplicationResponse getById(Long id) {
        Application application = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found by id: " + id));
        return ApplicationMapper.INSTANCE.getByIdResponseFromApplication(application);
    }

    @Override
    public List<GetListApplicationResponse> getAll() {
        return repository.findAll().stream()
                .map(ApplicationMapper.INSTANCE::getListResponseFromApplication)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetListApplicationResponse> getByApplicantId(Long applicantId) {
        return repository.findByApplicantId(applicantId).stream()
                .map(ApplicationMapper.INSTANCE::getListResponseFromApplication)
                .collect(Collectors.toList());
    }
}
