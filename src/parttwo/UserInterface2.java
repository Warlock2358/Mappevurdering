package parttwo;

import java.util.Scanner;

/**
 * This class is the user interface for the Warehouse management system. It has several methods that
 * interact with the user.
 *
 * @author Isak Mandal
 * @version 1.0
 */
public class UserInterface2 {

  /**
   * This is the main method for the UserInterface class. It is used to create an object of the
   * ItemRegister class. It also creates an object of the Scanner class. It then calls the menu
   * method.
   *
   * @param args The arguments that are entered when the program is run.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ItemRegister2 itemRegister2 = new ItemRegister2();
    String input = "";
    while (!input.equals("quit")) {
      System.out.println("Enter a command: ");
      input = scanner.nextLine();
      switch (input) {
        case "help" -> {
          System.out.println("Commands: ");
          System.out.println("help - shows this message");
          System.out.println("register - registers a new item");
          System.out.println("get - gets an item");
          System.out.println("getAll - gets all items");
          System.out.println("remove - removes an item");
          System.out.println("getNumItem - gets the total number of items");
          System.out.println("getNumItemCat - gets the total number of items in a category");
          System.out.println("incNumItem - increases the total number of items");
          System.out.println("decNumItem - decreases the total number of items");
          System.out.println("itemOffSale - removes the discount of an item");
          System.out.println("quit - quits the program");
        }
        case "register" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println("Enter description: ");
          String description = scanner.nextLine();
          System.out.println("Enter price: ");
          int price = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Enter discount: ");
          int discount = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Enter brand name: ");
          String brandName = scanner.nextLine();
          System.out.println("Enter weight: ");
          double weight = scanner.nextDouble();
          System.out.println("Enter length: ");
          double length = scanner.nextDouble();
          System.out.println("Enter height: ");
          double height = scanner.nextDouble();
          scanner.nextLine();
          System.out.println("Enter color: ");
          String color = scanner.nextLine();
          System.out.println("Enter amount in storage: ");
          int amountInStorage = scanner.nextInt();
          System.out.println("Enter category number: ");
          int categoryNumber = scanner.nextInt();
          scanner.nextLine();
          try {
            itemRegister2.addItem(itemNumber, description, price, discount, brandName, weight,
                length, height,
                color, amountInStorage, categoryNumber);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
        case "get" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println(itemRegister2.getItem(itemNumber));
        }
        case "getAll" -> System.out.println(itemRegister2.getItemList());
        case "remove" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          itemRegister2.removeItem(itemNumber);
        }
        case "getNumItem" -> System.out.println(itemRegister2.getTotalNumberOfItems());
        case "getNumItemCat" -> {
          System.out.println("Enter category number: ");
          int categoryNumber = scanner.nextInt();
          scanner.nextLine();
          System.out.println(itemRegister2.getTotalNumberOfItemsInCategory(categoryNumber));
        }
        case "incNumItem" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println("Enter amount to increase: ");
          int amount = scanner.nextInt();
          scanner.nextLine();
          itemRegister2.increaseTotalNumberOfItems(itemNumber, amount);
        }
        case "decNumItem" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println("Enter amount to decrease: ");
          int amount = scanner.nextInt();
          scanner.nextLine();
          itemRegister2.decreaseTotalNumberOfItems(itemNumber, amount);
        }
        case "updatePrice" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println("Enter new price: ");
          int price = scanner.nextInt();
          scanner.nextLine();
          System.out.println(itemNumber + " previous price " + itemRegister2.getPrice(itemNumber));
          itemRegister2.updatePrice(itemNumber, price);
          System.out.println(itemNumber + " price updated to " + price);
        }
        case "updateDiscount" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println("Enter new discount: ");
          int discount = scanner.nextInt();
          scanner.nextLine();
          System.out.println(
              itemNumber + " previous discount " + itemRegister2.getDiscount(itemNumber));
          itemRegister2.updateDiscount(itemNumber, discount);
          System.out.println(itemNumber + " discount updated to " + discount);
        }
        case "itemOffSale" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          itemRegister2.itemOffSale(itemNumber);
        }
        case "quit" -> System.out.println("Quitting program");
        default -> System.out.println("Unknown command");
      }
    }
  }
}
