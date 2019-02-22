package demo.repository;

import demo.models.Booking;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class GemfireRepository {
    private ClientCache cache;
    private Region<Object, Object> bookingRegion;

    public GemfireRepository() {
        cache = new ClientCacheFactory()
                .set("cache-xml-file", "client.xml")
                .setPdxReadSerialized(true)
                .setPdxSerializer(new ReflectionBasedAutoSerializer())
                .create();

        bookingRegion = cache.getRegion("booking");

    }

    public void write(String key, Booking booking) {
        bookingRegion.create(key, booking);
    }

    public void close(){
        cache.close();
    }
}
