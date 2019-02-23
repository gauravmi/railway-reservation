package demo;

import com.tw.models.Booking;
import demo.request.BookingRequest;
import demo.response.BookingResponse;
import demo.service.BookingService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static demo.response.BookingResponse.*;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingResourceTest {

    @Test
    void shouldMakeAReservation() {
        BookingService mockBookingService = mock(BookingService.class);
        when(mockBookingService.book(any(), any())).thenReturn(SUCCESS);

        BookingResource bookingResource = new BookingResource(mockBookingService);

        BookingRequest bookingRequest = new BookingRequest();
        BookingResponse response = bookingResource.book(bookingRequest);

        assertEquals(response, SUCCESS);
    }

    @Test
    void shouldListAllReservations() {
        BookingService mockBookingService = mock(BookingService.class);
        Booking booking = new Booking(
                "userid",
                "bookingid",
                "username",
                "fromstation",
                "tostation",
                "train"
        );

        List<Booking> expectedBookings = singletonList(booking);
        when(mockBookingService.findAll()).thenReturn(expectedBookings);

        BookingResource bookingResource = new BookingResource(mockBookingService);

        List<Booking> bookings = bookingResource.findAll();

        assertEquals(bookings, expectedBookings);
    }
}