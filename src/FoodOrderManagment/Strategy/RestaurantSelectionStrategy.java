package FoodOrderManagment.Strategy;

public class RestaurantSelectionStrategy  implements  Strategy{


    @Override
    public int execute(int price1, int price2) {

        return price1-price2;

    }
}
