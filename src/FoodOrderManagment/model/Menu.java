package FoodOrderManagment.model;

import java.util.HashMap;
import java.util.Map;

public class Menu{

 private Map<String,Item> itemMap= new HashMap<String,Item>();

 public Menu(Map<String, Item> itemMap) {
  this.itemMap = itemMap;
 }

 public Map<String, Item> getItemMap() {
  return itemMap;
 }

 public Menu setItemMap(Map<String, Item> itemMap) {
  this.itemMap = itemMap;
  return this;
 }

 @Override
 public String toString() {
  return "Menu{" +
          "itemMap=" + itemMap +
          '}';
 }
}
