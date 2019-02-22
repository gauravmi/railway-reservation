package demo.models;

public class BookingRequest {
    private String userId;
    private String name;

    public BookingRequest(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
