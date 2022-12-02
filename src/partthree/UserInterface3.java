package partthree;

import java.util.Scanner;


/**
 * This class is the user interface for the Warehouse management system. It has several methods that
 * interact with the user.
 *
 * @author Isak Mandal
 * @version 1.0
 */
public class UserInterface3 {

  private static final Scanner scanner = new Scanner(System.in);
  ItemRegister3 itemRegister3 = new ItemRegister3();

  /**
   * This is the main method for the UserInterface class. It is used to create an object of the
   * ItemRegister class. It also creates an object of the Scanner class. It then calls the menu
   * method.
   *
   * @param args The arguments that are entered when the program is run.
   */
  public static void main(String[] args) {
    UserInterface3 i = new UserInterface3();

    i.testData();
    i.start();
  }


  /**
   * This method is used to add test data to the itemRegister.
   */
  public void testData() {
    try {
      itemRegister3.addItem("100004", "Floor laminate", 1000, 0, "Laminate", 10, 10, 10, "White",
          10, 1);
      itemRegister3.addItem("100000", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Brown",
          100, 1);
      itemRegister3.addItem("100001", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Yellow",
          100, 1);
      itemRegister3.addItem("100002", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Green", 100, 1);
      itemRegister3.addItem("200000", "Window", 400, 0, "Window", 5, 100, 100, "White",
          100, 2);
      itemRegister3.addItem("200001", "Stained window", 400, 0, "Window", 5, 50, 50, "Black",
          100, 2);
      itemRegister3.addItem("200002", "Small window", 250, 0, "Window", 5, 50, 50, "White",
          100, 2);
      itemRegister3.addItem("300000", "Old door", 500, 0, "Door", 10, 100, 200, "White",
          100, 3);
      itemRegister3.addItem("300001", "Modern door", 500, 0, "Door", 10, 100, 200, "Black",
          100, 3);
      itemRegister3.addItem("300002", "Plain door", 500, 0, "Door", 10, 100, 200, "Brown",
          100, 3);
      itemRegister3.addItem("400000", "Planks", 100, 0, "Lumber", 10, 100, 100, "Brown",
          100, 4);
      itemRegister3.addItem("400001", "Planks", 300, 0, "Lumber", 10, 500, 500, "Yellow",
          100, 4);
      itemRegister3.addItem("400002", "Planks", 500, 0, "Lumber", 10, 1000, 1000, "Green",
          100, 4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to start the program. It calls the menu method.
   */
  public void start() {
    boolean running = true;

    while (running) {
      int choice = this.showMenu();
      UserChoice userChoice = UserChoice.getChoice(choice);

      if (userChoice != null) {
        switch (userChoice) {
          case REGISTER_ITEM -> this.addItem();
          case REMOVE_ITEM -> this.removeItem();
          case GET_ITEM -> this.getItem();
          case GET_ITEM_BY_DESCRIPTION -> this.getItemBasedOnDescription();
          case GET_ALL_ITEMS -> this.getItemList();
          case GET_ALL_ITEMS_IN_CATEGORY -> this.getAllItemsInCategory();
          case GET_NUMBER_OF_ITEMS -> this.getNumberOfItems();
          case GET_NUMBER_OF_ITEMS_BY_CATEGORY -> this.getNumberOfItemsInCategory();
          case INCREASE_AMOUNT_IN_STORAGE -> this.increaseAmountInStorage();
          case DECREASE_AMOUNT_IN_STORAGE -> this.decreaseAmountInStorage();
          case SORT_ITEMS_BY_ASCENDING_PRICE -> this.sortItemsByAscendingPrice();
          case SORT_ITEMS_BY_DESCENDING_PRICE -> this.sortItemsByDescendingPrice();
          case UPDATE_PRICE -> this.updatePrice();
          case UPDATE_DISCOUNT -> this.updateDiscount();
          case ITEM_OFF_SALE -> this.itemOffSale();
          case UPDATE_ITEM_DESCRIPTION -> this.updateItemDescription();
          case EXIT -> {
            System.out.println("Thank you for using the Warehouse management system.");
            running = false;
          }
          default -> System.out.println("Invalid choice. Please enter a number 1 and 17.");
        }
      }
    }
  }

  /**
   * This method is used to show the menu to the user. It then returns the choice that the user
   * entered.
   *
   * @return The choice that the user entered.
   */
  public int showMenu() {
    int menuChoice = 0;
    String ls = System.lineSeparator();
    System.out.println("\nWelcome to the Warehouse management system.");
    String menu = "1. Register item" + ls
        + "2. Remove item" + ls
        + "3. Get item" + ls
        + "4. Get item by description" + ls
        + "5. Get all items" + ls
        + "6. Get all items in category" + ls
        + "7. Get number of items" + ls
        + "8. Get number of items in category" + ls
        + "9. Increase amount in storage" + ls
        + "10. Decrease amount in storage" + ls
        + "11. Sort items by ascending price" + ls
        + "12. Sort items by descending price" + ls
        + "13. Update price" + ls
        + "14. Update discount" + ls
        + "15. Item off sale" + ls
        + "16. Update item description" + ls
        + "17. Exit";

    System.out.println(menu);
    System.out.print("Enter your choice: ");

    try {
      menuChoice = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid choice. Please enter a number 1 and 17.");
    }

    return menuChoice;
  }

  /**
   * This method is used to add an item to the warehouse.
   */
  public void addItem() {
    System.out.print("Enter item number (Between 1 and 9 characters): ");
    String itemNumber = scanner.nextLine();
    System.out.print("Enter description: ");
    String description = scanner.nextLine();
    System.out.print("Enter price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Enter discount: ");
    int discount = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter brand name: ");
    String brandName = scanner.nextLine();
    System.out.print("Enter weight: ");
    double weight = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Enter length: ");
    double length = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Enter height: ");
    double height = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Enter color: ");
    String color = scanner.nextLine();
    System.out.print("Enter amount in storage: ");
    int amountInStorage = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter category: ");
    int categoryChoice = scanner.nextInt();
    scanner.nextLine();
    ItemCategory itemCategory = ItemCategory.getCategory(categoryChoice);
    int category = 0;
    if (itemCategory != null) {
      switch (itemCategory) {
        case FLOOR_LAMINATES -> {
          category = 1;
          itemNumber = updateItemNumber(category, itemNumber);
        }
        case WINDOWS -> {
          category = 2;
          itemNumber = updateItemNumber(category, itemNumber);
        }
        case DOORS -> {
          category = 3;
          itemNumber = updateItemNumber(category, itemNumber);
        }
        case LUMBER -> {
          category = 4;
          itemNumber = updateItemNumber(category, itemNumber);
        }
        default -> System.out.println("Invalid choice. Please enter a number 1 and 4.");
      }
    }

    try {
      itemRegister3.addItem(itemNumber, description, price, discount, brandName, weight, length,
          height, color, amountInStorage, category);
      System.out.println("Item added successfully.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to write the item number in the correct format.
   *
   * @param category   The category of the item.
   * @param itemNumber The item number.
   * @return The item number in the correct format.
   */
  private String updateItemNumber(int category, String itemNumber) {
    int length = itemNumber.length();

    switch (length) {
      case 1 -> itemNumber = category + "0000" + itemNumber;
      case 2 -> itemNumber = category + "000" + itemNumber;
      case 3 -> itemNumber = category + "00" + itemNumber;
      case 4 -> itemNumber = category + "0" + itemNumber;
      case 5 -> itemNumber = category + itemNumber;
      default -> System.out.println(
          "Invalid item number. Please enter a number between 1 and 9 characters.");
    }
    return itemNumber;
  }

  /**
   * This method is used to remove an item from the warehouse.
   */
  public void removeItem() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    try {
      itemRegister3.removeItem(itemNumber);
      System.out.println("Item was successfully removed.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to get an item from the warehouse.
   */
  public void getItem() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    try {
      Item3 item = itemRegister3.getItem(itemNumber);
      System.out.println(item);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to get an item based on the description.
   */
  public void getItemBasedOnDescription() {
    System.out.print("Enter description: ");
    String description = scanner.nextLine();
    try {
      Item3 item = itemRegister3.getItemBasedOnDescription(description);
      System.out.println(item);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to get all items from the warehouse.
   */
  public void getItemList() {
    System.out.println("All items in the warehouse:");
    System.out.println(itemRegister3.getItemList());
  }

  /**
   * This method is used to get all the items in one category from the warehouse.
   */
  public void getAllItemsInCategory() {
    System.out.print("Enter category: ");
    int categoryChoice = scanner.nextInt();
    scanner.nextLine();
    ItemCategory itemCategory = ItemCategory.getCategory(categoryChoice);
    int category = 0;
    if (itemCategory != null) {
      switch (itemCategory) {
        case FLOOR_LAMINATES -> category = 1;
        case WINDOWS -> category = 2;
        case DOORS -> category = 3;
        case LUMBER -> category = 4;
        default -> System.out.println("Invalid choice. Please enter a number 1 and 4.");
      }
    }
    try {
      System.out.println(itemRegister3.getItemListForCategory(category));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to get the number of items in the warehouse.
   */
  public void getNumberOfItems() {
    System.out.println(
        "Number of items in the warehouse: " + itemRegister3.getTotalNumberOfItems());
  }

  /**
   * This method is used to get the number of items in the warehouse by category.
   */
  public void getNumberOfItemsInCategory() {
    System.out.print("Enter category: ");
    int categoryChoice = scanner.nextInt();
    scanner.nextLine();
    ItemCategory itemCategory = ItemCategory.getCategory(categoryChoice);
    int category = 0;
    if (itemCategory != null) {
      switch (itemCategory) {
        case FLOOR_LAMINATES -> category = 1;
        case WINDOWS -> category = 2;
        case DOORS -> category = 3;
        case LUMBER -> category = 4;
        default -> System.out.println("Invalid choice. Please enter a number 1 and 4.");
      }
    }
    try {
      assert itemCategory != null;
      System.out.println(
          "Number of items in the warehouse in the category " + itemCategory.getCategoryName()
              + ": " + itemRegister3.getNumberOfItemsInCategory(category));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to increase the amount of an item in the warehouse.
   */
  public void increaseAmountInStorage() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    System.out.print("Enter amount to increase: ");
    int amount = scanner.nextInt();
    scanner.nextLine();
    try {
      itemRegister3.increaseAmountInStorage(itemNumber, amount);
      System.out.println("Amount in storage was successfully increased.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to decrease the amount of an item in the warehouse.
   */
  public void decreaseAmountInStorage() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    System.out.print("Enter amount to decrease: ");
    int amount = scanner.nextInt();
    scanner.nextLine();
    try {
      itemRegister3.decreaseAmountInStorage(itemNumber, amount);
      System.out.println("Amount in storage was successfully decreased.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


  public void sortItemsByAscendingPrice() {
    System.out.println("Items sorted by ascending price:");
    System.out.println(itemRegister3.sortItemsByAscendingPrice());
  }

  public void sortItemsByDescendingPrice() {
    System.out.println("Items sorted by descending price:");
    System.out.println(itemRegister3.sortItemsByDescendingPrice());
  }

  /**
   * This method is used to update the price of an item in the warehouse.
   */
  public void updatePrice() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    System.out.print("Enter new price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();
    try {
      itemRegister3.updatePrice(itemNumber, price);
      System.out.println("Price was successfully updated.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to update the discount of an item in the warehouse.
   */
  public void updateDiscount() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    System.out.print("Enter new discount: ");
    int discount = scanner.nextInt();
    scanner.nextLine();
    try {
      itemRegister3.updateDiscount(itemNumber, discount);
      System.out.println("Discount was successfully updated.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to remove the discount of an item in the warehouse.
   */
  public void itemOffSale() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    try {
      itemRegister3.itemOffSale(itemNumber);
      System.out.println("Discount was successfully removed from the item.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is used to update the description of an item in the warehouse.
   */
  public void updateItemDescription() {
    System.out.print("Enter item number: ");
    String itemNumber = scanner.nextLine();
    System.out.println(
        "Here is the current description of the item: " + itemRegister3.getItem(itemNumber)
            .getDescription());
    System.out.print("Enter new description: ");
    String description = scanner.nextLine();
    try {
      itemRegister3.updateItemDescription(itemNumber, description);
      System.out.println("Description was successfully updated.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
