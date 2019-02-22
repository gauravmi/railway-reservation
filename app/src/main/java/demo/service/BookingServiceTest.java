package demo.service;

import demo.models.BookingRequest;
import demo.models.BookingResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingServiceTest {

    @Test
    public void shouldReserveBooking(){
        BookingRequest bookingRequest = new BookingRequest("user1", "abc");
        BookingService bookingService = new BookingService();
        BookingResponse response = bookingService.book(bookingRequest);
        assertEquals(new BookingResponse("BOOKED"), response);
    }
}