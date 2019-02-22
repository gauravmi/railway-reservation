package demo.models;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private String userId;
    private String status;

    public Booking(String userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public String getKey(){
        return String.format("%s_%s", userId, status);
    }

    public String getStatus() {
        return status;
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
                getStatus().equals(booking.getStatus());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getStatus());
    }
}
