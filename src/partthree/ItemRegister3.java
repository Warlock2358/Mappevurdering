package partthree;

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
public class ItemRegister3 {

  private final ArrayList<Item3> item3List;

  /**
   * This is the constructor for the ItemRegister. It takes in all the parameters that are needed to
   * create an object of this class.
   */
  public ItemRegister3() {
    item3List = new ArrayList<>();
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
  public void addItem(String itemNumber, String description, double price, int discount,
      String brandName,
      double weight, double length, double height, String color, int amountInStorage,
      int categoryNumber) {
    item3List.add(
        new Item3(itemNumber, description, price, discount, brandName, weight, length, height,
            color, amountInStorage, categoryNumber));
  }

  /**
   * This method is used to get an item from the itemList.
   *
   * @param itemNumber The item number of the item that is to be retrieved. Must be a string. Can
   *                   contain numbers and letters.
   * @return The item that has the item number that was entered.
   */
  public Item3 getItem(String itemNumber) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        return item3;
      }
    }
    return null;
  }

  /**
   * This method is used to get all the items in the itemList of a specific category.
   *
   * @return The itemList of a category.
   */
  public List<Item3> getCategoryItems(int categoryNumber) {
    List<Item3> categoryItem3s = new ArrayList<>();
    for (Item3 item3 : item3List) {
      if (item3.getCategoryNumber() == categoryNumber) {
        categoryItem3s.add(item3);
      }
    }
    return categoryItem3s;
  }

  /**
   * This method is used to get the itemList.
   *
   * @return The itemList.
   */
  public ArrayList<Item3> getItemList() {
    ArrayList<Item3> item3ListCopy = new ArrayList<>();
    for (Item3 item3 : item3List) {
      Item3 item3Copy = new Item3(item3);
      item3ListCopy.add(item3Copy);
    }
    return item3ListCopy;
  }


  /**
   * This method is used to remove items form the itemList.
   *
   * @param itemNumber The item that is to be removed from the itemList.
   */
  public void removeItem(String itemNumber) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3List.remove(item3);
        break;
      }
    }
  }

  /**
   * This method is used to get the total number of items in storage.
   *
   * @return The total number of items in storage.
   */
  public int getTotalNumberOfItems() {
    int totalNumberOfItems = 0;
    for (Item3 item3 : item3List) {
      totalNumberOfItems += item3.getAmountInStorage();
    }
    return totalNumberOfItems;
  }

  /**
   * This method is used to get the total number of items in storage for a specific category.
   *
   * @param categoryNumber The category number of the items that are to be counted.
   * @return The total number of items in storage for a specific category.
   */
  public int getNumberOfItemsInCategory(int categoryNumber) {
    int totalNumberOfItemsInCategory = 0;
    for (Item3 item3 : item3List) {
      if (item3.getCategoryNumber() == categoryNumber) {
        totalNumberOfItemsInCategory += item3.getAmountInStorage();
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
  public void increaseAmountInStorage(String itemNumber, int amount) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setAmountInStorage(item3.getAmountInStorage() + amount);
      }
    }
  }

  /**
   * This method is used to decrease the total number of items in storage.
   *
   * @param itemNumber The item number of the item that is to be changed.
   * @param amount     The amount that the total number of items in storage is to be changed with.
   */
  public void decreaseAmountInStorage(String itemNumber, int amount) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setAmountInStorage(item3.getAmountInStorage() - amount);
      }
    }
  }

  /**
   * This method is used to get the price of an item.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   * @return The price of the item. Or it returns 0 if the item is not found.
   */
  public double getPrice(String itemNumber) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        return item3.getPrice();
      }
    }
    return 0;
  }

  /**
   * This method is used to update the price of an item.
   *
   * @param itemNumber The item number of the item that is to be updated.
   */
  public void updatePrice(String itemNumber, double price) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setPrice(price);
      }
    }
  }

  /**
   * This method is used to get the discount of an item.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   * @return The discount of the item. Or it returns 0 if the item is not found.
   */
  public int getDiscount(String itemNumber) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        return item3.getDiscount();
      }
    }
    return 0;
  }

  /**
   * This method is used to set the discount an item.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   */
  public void updateDiscount(String itemNumber, int discount) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setDiscount(discount);
      }
    }
  }

  /**
   * This method is used to remove the discount from an item and return it to the original value.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   */
  public void itemOffSale(String itemNumber) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setDiscount(0);
      }
    }
  }

  /**
   * This method is used to set a new description for an item.
   *
   * @param itemNumber  The item number of the item that is to be retrieved.
   * @param description The new description of the item.
   */
  public void updateItemDescription(String itemNumber, String description) {
    for (Item3 item3 : item3List) {
      if (item3.getItemNumber().equals(itemNumber)) {
        item3.setDescription(description);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder itemListString = new StringBuilder();
    for (Item3 item3 : item3List) {
      itemListString.append(item3.toString()).append("\n");
    }
    return itemListString.toString();
  }
}