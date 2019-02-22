package demo.models;

public class Booking {
    private String userId;
    private String status;

    public Booking(String userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }
}
