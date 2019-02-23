package com.tw.models;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private String userId;
    private String bookingId;
    private String username;
    private String fromStation;
    private String toStation;
    private String train;

    static final long serialVersionUID = -687991492884005033L;

    public Booking(String userId, String bookingId, String username, String fromStation, String toStation, String train) {
        this.userId = userId;
        this.bookingId = bookingId;
        this.username = username;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.train = train;
    }

    public String getKey(){
        return String.format("%s_%s", userId, username);
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public String getToStation() {
        return toStation;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getTrain() {
        return train;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getUserId().equals(booking.getUserId()) &&
                getBookingId().equals(booking.getBookingId()) &&
                getUsername().equals(booking.getUsername()) &&
                getFromStation().equals(booking.getFromStation()) &&
                getToStation().equals(booking.getToStation()) &&
                getTrain().equals(booking.getTrain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getBookingId(), getUsername(), getFromStation(), getToStation(), getTrain());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", username='" + username + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", train='" + train + '\'' +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }
}
