package jsbrfs.rules;

import jsbrfs.entity.Bootcamp;
import jsbrfs.entity.enums.BootcampState;
import jsbrfs.exceptions.types.BusinessException;
import jsbrfs.repository.BootcampRepository;
import jsbrfs.repository.InstructorRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootcampBusinessRules {

    private final BootcampRepository bootcampRepository;
    private final InstructorRepository instructorRepository;

    public BootcampBusinessRules(BootcampRepository bootcampRepository, InstructorRepository instructorRepository) {
        this.bootcampRepository = bootcampRepository;
        this.instructorRepository = instructorRepository;
    }

    // 1. Başlangıç tarihi, bitiş tarihinden önce olmalıdır
    public void checkIfStartDateBeforeEndDate(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new BusinessException("Bootcamp start date must be before end date.");
        }
    }

    // 2. Aynı isimde bootcamp daha önce açılmışsa tekrar açılamaz
    public void checkIfBootcampNameExists(String name) {
        boolean exists = bootcampRepository.existsByName(name);
        if (exists) {
            throw new BusinessException("A bootcamp with the same name already exists.");
        }
    }

    // 3. Eğitmen sistemde kayıtlı olmalıdır
    public void checkIfInstructorExistsById(Long instructorId) {
        boolean exists = instructorRepository.existsById(instructorId);
        if (!exists) {
            throw new BusinessException("Instructor not found.");
        }
    }

    // 4. Başvuru durumu "CLOSED" olan bootcamp'e başvuru alınamaz
    public void checkIfBootcampIsOpen(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new BusinessException("Bootcamp not found.");
        }
        if (bootcamp.getBootcampState() == BootcampState.CLOSED) {
            throw new BusinessException("Applications are closed for this bootcamp.");
        }
    }
}

