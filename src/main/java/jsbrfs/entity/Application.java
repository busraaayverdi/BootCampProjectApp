package jsbrfs.entity;

import jakarta.persistence.*;
import jsbrfs.entity.enums.ApplicationState;
import jsbrfs.entity.enums.BootcampState;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;

    @Column(name = "applicationState")
    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    public Application() {
    }

    public Application(Long id, Applicant applicant, Bootcamp bootcamp, ApplicationState applicationState) {
        this.id = id;
        this.applicant = applicant;
        this.bootcamp = bootcamp;
        this.applicationState = applicationState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
