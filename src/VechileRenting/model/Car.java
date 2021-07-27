package VechileRenting.model;


import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;

public class Car extends FourWheeler{


    public Car() {
    }

    public Car(String id, String brand, int rate, VechileStatus status, VechileType vechileType) {
        super(id, brand, rate, status, vechileType);
    }

    @Override
    public int calculateRate(int duration) {

        int total_rate= this.rate*duration;
        return total_rate;
    }
}
