package ParkingLot.src;

public class Vechile {

    private String name;
    private VechileCategory category;

    public Vechile() {
    }

    public Vechile(String name, VechileCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VechileCategory getCategory() {
        return category;
    }

    public void setCategory(VechileCategory category) {
        this.category = category;
    }
}
