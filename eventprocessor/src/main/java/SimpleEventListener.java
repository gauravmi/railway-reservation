import models.Booking;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import repository.BookingRepository;

import java.util.List;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

public class SimpleEventListener implements AsyncEventListener {
    private BookingRepository bookingRepository;
    private static Logger logger = getLogger(SimpleEventListener.class);

    public SimpleEventListener() {
        PGPoolingDataSource dataSourceInstance = JDBCConnection.getDataSourceInstance();
        bookingRepository = new BookingRepository(dataSourceInstance);
    }

    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        events.forEach(this::processEvent);
        return true;
    }

    private void processEvent(AsyncEvent event) {
        logger.info("Event received {}", event.getEventSequenceID());
        Booking booking = (Booking) event.getDeserializedValue();
        bookingRepository.insert(booking);
    }

    @Override
    public void close() { }
}
