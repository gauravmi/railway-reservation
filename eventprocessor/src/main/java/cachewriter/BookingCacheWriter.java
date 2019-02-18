package cachewriter;

import org.apache.geode.cache.*;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class BookingCacheWriter extends CacheListenerAdapter implements Declarable {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public void afterCreate(EntryEvent e) {
        try {
            Driver driver = (Driver) Class.forName("org.postgresql.Driver").newInstance();
            connection = getConnection(url, username, password);

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        }

        System.out.println(connection);
    }

    public void init(Properties props) {
        this.url = props.getProperty("url");
        this.username = props.getProperty("user");
        this.password = props.getProperty("pass");
    }
}
