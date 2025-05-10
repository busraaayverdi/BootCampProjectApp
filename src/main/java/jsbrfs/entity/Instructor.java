package jsbrfs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jsbrfs.core.entities.User;

import java.time.LocalDate;

@Entity
@Table(name = "instructors")
public class Instructor extends User {

    @Column(name = "companyName")
    private String companyName;

    public Instructor(){}

    public Instructor(String companyName) {
        this.companyName = companyName;
    }

    public Instructor(Long id, String userName, String firstName, String lastName, LocalDate dateOfBirth, String nationalIdentity, String email, String password, String companyName) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
