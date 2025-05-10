package jsbrfs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jsbrfs.core.entities.User;

import java.time.LocalDate;

@Entity
@Table(name = "applicants")
public class Applicant extends User {

    @Column(name = "about")
    private String about;

    public Applicant(){}

    public Applicant(String about) {
        this.about = about;
    }

    public Applicant(Long id, String userName, String firstName, String lastName, LocalDate dateOfBirth, String nationalIdentity, String email, String password, String about) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
