package FoodOrderManagment;



import FoodOrderManagment.Command.*;
import FoodOrderManagment.dao.FoodManagmentDao;
import FoodOrderManagment.dao.OrderManagmentDao;
import FoodOrderManagment.dao.ResturantManager;
import FoodOrderManagment.exception.*;
import FoodOrderManagment.model.Item;
import FoodOrderManagment.model.Menu;
import FoodOrderManagment.model.Restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    public static void main(String args[]) throws FileNotFoundException, RestaurantDoesNotExist, ItemDoesNotExist {

        PriorityQueue<Input> pq=new PriorityQueue<>((a, b)->a.getTime()-b.getTime());

        FoodManagmentDao food= new FoodManagmentDao();
        ResturantManager rest=new ResturantManager(food);
        OrderManagmentDao order= new OrderManagmentDao(food,rest);


        Item item1= new Item("item1",60);
        Item item2=new Item("item2",70);
        Item item11= new Item("item3",50);
     //   Item item22=new Item("item4",70);



        Map<String,Item> itemMap= new HashMap<String,Item>();
        itemMap.put(item1.getName(),item1);
        itemMap.put(item2.getName(),item2);
        itemMap.put(item11.getName(),item11);
      //  itemMap.put(item22.getName(),item22);
        Menu menu=new Menu(itemMap);

        Item item3= new Item("Dosa",40);
        Item item4=new Item("Noodles",60);

        Map<String,Item> itemMap2= new HashMap<String,Item>();
        itemMap2.put(item3.getName(),item3);
        itemMap2.put(item4.getName(),item4);
        Menu menu2=new Menu(itemMap2);





        Restaurant r1= new Restaurant("restaurant1",  2.0,menu);
        Restaurant r2= new Restaurant("restuarant 2",  2.0,menu2);


        try {
            food.addRestauranat(r1);
            //food.addRestauranat(r2);
        } catch (RestuarantAlreadyExistsException e) {
            e.printStackTrace();
        }

        // read inpput from file

        File file = new File("/src/FoodOrderManagment/Input.txt");
        Scanner sc= new Scanner(file);
        while(sc.hasNextLine()){
             String input= sc.nextLine();
             String[] inputArray=input.split(",");
             Input obj= new Input();
             obj.setTime(Integer.valueOf(inputArray[0]));
             obj.setAction(inputArray[1]);

             if(inputArray[1].trim().equals("place-order")){
                 PlaceOrderCommand placeOrderCommand=new PlaceOrderCommand();
                 placeOrderCommand.setOrderId(inputArray[2].trim());
                 List<String> itemList=new ArrayList<>();
                 for(int i=3;i<inputArray.length;i++){
                     itemList.add(inputArray[i].trim());
                 }
                 placeOrderCommand.setItemName(itemList);
                 obj.setInputCommand(placeOrderCommand);

             }
             else if(inputArray[1].trim().equals("update-price")){
                 UpdatePriceCommand updatePriceCommand=new UpdatePriceCommand();
                 updatePriceCommand.setRestaurantName(inputArray[2].trim());
                 updatePriceCommand.setItemName(inputArray[3].trim());
                 updatePriceCommand.setPrice(Double.parseDouble(inputArray[4]));
                 obj.setInputCommand(updatePriceCommand);


             }
             else if(inputArray[1].trim().equals("dispatch-order")){
                 DispatchOrderCommand dispatchOrderCommand=new DispatchOrderCommand();
                 dispatchOrderCommand.setOrderId(inputArray[2].trim());
                 obj.setInputCommand(dispatchOrderCommand);

             }
             else if(inputArray[1].trim().equals("add-items")){
                 AddItemCommand addItemCommand =new AddItemCommand();
                 addItemCommand.setRestaurantName(inputArray[2].trim());
                 addItemCommand.setItemName(inputArray[3].trim());
                 addItemCommand.setPrice(Double.parseDouble(inputArray[4]));
                 obj.setInputCommand(addItemCommand);

             }
             else if(inputArray[1].trim().equals("remove-items")){
                 RemoveItemCommand removeItemCommand=new RemoveItemCommand();
                 removeItemCommand.setRestaurantName(inputArray[2].trim());
                 removeItemCommand.setItemName(inputArray[3].trim());
                 obj.setInputCommand(removeItemCommand);

             }

             pq.add(obj);



    }

        // execute Commands

        while(!pq.isEmpty()){

            Input obj=pq.poll();
            String action= obj.getAction();

            if(action.trim().equals("place-order")){
                PlaceOrderCommand placeOrder= (PlaceOrderCommand) obj.getInputCommand();

                order.placeOrder(placeOrder.getOrderId(),placeOrder.getItemName());

            }
            else if(action.trim().equals("update-price")){
                UpdatePriceCommand updatePriceCommand= (UpdatePriceCommand) obj.getInputCommand();
                rest.updatePrice(updatePriceCommand.getRestaurantName(),updatePriceCommand.getItemName(),updatePriceCommand.getPrice());


            }
            else if(action.trim().equals("add-items")){
                AddItemCommand addItemCommand= (AddItemCommand) obj.getInputCommand();
                try {
                    rest.addItems(addItemCommand.getRestaurantName(),addItemCommand.getItemName(),addItemCommand.getPrice());
                } catch (ItemAlreadyExists itemAlreadyExists) {
                    itemAlreadyExists.printStackTrace();
                }

            }
            else if(action.trim().equals("dispatch-order")){
             DispatchOrderCommand dispatchOrderCommand= (DispatchOrderCommand) obj.getInputCommand();
                try {
                    order.dispatchOrder(dispatchOrderCommand.getOrderId());
                } catch (OrderDoesNotExist orderDoesNotExist) {
                    orderDoesNotExist.printStackTrace();
                }
            }
            else if(action.trim().equals("remove-items")){

                RemoveItemCommand removeItemCommand = (RemoveItemCommand) obj.getInputCommand();
                rest.removeItems(removeItemCommand.getRestaurantName(),removeItemCommand.getItemName());

            }

        }


    }

}
