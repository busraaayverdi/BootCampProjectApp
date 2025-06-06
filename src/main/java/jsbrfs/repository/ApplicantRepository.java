package jsbrfs.repository;

import jsbrfs.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    boolean existsByUserName(String username);
}
