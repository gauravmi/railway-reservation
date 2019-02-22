package demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class BookingRequest {
    @NotNull
    @JsonProperty
    private String userId;

    @NotNull
    @JsonProperty
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
