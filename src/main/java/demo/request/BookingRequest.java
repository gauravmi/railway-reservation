package demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class BookingRequest {
    @NotNull
    @JsonProperty
    private String userId;

    @NotNull
    @JsonProperty
    private String userName;

    @NotNull
    @JsonProperty
    private String fromStation;

    @NotNull
    @JsonProperty
    private String toStation;

    @NotNull
    @JsonProperty
    private String train;

    public BookingRequest(){}

    public BookingRequest(String userId, String userName, String fromStation, String toStation, String train) {
        this.userId = userId;
        this.userName = userName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.train = train;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getToStation() {
        return toStation;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getTrain() {
        return train;
    }
}
