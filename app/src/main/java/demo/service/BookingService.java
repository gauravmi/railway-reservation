package demo.service;

import demo.models.BookingRequest;
import demo.models.BookingResponse;

import static demo.models.BookingResponse.FAILED;
import static demo.models.BookingResponse.SUCCESS;

public class BookingService {

    public BookingResponse book(BookingRequest bookingRequest) {
        try{
            return SUCCESS;
        } catch(Exception e) {
            return FAILED;
        }
    }
}
