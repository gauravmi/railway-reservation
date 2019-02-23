package demo.service;

import com.tw.models.Booking;
import demo.repository.GemfireRepository;
import demo.request.BookingRequest;
import demo.response.BookingResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.stubbing.answers.DoesNothing;

import static demo.response.BookingResponse.SUCCESS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

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

}