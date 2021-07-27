package VechileRenting.service;


import VechileRenting.exception.VechileNotAvailableException;
import VechileRenting.model.User;
import VechileRenting.model.Vechile;

import java.util.Date;

public interface BookingService {


    public void BookVechile(Vechile vechile, User user, Date startDate, int duration) throws VechileNotAvailableException;

    public  void returnVechile(Vechile vechile, User user);

    public void showRentedVechile();

}
