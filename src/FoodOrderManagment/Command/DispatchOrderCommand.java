package FoodOrderManagment.Command;

public class DispatchOrderCommand implements InputCommands{

    private String orderId;

    public DispatchOrderCommand() {
    }

    public DispatchOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public DispatchOrderCommand setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
