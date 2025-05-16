package jsbrfs.entity;

import jakarta.persistence.*;
import jsbrfs.core.entities.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "applicants")
@SQLRestriction(value = "deleted_at IS NULL") //silinmiş verileri geri gösterme
public class Applicant extends User {

    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "applicants",cascade = CascadeType.ALL)
    private List<Application> applications;


    @OneToMany(mappedBy = "applicants",cascade = CascadeType.ALL)
    private List<BlackList> blackLists;


    public Applicant(){}

    public Applicant(String about) {
        this.about = about;
    }

    public Applicant(String about, List<Application> applications, List<BlackList> blackLists) {
        this.about = about;
        this.applications = applications;
        this.blackLists = blackLists;
    }

    public Applicant(Long id, String userName, String firstName, String lastName, LocalDate dateOfBirth, String nationalIdentity, String email, String password, String about, List<Application> applications, List<BlackList> blackLists) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.about = about;
        this.applications = applications;
        this.blackLists = blackLists;
    }

    public List<BlackList> getBlackLists() {
        return blackLists;
    }

    public void setBlackLists(List<BlackList> blackLists) {
        this.blackLists = blackLists;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
