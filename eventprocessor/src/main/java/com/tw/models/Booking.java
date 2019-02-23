package com.tw.models;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private String userId;
    private String name;

    public Booking(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getKey(){
        return String.format("%s_%s", userId, name);
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getUserId().equals(booking.getUserId()) &&
                getName().equals(booking.getName());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName());
    }
}
