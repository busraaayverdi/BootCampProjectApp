package jsbrfs.service.concretes;

import jsbrfs.entity.Applicant;
import jsbrfs.exceptions.types.BusinessException;
import jsbrfs.repository.ApplicantRepository;
import jsbrfs.rules.ApplicantBusinessRules;
import jsbrfs.service.abstracts.ApplicantService;
import jsbrfs.service.dtos.requests.applicants.CreateApplicantRequest;
import jsbrfs.service.dtos.requests.applicants.UpdateApplicantRequest;
import jsbrfs.service.dtos.responses.applicants.CreateApplicantResponse;
import jsbrfs.service.dtos.responses.applicants.GetByIdApplicantResponse;
import jsbrfs.service.dtos.responses.applicants.GetListApplicantResponse;
import jsbrfs.service.dtos.responses.applicants.UpdateApplicantResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantBusinessRules applicantBusinessRules;
    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantBusinessRules applicantBusinessRules) {
        this.applicantRepository = applicantRepository;
        this.applicantBusinessRules = applicantBusinessRules;
    }


    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {

        applicantBusinessRules.checkIfUsernameAlreadyExists(request.getUserName());

        Applicant applicant = new Applicant();

        applicant.setUserName(request.getUserName());
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());
        applicant.setDateOfBirth(request.getDateOfBirth());
        applicant.setNationalIdentity(request.getNationalIdentity());
        applicant.setEmail(request.getEmail());
        applicant.setPassword(request.getPassword());

        applicant.setAbout(request.getAbout());

        applicant = applicantRepository.save(applicant);

        return mapToCreateApplicantResponse(applicant);
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest request) {
        applicantBusinessRules.checkIfApplicantExistsById(request.getId());

        Applicant applicant = applicantRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Applicant not found"));

        applicant.setUserName(request.getUserName());
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());

        applicant.setDateOfBirth(request.getDateOfBirth());
        applicant.setNationalIdentity(request.getNationalIdentity());
        applicant.setEmail(request.getEmail());
        applicant.setPassword(request.getPassword());

        applicant.setAbout(request.getAbout());

        applicant = applicantRepository.save(applicant);

        return mapToUpdateApplicantResponse(applicant);
    }

    @Override
    public void delete(Long id) {
        applicantBusinessRules.checkIfApplicantExistsById(id);

        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Applicant not found"));
        applicantRepository.delete(applicant);
    }

    @Override
    public GetByIdApplicantResponse getById(Long id) {
        applicantBusinessRules.checkIfApplicantExistsById(id);

        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Applicant not found"));

        return mapToGetByIdApplicantResponse(applicant);
    }

    @Override
    public List<GetListApplicantResponse> getAll() {
        return applicantRepository.findAll().stream()
                .map(this::mapToGetListApplicantResponse)
                .collect(Collectors.toList());
    }

    // Mapping methods
    private CreateApplicantResponse mapToCreateApplicantResponse(Applicant applicant) {
        return new CreateApplicantResponse(
                applicant.getId(),
                applicant.getUserName(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getAbout()
        );
    }

    private UpdateApplicantResponse mapToUpdateApplicantResponse(Applicant applicant) {
        return new UpdateApplicantResponse(
                applicant.getId(),
                applicant.getUserName(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getAbout()
        );
    }

    private GetListApplicantResponse mapToGetListApplicantResponse(Applicant applicant) {
        return new GetListApplicantResponse(
                applicant.getId(),
                applicant.getUserName(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getAbout()
        );
    }

    private GetByIdApplicantResponse mapToGetByIdApplicantResponse(Applicant applicant) {
        return new GetByIdApplicantResponse(
                applicant.getId(),
                applicant.getUserName(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getAbout()
        );
    }
}


