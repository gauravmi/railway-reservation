package demo.repository;

import com.tw.models.Booking;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    public void clear(){
        bookingRegion.clear();
    }

    public void close(){
        cache.close();
    }

    public List<Booking> getAll() {
        Set<Object> keys = bookingRegion.keySetOnServer();
        Map<Object, Object> regionValueEntries = bookingRegion.getAll(keys);
        return regionValueEntries.values()
                .stream()
                .map((value) -> (Booking) value)
                .collect(toList());
    }
}
