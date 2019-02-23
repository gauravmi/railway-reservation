package com.tw.repository;


import com.tw.listener.JDBCConnection;
import com.tw.models.Booking;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class BookingRepositoryTest {

    @Test
    void shouldWriteToDatabase() {
        BookingRepository bookingRepository = new BookingRepository(JDBCConnection.getDataSourceInstance());
        try {
            bookingRepository.insert(new Booking("11", "from test"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}