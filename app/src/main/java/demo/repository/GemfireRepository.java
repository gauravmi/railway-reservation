package demo.repository;

import demo.models.Booking;
import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;

import java.util.UUID;

public class GemfireRepository {
    private Cache cache;

    public GemfireRepository() {
        cache = new CacheFactory()
                .set("cache-xml-file", "client.xml")
                .create();

    }

    public void write(Booking booking) {
        Region<Object, Object> bookingRegion = cache.getRegion("Booking");
        bookingRegion.create(UUID.randomUUID(), booking);
    }

    public void close(){
        cache.close();
    }
}
