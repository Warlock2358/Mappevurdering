package parttwo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store and retrieve items in the warehouse. It has methods for changing the
 * total number of items in storage and for retrieving the total number of items in storage. It also
 * has methods for retrieving the total number of items in storage for a specific category.
 *
 * @author Isak Mandal
 * @version 1.0
 */
public class ItemRegister {

  private ArrayList<EntityClass> itemList;

  /**
   * This is the constructor for the ItemRegister. It takes in all the parameters that are needed to
   * create an object of this class.
   */
  public ItemRegister() {
    itemList = new ArrayList<EntityClass>();
  }

  /**
   * This method is used to add an item to the itemList.
   *
   * @param itemNumber      The item number of the item. Must be a string. Can contain numbers and
   *                        letters
   * @param description     The description of the item. Must be a string.
   * @param price           The price of the item. Must be a positive integer.
   * @param brandName       The brand name of the item. Must be a string.
   * @param weight          The weight of the item. Must be a positive double.
   * @param length          The length of the item. Must be a positive double.
   * @param height          The height of the item. Must be a positive double.
   * @param color           The color of the item. Must be a string.
   * @param amountInStorage The amount of the item in storage. Must be a positive integer. It must
   *                        be greater than zero.
   * @param categoryNumber  The category number of the item. Must be a positive integer. It must be
   *                        between 1 and 4.
   */
  public void addItem(String itemNumber, String description, int price, String brandName,
      double weight, double length, double height, String color, int amountInStorage,
      int categoryNumber) {
    itemList.add(new EntityClass(itemNumber, description, price, brandName, weight, length, height,
        color, amountInStorage, categoryNumber));
  }

  /**
   * This method is used to get the itemList.
   *
   * @return The itemList.
   */
  public List<EntityClass> getItemList() {
    itemList = new ArrayList<EntityClass>();
    for (EntityClass item : itemList) {
      itemList.add(item);
    }
    return itemList;
  }

  /**
   * This method is used to get an item from the itemList.
   *
   * @param itemNumber The item number of the item that is to be retrieved. Must be a string. Can
   *                   contain numbers and letters.
   * @return The item that has the item number that was entered.
   */
  public EntityClass getItem(String itemNumber) {
    for (EntityClass item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        return item;
      }
    }
    return null;
  }

  /**
   * This method is used to remove items form the itemList.
   *
   * @param item The item that is to be removed from the itemList.
   */
  public void removeItem(EntityClass item) {
    itemList.remove(item);
  }

  /**
   * This method is used to get the total number of items in storage.
   *
   * @return The total number of items in storage.
   */
  public int getTotalNumberOfItems() {
    int totalNumberOfItems = 0;
    for (EntityClass item : itemList) {
      totalNumberOfItems += item.getAmountInStorage();
    }
    return totalNumberOfItems;
  }

  /**
   * This method is used to get the total number of items in storage for a specific category.
   *
   * @param categoryNumber The category number of the items that are to be counted.
   * @return The total number of items in storage for a specific category.
   */
  public int getTotalNumberOfItemsInCategory(int categoryNumber) {
    int totalNumberOfItemsInCategory = 0;
    for (EntityClass item : itemList) {
      if (item.getCategoryNumber() == categoryNumber) {
        totalNumberOfItemsInCategory += item.getAmountInStorage();
      }
    }
    return totalNumberOfItemsInCategory;
  }

  /**
   * This method is used to increase the total number of items in storage.
   *
   * @param itemNumber The item number of the item that is to be changed.
   * @param amount     The amount that the total number of items in storage is to be changed with.
   */
  public void increaseTotalNumberOfItems(String itemNumber, int amount) {
    for (EntityClass item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setAmountInStorage(item.getAmountInStorage() + amount);
      }
    }
  }

  /**
   * This method is used to decrease the total number of items in storage.
   *
   * @param itemNumber The item number of the item that is to be changed.
   * @param amount     The amount that the total number of items in storage is to be changed with.
   */
  public void decreaseTotalNumberOfItems(String itemNumber, int amount) {
    for (EntityClass item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setAmountInStorage(item.getAmountInStorage() - amount);
      }
    }
  }

  public String toString() {
    return "ItemRegister{" + "itemList=" + itemList + '}';
  }
}
