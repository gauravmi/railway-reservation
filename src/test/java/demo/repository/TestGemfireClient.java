package demo.repository;

import com.tw.models.Booking;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

class TestGemfireClient {
    private ClientCache cache;
    Region<Object, Object> bookingRegion;

    public TestGemfireClient() {
        cache = new ClientCacheFactory()
                .set("cache-xml-file", "test-client.xml")
                .setPdxReadSerialized(true)
                .setPdxSerializer(new ReflectionBasedAutoSerializer())
                .create();

        bookingRegion = cache.getRegion("booking");
    }

    Booking read(String key) {
        return (Booking) bookingRegion.get(key);
    }

    void write(String key, Booking booking) {
        bookingRegion.put(key, booking);
    }

    public void close() {
        cache.close();
    }
}
