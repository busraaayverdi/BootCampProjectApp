package jsbrfs.rules;
import jsbrfs.exceptions.types.BusinessException;
import jsbrfs.entity.Applicant;
import jsbrfs.exceptions.types.BusinessException;
import jsbrfs.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicantBusinessRules {

    private final ApplicantRepository applicantRepository;

    // 1. ID ile var mı kontrolü
    public void checkIfApplicantExistsById(Long id) {
        if (!applicantRepository.existsById(id)) {
            throw new BusinessException("Applicant with id " + id + " does not exist.");
        }
    }

    // 2. Username ile var mı kontrolü
    public void checkIfApplicantExistsByUsername(String username) {
        if (!applicantRepository.existsByUserName(username)) {
            throw new BusinessException("Applicant with username '" + username + "' does not exist.");
        }
    }

    // 3. Null mı kontrolü (opsiyonel kullanım için)
    public void checkIfApplicantIsNull(Applicant applicant) {
        if (applicant == null) {
            throw new BusinessException("Applicant cannot be null.");
        }
    }

    // 4. Zaten kayıtlı mı? (örnek kural)
    public void checkIfUsernameAlreadyExists(String username) {
        if (applicantRepository.existsByUserName(username)) {
            throw new BusinessException("Username '" + username + "' is already taken.");
        }
    }
}

