package partone;

import java.util.Scanner;

public class TestClient {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Enter item number: ");
//    String itemNumber = scanner.nextLine();
//    System.out.println("Enter description: ");
//    String description = scanner.nextLine();
//    System.out.println("Enter price: ");
//    int price = scanner.nextInt();
//    System.out.println("Enter brand name: ");
//    String brandName = scanner.nextLine();
//    System.out.println("Enter weight: ");
//    double weight = scanner.nextDouble();
//    System.out.println("Enter length: ");
//    double length = scanner.nextDouble();
//    System.out.println("Enter height: ");
//    double height = scanner.nextDouble();
//    System.out.println("Enter color: ");
//    String color = scanner.nextLine();
//    System.out.println("Enter amount in storage: ");
//    int amountInStorage = scanner.nextInt();
//    System.out.println("Enter catagory number: ");
//    int catagoryNumber = scanner.nextInt();

//    try {
//      EntityClass entityClass = new EntityClass(itemNumber, description, price, brandName, weight,
//          length, height, color, amountInStorage, catagoryNumber);
//      System.out.println(entityClass.toString());
//    } catch (IllegalArgumentException e) {
//      System.out.println(e.getMessage());
//    }

    try {
      EntityClass entityClass = new EntityClass("1ab1", "Hello", 12400, "HAD", 1000,
          10, 10, "red", 10, 1);
      System.out.println(entityClass);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
