import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.slf4j.LoggerFactory.*;

public class SimpleEventListener implements AsyncEventListener {
    PGPoolingDataSource dataSourceInstance;
    private static Logger logger = getLogger(SimpleEventListener.class);

    public SimpleEventListener() {
        dataSourceInstance = JDBCConnection.getDataSourceInstance();
    }

    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        events.forEach(this::processEvent);
        return true;
    }

    private void processEvent(AsyncEvent event) {

    }

    @Override
    public void close() { }
}
