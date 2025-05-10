package jsbrfs.service.dtos.responses.instructors;

public class GetListInstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;

    public GetListInstructorResponse() {
    }

    public GetListInstructorResponse(Long id, String firstName, String lastName, String email, String companyName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getters and setters
}
