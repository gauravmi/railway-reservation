package demo;

import com.tw.models.Booking;
import demo.request.BookingRequest;
import demo.response.BookingResponse;
import demo.service.BookingService;

import javax.ws.rs.*;

import java.util.List;

import static java.util.UUID.randomUUID;
import static javax.ws.rs.core.MediaType.*;

@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BookingResource {

    private BookingService bookingService;

    BookingResource(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GET
    @Path("index")
    public BookingResponse index(){
        return new BookingResponse("welcome");
    }

    @POST
    @Path("book")
    public BookingResponse book(BookingRequest bookingRequest) {
        return bookingService.book(bookingRequest, randomUUID().toString());
    }

    @Path("bookings")
    @GET
    public List<Booking> findAll() {
        return bookingService.findAll();
    }
}
