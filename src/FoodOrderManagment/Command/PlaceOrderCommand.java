package FoodOrderManagment.Command;

import java.util.List;

public class PlaceOrderCommand implements InputCommands{

    private String orderId;
    private List<String> itemName;

    public PlaceOrderCommand() {
    }

    public PlaceOrderCommand(String orderId, List<String> itemName) {
        this.orderId = orderId;
        this.itemName = itemName;
    }

    public String getOrderId() {
        return orderId;
    }

    public PlaceOrderCommand setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<String> getItemName() {
        return itemName;
    }

    public PlaceOrderCommand setItemName(List<String> itemName) {
        this.itemName = itemName;
        return this;
    }
}
