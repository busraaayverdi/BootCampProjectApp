package jsbrfs.repository;

import jsbrfs.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.applicant.userName = :username")
    List<Application> findByApplicantUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM applications WHERE applicantId = :applicantId", nativeQuery = true)
    List<Application> findByApplicantIdNative(@Param("applicantId") Long applicantId);
}
