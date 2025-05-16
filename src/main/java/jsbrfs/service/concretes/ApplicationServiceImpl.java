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
    private final ApplicationMapper applicationMapper;
    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository repository, ApplicationMapper applicationMapper, ApplicationRepository applicationRepository) {
        this.repository = repository;
        this.applicationMapper = applicationMapper;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public CreateApplicationResponse add(CreateApplicationRequest request) {
        Application application = applicationMapper.applicationFromCreateRequest(request);
        application = repository.save(application);
        return applicationMapper.createResponseFromApplication(application);
    }

    @Override
    public UpdateApplicationResponse update(UpdateApplicationRequest request) {
        Application existing = repository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Application not found by id: " + request.id()));

        Application updated = applicationMapper.applicationFromUpdateRequest(request);
        updated.setId(existing.getId());
        Application saved = repository.save(updated);

        return applicationMapper.updateResponseFromApplication(saved);
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
        return applicationMapper.getByIdResponseFromApplication(application);
    }

    @Override
    public List<GetListApplicationResponse> getAll() {
        return repository.findAll().stream()
                .map(applicationMapper::getListResponseFromApplication)
                .collect(Collectors.toList());
    }
    @Override
    public List<GetListApplicationResponse> getApplicationsByApplicantUsername(String username) {
        List<Application> applications = applicationRepository.findByApplicantUsername(username);
        return applications.stream()
                .map(applicationMapper::getListResponseFromApplication)
                .collect(Collectors.toList());
    }


    @Override
    public List<GetByIdApplicationResponse> getApplicationsByApplicantId(Long applicantId) {
        List<Application> applications = applicationRepository.findByApplicantIdNative(applicantId);
        return applications.stream()
                .map(applicationMapper::getByIdResponseFromApplication)
                .collect(Collectors.toList());
    }
}

