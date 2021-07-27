package ParkingLot.src;

public class ParkingSlot {

    private String name;
    boolean isAvailable=true;
    Vechile vechile;

    public ParkingSlot() {

    }

    public ParkingSlot(String name, boolean isAvailable, Vechile vechile) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.vechile = vechile;
    }

    public void addVechile(Vechile v){
        this.vechile=v;
        this.isAvailable=true;

    }

    public void removeVechile(Vechile v){
        this.vechile=v;
        this.isAvailable=false;
    }
}
