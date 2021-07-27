package FoodOrderManagment.dao;



import FoodOrderManagment.contants.ExceptionMessages;
import FoodOrderManagment.exception.ItemAlreadyExists;
import FoodOrderManagment.exception.ItemDoesNotExist;
import FoodOrderManagment.exception.RestaurantDoesNotExist;
import FoodOrderManagment.model.Item;
import FoodOrderManagment.model.Menu;
import FoodOrderManagment.model.Restaurant;

import java.util.Map;
import java.util.Objects;

public class ResturantManager {


    private FoodManagmentDao foodManagmentDao;

    public ResturantManager() {

    }

    public ResturantManager(FoodManagmentDao foodManagmentDao) {
        this.foodManagmentDao = foodManagmentDao;
    }


    public void addItems(String resturantName, String itemName, double price) throws RestaurantDoesNotExist, ItemAlreadyExists {

        Map<String, Restaurant> restaurantMap = foodManagmentDao.getRestaurantMap();

        if (restaurantMap.containsKey(resturantName)) {
            Restaurant restaurant = restaurantMap.get(resturantName);
            Item item = new Item(itemName, price);
            Menu menu = restaurant.getMenu();

            Map<String,Item> itemMap= menu.getItemMap();

            if(itemMap.containsKey(itemName)){

                throw new ItemAlreadyExists(ExceptionMessages.ITEM_ALREADY_EXISTES);
            }
            else {
                itemMap.put(itemName,item);
                menu.setItemMap(itemMap);
                restaurant.setMenu(menu);
                restaurantMap.put(resturantName, restaurant);
                System.out.println("------------Add Items----------------");
                showMenu(menu);

            }

        } else {
            throw new RestaurantDoesNotExist(ExceptionMessages.RESRAURANT_NOT_EXISTES);
        }
    }


    public void updatePrice(String resturantName, String itemName, double price) throws RestaurantDoesNotExist, ItemDoesNotExist {
        Map<String, Restaurant> restaurantMap = foodManagmentDao.getRestaurantMap();
        if (restaurantMap.containsKey(resturantName)) {
            Restaurant restaurant = restaurantMap.get(resturantName);
            Menu menu = restaurant.getMenu();
            Map<String,Item> itemMap= menu.getItemMap();

            if(itemMap.containsKey(itemName)){
                Item item =itemMap.get(itemName);
                item.setPrice(price);
                itemMap.put(itemName,item);
                menu.setItemMap(itemMap);
                restaurant.setMenu(menu);
                System.out.println("------------Update  Price----------------");
                showMenu(menu);


            }
            else
                throw new ItemDoesNotExist(ExceptionMessages.ITEM_NOT_EXISTES);




        } else {
            throw new RestaurantDoesNotExist(ExceptionMessages.RESRAURANT_NOT_EXISTES);
        }


    }


    public void removeItems(String resturantName, String itemName) throws RestaurantDoesNotExist, ItemDoesNotExist {
        Map<String, Restaurant> restaurantMap = foodManagmentDao.getRestaurantMap();
        if (restaurantMap.containsKey(resturantName)) {
            Restaurant restaurant = restaurantMap.get(resturantName);
            Menu menu = restaurant.getMenu();
            Map<String,Item> itemMap= menu.getItemMap();
            if(itemMap.containsKey(itemName)){
               itemMap.remove(itemName);

                System.out.println("------------Remove  Item----------------");
                showMenu(menu);


            }
            else{
                throw new ItemDoesNotExist(ExceptionMessages.ITEM_NOT_EXISTES);

            }

        }
        else{
            throw new RestaurantDoesNotExist(ExceptionMessages.RESRAURANT_NOT_EXISTES);
        }

    }

    public void showMenu(Menu menu){
        if(Objects.nonNull(menu)){
            Map<String,Item> itemMap=menu.getItemMap();

            for(Map.Entry<String,Item> entry: itemMap.entrySet()){

                System.out.println("item name is"+entry.getKey());
                System.out.println("item is"+entry.getValue().toString());

            }
        }


    }


}
