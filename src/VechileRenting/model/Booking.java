package VechileRenting.model;



import VechileRenting.enums.BookingStatus;

import java.util.Date;

public class Booking {

    private Vechile vechile;

    private User user;


    private Date starTime;

    private Date endTime;

    private BookingStatus status;

    public Booking() {
    }

    public Booking(Vechile vechile, User user, Date starTime, Date endTime, BookingStatus status) {
        this.vechile = vechile;
        this.user = user;
        this.starTime = starTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public Booking setVechile(Vechile vechile) {
        this.vechile = vechile;
        return this;
    }

    public Date getStarTime() {
        return starTime;
    }

    public Booking setStarTime(Date starTime) {
        this.starTime = starTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Booking setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Booking setUser(User user) {
        this.user = user;
        return this;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Booking setStatus(BookingStatus status) {
        this.status = status;
        return this;
    }
}
