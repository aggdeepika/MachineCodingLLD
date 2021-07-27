package VechileRenting.service.impl;
import VechileRenting.enums.BookingStatus;
import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;
import VechileRenting.exception.VechileNotAvailableException;
import VechileRenting.model.Booking;
import VechileRenting.model.User;
import VechileRenting.model.Vechile;
import VechileRenting.service.BookingService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BookingServiceImpl implements BookingService {

    Map<Vechile, Booking> bookingMap= new HashMap<Vechile,Booking>();

    DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY :HH:mm:ss");

    @Override
    public void BookVechile(Vechile vechile, User user, Date startDate, int duration) throws VechileNotAvailableException {

        Date end=new Date();
        end.setTime(startDate.getTime()+ TimeUnit.HOURS.toMillis(duration));


        if(vechile.getStatus()== VechileStatus.AVAILABLE ){

            Booking booking= new Booking();
            booking.setStarTime(startDate).setEndTime(end).setUser(user).setStatus(BookingStatus.IN_PROGRESS).setVechile(vechile);
            bookingMap.put(vechile,booking);
            System.out.println("Total no of bookings "+bookingMap.size());
            VechileType type= vechile.getVechileType();

                int total_rate=vechile.calculateRate(duration);
                vechile.setStatus(VechileStatus.BOOKED);


        }
        else
            throw new VechileNotAvailableException("Vechile is not available");



    }


    public void returnVechile(Vechile vechile, User user){
        if(Objects.nonNull(vechile)){
            vechile.setStatus(VechileStatus.AVAILABLE);
            bookingMap.remove(vechile);

        }

        System.out.println("Total no of bookings "+bookingMap.size());
    }

    @Override
    public void showRentedVechile() {
        if(Objects.nonNull(bookingMap)) {
            for (Map.Entry<Vechile, Booking> entry : bookingMap.entrySet()) {

                System.out.println("Vechile id is"+entry.getKey().getId());
                System.out.println("owner is"+entry.getValue().getUser().getName());
                System.out.println("Due date is id is"+entry.getValue().getEndTime());
            }

        }
    }


}
