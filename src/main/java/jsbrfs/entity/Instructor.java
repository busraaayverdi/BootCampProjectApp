package jsbrfs.entity;

import jakarta.persistence.*;
import jsbrfs.core.entities.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "instructors")
@SQLRestriction(value = "deleted_at IS NULL") //silinmiş verileri geri gösterme

public class Instructor extends User {

    @Column(name = "companyName")
    private String companyName;

    @OneToMany(mappedBy = "instructors", cascade = CascadeType.ALL)
    private List<Bootcamp> bootcamps;

    public Instructor(){}

    public Instructor(Long id, String userName, String firstName, String lastName, LocalDate dateOfBirth, String nationalIdentity, String email, String password, String companyName) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    public Instructor(String companyName, List<Bootcamp> bootcamps) {
        this.companyName = companyName;
        this.bootcamps = bootcamps;
    }

    public List<Bootcamp> getBootcamps() {
        return bootcamps;
    }

    public void setBootcamps(List<Bootcamp> bootcamps) {
        this.bootcamps = bootcamps;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
