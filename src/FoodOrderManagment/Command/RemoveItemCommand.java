package FoodOrderManagment.Command;

public class RemoveItemCommand implements InputCommands{

    private String restaurantName;
    private String itemName;

    public RemoveItemCommand() {
    }

    public RemoveItemCommand(String restaurantName, String itemName) {
        this.restaurantName = restaurantName;
        this.itemName = itemName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RemoveItemCommand setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public RemoveItemCommand setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }
}
