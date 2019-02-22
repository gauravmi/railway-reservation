package com.tw.cachewriter;

import com.tw.exception.DBSyncFailedException;
import com.tw.models.Booking;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import com.tw.repository.BookingRepository;

import java.sql.SQLException;
import java.util.List;

import static com.tw.cachewriter.JDBCConnection.getDataSourceInstance;
import static org.slf4j.LoggerFactory.getLogger;

final class BookingEventListener implements AsyncEventListener {
    private BookingRepository bookingRepository;
    private static Logger logger = getLogger(BookingEventListener.class);

    public BookingEventListener() {
        PGPoolingDataSource dataSourceInstance = getDataSourceInstance();
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
        try {
            bookingRepository.insert(booking);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBSyncFailedException(e);
        }
    }

    @Override
    public void close() { }
}
