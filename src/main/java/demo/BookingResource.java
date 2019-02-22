package demo;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import demo.request.BookingRequest;
import demo.response.BookingResponse;
import demo.service.BookingService;

import javax.ws.rs.*;

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
        return bookingService.book(bookingRequest);
    }
}
