package FoodOrderManagment.dao;



import FoodOrderManagment.contants.OrderStatus;
import FoodOrderManagment.exception.OrderDoesNotExist;
import FoodOrderManagment.exception.RestaurantDoesNotExist;
import FoodOrderManagment.model.Item;
import FoodOrderManagment.model.Menu;
import FoodOrderManagment.model.Order;
import FoodOrderManagment.model.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderManagmentDao {

    private FoodManagmentDao foodManagmentDao;
    private ResturantManager resturantManager;

    public OrderManagmentDao() {
    }

    public OrderManagmentDao(FoodManagmentDao foodManagmentDao, ResturantManager resturantManager) {
        this.foodManagmentDao = foodManagmentDao;
        this.resturantManager = resturantManager;
    }





    Map<String, Order> orderMap= new HashMap<String,Order>(); // map


    public void placeOrder(String orderId , List<String> itemName) throws RestaurantDoesNotExist {
        Order order=new Order();
        order.setOrderId(orderId).setOrderStatus(OrderStatus.PENDING).setItemList(itemName);



        Boolean resturantFlag=false;

        int min=Integer.MAX_VALUE;


        Map<String, Restaurant> restaurantMap= foodManagmentDao.getRestaurantMap();



        for(Map.Entry<String,Restaurant> entry: restaurantMap.entrySet()){
            Boolean flag=true;
            double sum=0;
            Restaurant result=null;
            Restaurant restaurant =entry.getValue();

            if(restaurant.getMAX_ORDER_CAPACAITY()>0){
                Menu menu=restaurant.getMenu();

              Map<String, Item>itemMap  =   menu.getItemMap();


              for(int i=0;i<itemName.size();i++){
                  if(!itemMap.containsKey(itemName.get(i))){
                      flag=false;
                      break;
                  }
                  else{

                      sum=sum+itemMap.get(itemName.get(i)).getPrice();
                  }
              }

              if(flag==true){
                  resturantFlag=true;

                  if(sum<min){
                      min= (int) sum;
                      result=entry.getValue();


                  }

              }

 result.setMAX_ORDER_CAPACAITY(result.getMAX_ORDER_CAPACAITY()-1);
              order.setRestaurant(result);


System.out.println("Order total is "+sum);
System.out.println("restaurant name is "+result.getRestaurantName());



            }
        }


        if(resturantFlag==false){
            throw new RestaurantDoesNotExist("There is no restaurant who can full fill the order");
        }
        orderMap.put(order.getOrderId(),order);


    }


    public void dispatchOrder(String orderId) throws OrderDoesNotExist {


        if(Objects.nonNull(orderMap)){


               if(orderMap.containsKey(orderId) && orderMap.get(orderId).getOrderStatus()==OrderStatus.PENDING ){
                    Order order=orderMap.get(orderId);
                    order.setOrderStatus(OrderStatus.DISPATCHED);
                    order.getRestaurant().setMAX_ORDER_CAPACAITY(order.getRestaurant().getMAX_ORDER_CAPACAITY()+1);

                    System.out.println("Dispatched order is"+order.toString());

                }

               else{
                   throw new OrderDoesNotExist("Order does not exist with this orderId");
               }
            }
        }

    }

