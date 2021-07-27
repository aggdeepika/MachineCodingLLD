package VechileRenting.model;


import VechileRenting.enums.VechileStatus;
import VechileRenting.enums.VechileType;

public abstract class Vechile {


    protected String id;
    protected String brand ;

    protected int rate;

    protected VechileStatus status=VechileStatus.AVAILABLE;

    protected VechileType vechileType;

    public Vechile() {
    }

    public Vechile(String id, String brand, int rate, VechileStatus status) {
        this.id = id;
        this.brand = brand;
        this.rate = rate;
        this.status = status;
    }

    public Vechile(String id, String brand, int rate, VechileStatus status, VechileType vechileType) {
        this.id = id;
        this.brand = brand;
        this.rate = rate;
        this.status = status;
        this.vechileType = vechileType;
    }

    public String getId() {
        return id;
    }

    public Vechile setId(String id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Vechile setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Vechile setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public VechileStatus getStatus() {
        return status;
    }

    public Vechile setStatus(VechileStatus status) {
        this.status = status;
        return this;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public Vechile setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
        return this;
    }

    public abstract int calculateRate(int duration);
}


