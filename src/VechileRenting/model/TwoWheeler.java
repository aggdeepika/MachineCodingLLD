package VechileRenting.model;


import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;

public  abstract class TwoWheeler extends Vechile {

    public TwoWheeler() {
    }

    public TwoWheeler(String id, String brand, int rate, VechileStatus status, VechileType vechileType) {
        super(id, brand, rate, status);
        this.vechileType= VechileType.TWO_WHEELER;
    }
}
