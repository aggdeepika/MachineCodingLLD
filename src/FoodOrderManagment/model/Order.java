package FoodOrderManagment.model;



import FoodOrderManagment.contants.OrderStatus;

import java.util.List;

public class Order {

    private String orderId;

    private List<String> itemList;
    private OrderStatus orderStatus;

    private Restaurant restaurant;



    public Order() {
    }

    public Order(String orderId, List<String> itemList, OrderStatus orderStatus, Restaurant restaurant) {
        this.orderId = orderId;
        this.itemList = itemList;
        this.orderStatus = orderStatus;
        this.restaurant = restaurant;
    }

    public String getOrderId() {
        return orderId;
    }

    public Order setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public Order setItemList(List<String> itemList) {
        this.itemList = itemList;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", itemList=" + itemList +
                ", orderStatus=" + orderStatus +
                ", restaurant=" + restaurant +
                '}';
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }


}
