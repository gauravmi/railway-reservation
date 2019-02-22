package demo.service;

import demo.request.BookingRequest;
import demo.response.BookingResponse;

import static demo.response.BookingResponse.FAILED;
import static demo.response.BookingResponse.SUCCESS;

public class BookingService {

    public BookingResponse book(BookingRequest bookingRequest) {
        try{
            return SUCCESS;
        } catch(Exception e) {
            return FAILED;
        }
    }
}
