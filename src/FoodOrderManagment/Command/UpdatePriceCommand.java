package FoodOrderManagment.Command;

public class UpdatePriceCommand implements InputCommands{

    private String restaurantName;
    private String itemName;

    private double price;

    public UpdatePriceCommand() {
    }

    public UpdatePriceCommand(String restaurantName, String itemName, double price) {
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public UpdatePriceCommand setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public UpdatePriceCommand setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public UpdatePriceCommand setPrice(double price) {
        this.price = price;
        return this;
    }
}
