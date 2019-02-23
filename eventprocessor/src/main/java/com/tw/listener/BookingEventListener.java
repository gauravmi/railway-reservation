package com.tw.listener;

import com.tw.exception.DBSyncFailedException;
import com.tw.models.Booking;
import com.tw.repository.BookingRepository;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;

import java.util.List;

import static com.tw.listener.JDBCConnection.getDataSourceInstance;
import static org.slf4j.LoggerFactory.getLogger;

public class BookingEventListener implements AsyncEventListener {
    private static Logger logger = getLogger(BookingEventListener.class);

    public BookingEventListener() {}

    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        logger.info("processing event in booking event listener");
        events.forEach(this::processEvent);
        return true;
    }

    private void processEvent(AsyncEvent event) {
        logger.info("event de-serialized value {}", event.getDeserializedValue());
        logger.info("event key {}", event.getKey());
        logger.info("event operation {}", event.getOperation());
        if(isNotDuplicate(event)) {
            BookingRepository bookingRepository = new BookingRepository(getDataSourceInstance());
            syncToDatabase(event, bookingRepository);
        }
    }

    private boolean isNotDuplicate(AsyncEvent event) {
        return !event.getPossibleDuplicate();
    }

    private void syncToDatabase(AsyncEvent event, BookingRepository bookingRepository) {
        try {
            Booking booking = (Booking) event.getDeserializedValue();
            logger.info("inserting record with key {}", booking.getKey());
            bookingRepository.insert(booking);
            logger.info("inserted record with key {}", booking.getKey());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBSyncFailedException(e);
        }
    }

    @Override
    public void close() { }
}
