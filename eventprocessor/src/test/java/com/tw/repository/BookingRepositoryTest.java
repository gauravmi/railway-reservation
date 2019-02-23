package com.tw.repository;


import com.tw.listener.JDBCConnection;
import com.tw.models.Booking;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.UUID;

class BookingRepositoryTest {

    @Test
    void shouldWriteToDatabase() {
        BookingRepository bookingRepository = new BookingRepository(JDBCConnection.getDataSourceInstance());
        try {
            bookingRepository.insert(new Booking("12",
                    UUID.randomUUID().toString(),
                    "from test",
                    "from station",
                    "to station",
                    "train1"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}