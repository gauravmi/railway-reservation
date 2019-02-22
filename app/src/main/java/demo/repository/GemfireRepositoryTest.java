package demo.repository;

import demo.models.Booking;
import org.junit.jupiter.api.Test;

public class GemfireRepositoryTest {

    @Test
    public void shouldWriteToGemfire(){
        GemfireRepository gemfireRepository = new GemfireRepository();
        Booking booking = new Booking("user1", "abcd1");
        gemfireRepository.write(booking);
        gemfireRepository.close();
    }
}