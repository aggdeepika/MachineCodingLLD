package FoodOrderManagment.Command;

public class AddItemCommand implements InputCommands{

    private String restaurantName;
    private String itemName;

    private double price;

    public AddItemCommand() {
    }

    public AddItemCommand(String restaurantName, String itemName, double price) {
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public AddItemCommand setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public AddItemCommand setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AddItemCommand setPrice(double price) {
        this.price = price;
        return this;
    }
}
