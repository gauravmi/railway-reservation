package demo;

import demo.models.BookingRequest;
import demo.models.BookingResponse;
import demo.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/book")
    @PostMapping
    public BookingResponse book(BookingRequest bookingRequest) {
        return new BookingService().book(bookingRequest);
    }
}
