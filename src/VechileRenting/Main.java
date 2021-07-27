package VechileRenting;



import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;
import VechileRenting.exception.VechileNotAvailableException;
import VechileRenting.model.Car;
import VechileRenting.model.MotorCycle;
import VechileRenting.model.User;
import VechileRenting.model.Vechile;
import VechileRenting.service.BookingService;
import VechileRenting.service.impl.BookingServiceImpl;

import java.util.Date;

public class Main {

    public static void main(String args[]) throws VechileNotAvailableException {

        BookingService bookingService= new BookingServiceImpl();

        User user= new User("Deepika","deeika.aggarwal@gmail.com");

        Vechile car= new Car("1","Sedan",20, VechileStatus.AVAILABLE, VechileType.FOUR_WHEELER);

        Vechile motorCycle= new MotorCycle("2","Yamaha",10,VechileStatus.AVAILABLE, VechileType.TWO_WHEELER);

        bookingService.BookVechile(car,user,new Date(),6);

        bookingService.showRentedVechile();
        bookingService.returnVechile(car,user);
        bookingService.showRentedVechile();







        //


    }
}
