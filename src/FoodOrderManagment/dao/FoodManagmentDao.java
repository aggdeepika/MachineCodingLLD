package FoodOrderManagment.dao;



import FoodOrderManagment.contants.ExceptionMessages;
import FoodOrderManagment.exception.RestuarantAlreadyExistsException;
import FoodOrderManagment.model.Restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FoodManagmentDao {

    private Map<String, Restaurant>  restaurantMap= new HashMap<String,Restaurant>();
    public Map<String, Restaurant> getRestaurantMap() {
        return restaurantMap;
    }

    public FoodManagmentDao setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        return this;
    }






    public void addRestauranat(Restaurant restuarant ) throws RestuarantAlreadyExistsException {

        if(Objects.nonNull(restuarant)){

            if(restaurantMap.containsKey(restuarant.getRestaurantName())){

              throw new RestuarantAlreadyExistsException(ExceptionMessages.RESRAURANT_ALREADY_EXISTES);
            }
            else{
                restaurantMap.put(restuarant.getRestaurantName(),restuarant);
            }


        }
    }







}
