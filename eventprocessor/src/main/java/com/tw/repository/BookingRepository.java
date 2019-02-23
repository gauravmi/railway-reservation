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

            statement.execute(buildInsertStatement(booking)
            );

        } catch (Exception e){
            throw new DBSyncFailedException("could not insert new record", e);
        }
    }

    private String buildInsertStatement(Booking booking) {

        String query = "insert into booking(" +
                "user_id," +
                "booking_id," +
                "username," +
                "from_station," +
                "to_station," +
                "train) " +
                "values(" + "\'" +
                booking.getUserId() + "\',\'" +
                booking.getBookingId() + "\',\'" +
                booking.getUsername() + "\',\'" +
                booking.getFromStation() + "\',\'" +
                booking.getToStation() + "\',\'" +
                booking.getTrain() + "\'" +
                "" +
                ")";
        System.out.println("query = " + query);
        return query;
    }
}