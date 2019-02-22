package demo.repository;

import demo.models.Booking;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GemfireRepositoryTest {
    private GemfireRepository gemfireRepository;
    private TestGemfireClient testGemfireClient;

    @BeforeEach
    void setUp() {
        gemfireRepository = new GemfireRepository();
    }

    @Test
    void shouldWriteToGemfire() {
        Booking booking = new Booking("id", "user1");
        gemfireRepository.write(booking.getKey(), booking);
        gemfireRepository.close();

        testGemfireClient = new TestGemfireClient();
        Booking actualBooking = testGemfireClient.read(booking.getKey());
        assertEquals(booking, actualBooking);
        testGemfireClient.close();
    }
}