package demo.request;

import javax.validation.constraints.NotNull;

public class BookingRequest {
    @NotNull
    private String userId;

    @NotNull
    private String name;

    public BookingRequest(){}

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
