package demo.repository;

import demo.models.Booking;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

class TestGemfireClient {
    private ClientCache cache;

    public TestGemfireClient() {
        cache = new ClientCacheFactory()
                .set("cache-xml-file", "test-client.xml")
                .setPdxReadSerialized(true)
                .setPdxSerializer(new ReflectionBasedAutoSerializer())
                .create();
    }

    Booking read(String key) {
        Region<Object, Object> region = cache.getRegion("booking");
        return (Booking) region.get(key);
    }

    public void close() {
        cache.close();
    }
}
