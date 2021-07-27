package VechileRenting.model;


import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;

public abstract class FourWheeler extends Vechile {
    public FourWheeler() {
    }

    public FourWheeler(String id, String brand, int rate, VechileStatus status, VechileType vechileType) {
        super(id, brand, rate, status);
        this.vechileType= VechileType.FOUR_WHEELER;
    }
}
