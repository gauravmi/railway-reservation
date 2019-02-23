package demo.service;

import com.tw.models.Booking;
import demo.repository.GemfireRepository;
import demo.request.BookingRequest;
import demo.response.BookingResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.stubbing.answers.DoesNothing;

import java.util.Collections;
import java.util.List;

import static demo.response.BookingResponse.SUCCESS;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void shouldMakeABooking() {
        GemfireRepository mockGemfireRepository = mock(GemfireRepository.class);
        BookingRequest bookingRequest = new BookingRequest(
                "userId",
                "userName",
                "fromstation",
                "tostation",
                "train"
        );


        doNothing().when(mockGemfireRepository).write(any(), any());

        BookingService bookingService = new BookingService(mockGemfireRepository);


        BookingResponse response = bookingService.book(bookingRequest, "bookingId");
        assertEquals(response, SUCCESS);
    }

    @Test
    void shouldListAllBookings(){
        GemfireRepository mockGemfireRepository = mock(GemfireRepository.class);
        Booking booking = new Booking(
                "userid",
                "bookingId",
                "username",
                "fromstation",
                "tostation",
                "train"
        );

        List<Booking> expectedBookings = singletonList(booking);
        when(mockGemfireRepository.getAll()).thenReturn(expectedBookings);

        BookingService bookingService = new BookingService(mockGemfireRepository);
        List<Booking> bookings = bookingService.findAll();
        assertEquals(expectedBookings, bookings);
    }

}