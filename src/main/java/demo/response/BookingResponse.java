package demo.response;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingResponse that = (BookingResponse) o;
        return Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus());
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "status='" + status + '\'' +
                '}';
    }
}
