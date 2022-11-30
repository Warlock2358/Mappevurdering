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

  public void testData() {
    try {
      itemRegister3.addItem("123456789", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Brown",
          100, 1);
      itemRegister3.addItem("123456788", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Yellow",
          100, 1);
      itemRegister3.addItem("123456787", "Floor laminate", 100, 0, "Laminate", 10, 100, 100,
          "Green", 100, 1);
      itemRegister3.addItem("000000001", "Window", 400, 0, "Window", 5, 100, 100, "White",
          100, 2);
      itemRegister3.addItem("000000002", "Stained window", 400, 0, "Window", 5, 50, 50, "Black",
          100, 2);
      itemRegister3.addItem("000000003", "Small window", 250, 0, "Window", 5, 50, 50, "White",
          100, 2);
      itemRegister3.addItem("000010000", "Old door", 500, 0, "Door", 10, 100, 200, "White",
          100, 3);
      itemRegister3.addItem("000010001", "Modern door", 500, 0, "Door", 10, 100, 200, "Black",
          100, 3);
      itemRegister3.addItem("000010002", "Plain door", 500, 0, "Door", 10, 100, 200, "Brown",
          100, 3);
      itemRegister3.addItem("001000000", "Planks", 100, 0, "Lumber", 10, 100, 100, "Brown",
          100, 4);
      itemRegister3.addItem("001000001", "Planks", 300, 0, "Lumber", 10, 500, 500, "Yellow",
          100, 4);
      itemRegister3.addItem("001000002", "Planks", 500, 0, "Lumber", 10, 1000, 1000, "Green",
          100, 4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

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
          case GET_ALL_ITEMS -> this.getItemList();
          case GET_NUMBER_OF_ITEMS -> this.getNumberOfItems();
          case GET_NUMBER_OF_ITEMS_BY_CATEGORY -> this.getNumberOfItemsInCategory();
          case INCREASE_AMOUNT_IN_STORAGE -> this.increaseAmountInStorage();
          case DECREASE_AMOUNT_IN_STORAGE -> this.decreaseAmountInStorage();
          case UPDATE_PRICE -> this.updatePrice();
          case UPDATE_DISCOUNT -> this.updateDiscount();
          case ITEM_OFF_SALE -> this.itemOffSale();
          case EXIT -> {
            System.out.println("Thank you for using the Warehouse management system.");
            running = false;
          }
          default -> System.out.println("Invalid choice. Please enter a number 1 and 12.");
        }
      }
    }
  }

  public int showMenu() {
    int menuChoice = 0;
    String ls = System.lineSeparator();
    System.out.println("Welcome to the Warehouse management system.");
    String menu = "1. Register item" + ls
        + "2. Remove item" + ls
        + "3. Get item" + ls
        + "4. Get all items" + ls
        + "5. Get number of items" + ls
        + "6. Get number of items by category" + ls
        + "7. Increase amount in storage" + ls
        + "8. Decrease amount in storage" + ls
        + "9. Update price" + ls
        + "10. Update discount" + ls
        + "11. Item off sale" + ls
        + "12. Exit";

    System.out.println(menu);
    System.out.print("Enter your choice: ");

    try {
      menuChoice = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid choice. Please enter a number 1 and 12.");
    }

    return menuChoice;
  }

  /**
   * This method is used to add an item to the warehouse.
   */
  public void addItem() {
    System.out.print("Enter item number: ");
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
        case FLOOR_LAMINATES -> category = 1;
        case WINDOWS -> category = 2;
        case DOORS -> category = 3;
        case LUMBER -> category = 4;
        default -> System.out.println("Invalid choice. Please enter a number 1 and 4.");
      }
    }

    try {
      itemRegister3.addItem(itemNumber, description, price, discount, brandName, weight, length,
          height, color, amountInStorage, category);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
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
   * This method is used to get all items from the warehouse.
   */
  public void getItemList() {
    System.out.println("All items in the warehouse:");
    System.out.println(itemRegister3.getItemList());
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
//   {
//     Scanner scanner = new Scanner(System.in);
//     ItemRegister3 itemRegister3 = new ItemRegister3();
//     String input = "";
//     while (!input.equals("quit")) {
//       System.out.println("Enter a command: ");
//       input = scanner.nextLine();
//       switch (input) {
//         case "help" -> {
//           System.out.println("Commands: ");
//           System.out.println("help - shows this message");
//           System.out.println("register - registers a new item");
//           System.out.println("get - gets an item");
//           System.out.println("getAll - gets all items");
//           System.out.println("remove - removes an item");
//           System.out.println("getNumItem - gets the total number of items");
//           System.out.println("getNumItemCat - gets the total number of items in a category");
//           System.out.println("incNumItem - increases the total number of items");
//           System.out.println("decNumItem - decreases the total number of items");
//           System.out.println("itemOffSale - removes the discount of an item");
//           System.out.println("quit - quits the program");
//         }
//         case "register" -> {
//           //          try {
// //            itemRegister3.addItem(itemNumber, description, price, discount, brandName, weight,
// //                length, height,
// //                color, amountInStorage, categoryNumber);
// //          } catch (Exception e) {
// //            System.out.println(e.getMessage());
// //          }
// //        case "get" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          System.out.println(itemRegister3.getItem(itemNumber));
// //        }
// //        case "getAll" -> System.out.println(itemRegister3.getItemList());
// //        case "remove" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          itemRegister3.removeItem(itemNumber);
// //        }
// //        case "getNumItem" -> System.out.println(itemRegister3.getTotalNumberOfItems());
// //        case "getNumItemCat" -> {
// //          System.out.println("Enter category number: ");
// //          int categoryNumber = scanner.nextInt();
// //          scanner.nextLine();
// //          System.out.println(itemRegister3.getTotalNumberOfItemsInCategory(categoryNumber));
// //        }
// //        case "incNumItem" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          System.out.println("Enter amount to increase: ");
// //          int amount = scanner.nextInt();
// //          scanner.nextLine();
// //          itemRegister3.increaseTotalNumberOfItems(itemNumber, amount);
// //        }
// //        case "decNumItem" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          System.out.println("Enter amount to decrease: ");
// //          int amount = scanner.nextInt();
// //          scanner.nextLine();
// //          itemRegister3.decreaseTotalNumberOfItems(itemNumber, amount);
// //        }
// //        case "updatePrice" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          System.out.println("Enter new price: ");
// //          int price = scanner.nextInt();
// //          scanner.nextLine();
// //          System.out.println(
// //              itemNumber + " previous price " + itemRegister3.getPrice(itemNumber));
// //          itemRegister3.updatePrice(itemNumber, price);
// //          System.out.println(itemNumber + " price updated to " + price);
// //        }
// //        case "updateDiscount" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          System.out.println("Enter new discount: ");
// //          int discount = scanner.nextInt();
// //          scanner.nextLine();
// //          System.out.println(
// //              itemNumber + " previous discount " + itemRegister3.getDiscount(itemNumber));
// //          itemRegister3.updateDiscount(itemNumber, discount);
// //          System.out.println(itemNumber + " discount updated to " + discount);
// //        }
// //        case "itemOffSale" -> {
// //          System.out.println("Enter item number: ");
// //          String itemNumber = scanner.nextLine();
// //          itemRegister3.itemOffSale(itemNumber);
// //        }
// //        case "quit" -> System.out.println("Quitting program");
// //        default -> System.out.println("Unknown command");
// //      }
// //    }
// //  }
//         }
//       }
//   }
}
