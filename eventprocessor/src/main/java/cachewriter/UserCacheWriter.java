import org.apache.geode.cache.*;

public class UserCacheWriter implements CacheWriter<String, String> {
    @Override
    public void beforeUpdate(EntryEvent<String, String> event) throws CacheWriterException {

    }

    @Override
    public void beforeCreate(EntryEvent<String, String> event) throws CacheWriterException {
        String newValue = event.getNewValue();

    }

    @Override
    public void beforeDestroy(EntryEvent<String, String> event) throws CacheWriterException {

    }

    @Override
    public void beforeRegionDestroy(RegionEvent<String, String> event) throws CacheWriterException {

    }

    @Override
    public void beforeRegionClear(RegionEvent<String, String> event) throws CacheWriterException {

    }

    @Override
    public void close() {

    }
}
