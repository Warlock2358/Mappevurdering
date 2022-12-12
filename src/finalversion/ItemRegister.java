package finalversion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store and retrieve items in the warehouse. It has methods for changing the
 * total number of items in storage and for retrieving the total number of items in storage. It also
 * has methods for retrieving the total number of items in storage for a specific category.
 *
 * @author Isak Mandal
 * @version 09.12.2022
 */
public class ItemRegister {

  private final ArrayList<Item> itemList;

  /**
   * This is the constructor for the ItemRegister. It takes in all the parameters that are needed to
   * create an object of this class.
   */
  public ItemRegister() {
    itemList = new ArrayList<>();
  }

  /**
   * This method is used to add an item to the itemList.
   *
   * @param itemNumber      The item number of the item. Must be a string. Can contain numbers and
   *                        letters
   * @param description     The description of the item. Must be a string.
   * @param price           The price of the item. Must be a positive integer.
   * @param discount        The discount of the item. Must be a positive integer.
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
    Item item3 = new Item(itemNumber, description, price, discount, brandName, weight, length,
        height, color, amountInStorage, categoryNumber);
    for (Item item : itemList) {
      if (item.getItemNumber().equalsIgnoreCase(item3.getItemNumber())) {
        throw new IllegalArgumentException("Item number already exists");
      }
    }
    itemList.add(item3);
  }

  /**
   * This method is used to get an item from the itemList based on the item number.
   *
   * @param itemNumber The item number of the item that is to be retrieved. Must be a string. Can
   *                   contain numbers and letters.
   * @return The item that has the item number that was entered.
   */
  public Item getItem(String itemNumber) {
    for (Item item : itemList) {
      if (itemNumber.equalsIgnoreCase(item.getItemNumber())) {
        return item;
      }
    }
    throw new IllegalArgumentException(
        "Based on the item number given, no item was found with a matching item number");
  }

  /**
   * This method is used to find an item based on the description.
   *
   * @param description The description of the item that is to be retrieved. Must be a string.
   * @return The item that has the description that was entered.
   */
  public Item getItemBasedOnDescription(String description) {
    try {
      for (Item item : itemList) {
        if (item.getDescription().equalsIgnoreCase(description)) {
          return item;
        }
      }
    } catch (IllegalArgumentException i) {
      throw new IllegalArgumentException("Based on the description given, no item was found with a "
          + "matching description");
    }
    return null;
  }

  /**
   * This method is used to get the itemList.
   *
   * @return The itemList.
   */
  public List<Item> getItemList() {
    ArrayList<Item> itemListCopy = new ArrayList<>();
    for (Item item : itemList) {
      Item itemCopy = new Item(item);
      itemListCopy.add(itemCopy);
    }
    itemListCopy.sort(new ItemNumberComparator());
    return itemListCopy;
  }

  /**
   * This method is used to get the itemList for a specific category.
   *
   * @param categoryNumber The category number of the category that is to be retrieved. Must be a
   * @return The itemList for the specific category.
   */
  public List<Item> getItemListForCategory(int categoryNumber) {
    ArrayList<Item> itemListCopy = new ArrayList<>();
    for (Item item : itemList) {
      if (item.getCategoryNumber() == categoryNumber) {
        Item itemCopy = new Item(item);
        itemListCopy.add(itemCopy);
      }
    }
    itemListCopy.sort(new ItemNumberComparator());
    return itemListCopy;
  }


  /**
   * This method is used to remove items form the itemList.
   *
   * @param itemNumber The item that is to be removed from the itemList.
   */
  public void removeItem(String itemNumber) {
    for (Item item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        itemList.remove(item);
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
    for (Item item : itemList) {
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
  public int getNumberOfItemsInCategory(int categoryNumber) {
    int totalNumberOfItemsInCategory = 0;
    for (Item item : itemList) {
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

  public void increaseAmountInStorage(String itemNumber, int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount to be added must be a positive integer");
    }
    Item item = getItem(itemNumber);
    if (item == null) {
      throw new IllegalArgumentException("Item number does not exist");
    }
    item.setAmountInStorage(item.getAmountInStorage() + amount);
  }

  /**
   * This method is used to decrease the total number of items in storage.
   *
   * @param itemNumber The item number of the item that is to be changed.
   * @param amount     The amount that the total number of items in storage is to be changed with.
   */
  public void decreaseAmountInStorage(String itemNumber, int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount to be removed must be a positive integer");
    }
    Item item = getItem(itemNumber);
    if (item == null) {
      throw new IllegalArgumentException("Item number does not exist");
    }
    item.setAmountInStorage(item.getAmountInStorage() - amount);
  }

  /**
   * This method is used to print a list of all the items in ascending order of price.
   *
   * @return Returns an ArrayList of all the items in ascending order of price.
   */
  public List<Item> sortItemsByAscendingPrice() {
    ArrayList<Item> itemListCopy = new ArrayList<>();
    for (Item item : itemList) {
      Item itemCopy = new Item(item);
      itemListCopy.add(itemCopy);
    }
    itemListCopy.sort(new IncreasingPriceComparator());
    return itemListCopy;
  }

  /**
   * This method is used to print a list of all the items in descending order of price.
   *
   * @return Returns an ArrayList of all the items in descending order of price.
   */
  public List<Item> sortItemsByDescendingPrice() {
    ArrayList<Item> itemListCopy = new ArrayList<>();
    for (Item item : itemList) {
      Item itemCopy = new Item(item);
      itemListCopy.add(itemCopy);
    }
    itemListCopy.sort(new DecreasingPriceComparator());
    return itemListCopy;
  }

  /**
   * This method is used to update the price of an item.
   *
   * @param itemNumber The item number of the item that is to be updated.
   * @param price      The new price of the item.
   */
  public void updatePrice(String itemNumber, double price) {
    for (Item item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setPrice(price);
      }
    }
  }

  /**
   * This method is used to set the discount an item.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   * @param discount   The discount of the item.
   */
  public void updateDiscount(String itemNumber, int discount) {
    for (Item item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setDiscount(discount);
      }
    }
  }

  /**
   * This method is used to remove the discount from an item and return it to the original value.
   *
   * @param itemNumber The item number of the item that is to be retrieved.
   */
  public void itemOffSale(String itemNumber) {
    for (Item item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setDiscount(0);
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
    for (Item item : itemList) {
      if (item.getItemNumber().equals(itemNumber)) {
        item.setDescription(description);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder itemListString = new StringBuilder();
    for (Item item : itemList) {
      itemListString.append(item.toString()).append("\n");
    }
    return itemListString.toString();
  }
}