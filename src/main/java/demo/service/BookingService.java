package demo.service;

import com.tw.models.Booking;
import demo.repository.GemfireRepository;
import demo.request.BookingRequest;
import demo.response.BookingResponse;

import java.util.List;

import static demo.response.BookingResponse.FAILED;
import static demo.response.BookingResponse.SUCCESS;

public class BookingService {
    private GemfireRepository gemfireRepository;

    public BookingService(GemfireRepository gemfireRepository) {
        this.gemfireRepository = gemfireRepository;
    }

    public BookingResponse book(BookingRequest bookingRequest, String bookingId) {
        try{
            Booking booking = new Booking(
                    bookingRequest.getUserId(),
                    bookingId,
                    bookingRequest.getUserName(),
                    bookingRequest.getFromStation(),
                    bookingRequest.getToStation(),
                    bookingRequest.getTrain()
            );
            gemfireRepository.write(booking.getKey(), booking);
            return SUCCESS;
        } catch(Exception e) {
            return FAILED;
        }
    }

    public List<Booking> findAll() {
        return gemfireRepository.getAll();
    }
}
