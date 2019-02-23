package demo.repository;

import com.tw.models.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GemfireRepositoryTest {
    private GemfireRepository gemfireRepository;

    @BeforeEach
    void setUp() {
        gemfireRepository = new GemfireRepository();
    }

    @Test
    void shouldWriteToGemfire() {
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
}