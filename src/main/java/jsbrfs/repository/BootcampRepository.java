package jsbrfs.repository;

import jsbrfs.entity.Bootcamp;
import jsbrfs.entity.enums.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {
    List<Bootcamp> findByBootcampState(BootcampState bootcampState);
}
