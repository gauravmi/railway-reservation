package com.tw.repository;

import com.tw.exception.DBSyncFailedException;
import com.tw.models.Booking;
import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingRepository {

    private PGPoolingDataSource dataSourceInstance;

    public BookingRepository(PGPoolingDataSource dataSourceInstance) {
        this.dataSourceInstance = dataSourceInstance;
    }

    public void insert(Booking booking) throws SQLException {
        try(Connection connection = dataSourceInstance.getConnection();
            Statement statement = connection.createStatement()) {

            statement.execute("insert into booking(user_id, name) " +
                    "values(\'" + booking.getUserId() + "\',\'" + booking.getName() + "\')");
        } catch (Exception e){
            throw new DBSyncFailedException("could not insert new record", e);
        }
    }

    public void close() {
        dataSourceInstance.close();
    }
}