package demo.response;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {
    @NotNull
    @JsonProperty
    private String status;

    public static BookingResponse SUCCESS = new BookingResponse("BOOKED");
    public static BookingResponse FAILED = new BookingResponse("FAILED");

    public BookingResponse(){}

    public BookingResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
