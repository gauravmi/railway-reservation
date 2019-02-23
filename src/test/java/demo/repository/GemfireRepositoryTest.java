package demo.repository;

import com.tw.models.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GemfireRepositoryTest {
    private GemfireRepository gemfireRepository;

    @Test
    void shouldWriteToGemfire() {
        gemfireRepository = new GemfireRepository();
        Booking booking = new Booking("id",
                randomUUID().toString(),
                "user2",
                "from station",
                "to station",
                "train1");
        gemfireRepository.write(booking.getKey(), booking);
        gemfireRepository.close();

        TestGemfireClient testGemfireClient = new TestGemfireClient();
        Booking actualBooking = testGemfireClient.read(booking.getKey());
        assertEquals(booking, actualBooking);
        testGemfireClient.close();
    }

    @Test
    void shouldGetAllBookingsFromGemfire() {

        Booking booking = new Booking("id",
                randomUUID().toString(),
                "user2",
                "from station",
                "to station",
                "train1");
        TestGemfireClient testGemfireClient = new TestGemfireClient();
        testGemfireClient.write("key1", booking);
        Booking actualBooking = testGemfireClient.read("key1");

        testGemfireClient.close();

        gemfireRepository = new GemfireRepository();

        List<Booking> bookings = gemfireRepository.getAll();
        gemfireRepository.close();

        assertEquals(1, bookings.size());
        assertTrue(bookings.contains(actualBooking));
    }
}