package demo;

import demo.request.BookingRequest;
import demo.response.BookingResponse;
import demo.service.BookingService;
import org.junit.jupiter.api.Test;

import static demo.response.BookingResponse.*;
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
}