package com.tw.repository;

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
        Connection connection = dataSourceInstance.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into booking(user_id, status) " +
                "values(" + booking.getUserId() + "," + booking.getStatus() + ")");
        connection.close();
    }
}