package jsbrfs.exceptions.details;

public class ProblemDetails {
    private String title;
    private String detail;
    private String status;
    private String type;

    public ProblemDetails() {
    }

    public ProblemDetails(String title, String detail, String status, String type) {
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
