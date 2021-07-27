package FoodOrderManagment.model;

public class Restaurant {


    private String restaurantName;

    private double rating;//

    private Menu menu;

    private int MAX_ORDER_CAPACAITY=10;

    public Restaurant() {
    }

    public Restaurant(String restaurantName,double rating, Menu menu) {
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.menu = menu;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Restaurant setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }


    public double getRating() {
        return rating;
    }

    public Restaurant setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

    public Restaurant setMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public int getMAX_ORDER_CAPACAITY() {
        return MAX_ORDER_CAPACAITY;
    }

    public Restaurant setMAX_ORDER_CAPACAITY(int MAX_ORDER_CAPACAITY) {
        this.MAX_ORDER_CAPACAITY = MAX_ORDER_CAPACAITY;
        return this;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", rating=" + rating +
                ", menu=" + menu +
                ", MAX_ORDER_CAPACAITY=" + MAX_ORDER_CAPACAITY +
                '}';
    }
}
