package jsbrfs.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "blackLists")
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    public BlackList() {
    }

    public BlackList(Long id, String reason, LocalDate date, Applicant applicant) {
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
