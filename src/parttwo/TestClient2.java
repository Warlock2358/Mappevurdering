package parttwo;

import java.util.Scanner;

public class TestClient2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ItemRegister itemRegister = new ItemRegister();
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
          System.out.println("quit - quits the program");
        }
        case "register" -> {
//          System.out.println("Enter item number: ");
//          String itemNumber = scanner.nextLine();
//          System.out.println("Enter description: ");
//          String description = scanner.nextLine();
//          System.out.println("Enter price: ");
//          int price = scanner.nextInt();
//          scanner.nextLine();
//          System.out.println("Enter brand name: ");
//          String brandName = scanner.nextLine();
//          System.out.println("Enter weight: ");
//          double weight = scanner.nextDouble();
//          System.out.println("Enter length: ");
//          double length = scanner.nextDouble();
//          System.out.println("Enter height: ");
//          double height = scanner.nextDouble();
//          scanner.nextLine();
//          System.out.println("Enter color: ");
//          String color = scanner.nextLine();
//          System.out.println("Enter amount in storage: ");
//          int amountInStorage = scanner.nextInt();
//          System.out.println("Enter catagory number: ");
//          int catagoryNumber = scanner.nextInt();
//          scanner.nextLine();
//          try {
//            itemRegister.addItem(itemNumber, description, price, brandName, weight, length, height,
//                color, amountInStorage, catagoryNumber);
//          } catch (Exception e) {
//            System.out.println(e.getMessage());
//          }
          try {
            itemRegister.addItem("123", "Hello this is a test", 100, "Test", 1.0, 1.0, 1.0, "Red",
                1, 1);
            itemRegister.addItem("124", "Hello this is a test2", 101, "Testtwo", 2.0, 2.0, 2.0,
                "Blue", 2, 2);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
        case "get" -> {
          System.out.println("Enter item number: ");
          String itemNumber = scanner.nextLine();
          System.out.println(itemRegister.getItem(itemNumber));
        }
        case "getAll" -> System.out.println(itemRegister.getItemList());
        case "quit" -> System.out.println("Quitting program");
        default -> System.out.println("Unknown command");
      }
    }
  }
}
