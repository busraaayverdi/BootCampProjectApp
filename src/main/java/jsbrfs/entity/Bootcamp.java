package jsbrfs.entity;

import jakarta.persistence.*;
import jsbrfs.entity.enums.BootcampState;

import java.time.LocalDate;

@Entity
@Table(name = "bootcamps")
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "bootcampState")
    @Enumerated(EnumType.STRING)
    private BootcampState bootcampState;

    public Bootcamp() {
    }

    public Bootcamp(Long id, String name, Instructor instructor, LocalDate startDate, LocalDate endDate, BootcampState bootcampState) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }
}
