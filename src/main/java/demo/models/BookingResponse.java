package demo.models;

public class BookingResponse {
    private String status;

    public static BookingResponse SUCCESS = new BookingResponse("BOOKED");
    public static BookingResponse FAILED = new BookingResponse("FAILED");

    public BookingResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
