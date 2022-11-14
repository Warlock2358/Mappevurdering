package partthree;

/**
 * This class is used to represent an item for the Warehouse management system. It has several get
 * methods and a few set methods for each object that is created.
 *
 * @author Isak Mandal
 * @version 2.0
 */

public class Item3 {

  private final String itemNumber;
  private String description;
  private int price;
  private int discount;
  private final String brandName;
  private final double weight;
  private final double length;
  private final double height;
  private final String color;
  private final int categoryNumber;

  private int amountInStorage;


  /**
   * This is the constructor for the EntityClass. It takes in all the parameters that are needed to
   * create an object of this class.
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

  public Item3(String itemNumber, String description, int price, int discount,
      String brandName,
      double weight, double length, double height, String color,
      int amountInStorage, int categoryNumber) {
    checkValues(price, discount, weight, length, height, amountInStorage, categoryNumber);
    checkStrings(itemNumber, description, brandName, color);
    this.itemNumber = itemNumber;
    this.description = description;
    this.price = price;
    this.discount = discount;
    this.brandName = brandName;
    this.weight = weight;
    this.length = length;
    this.height = height;
    this.color = color;
    this.categoryNumber = categoryNumber;
    this.amountInStorage = amountInStorage;
  }

  /**
   * This method takes the values of the variables given and checks if they comply with the
   * restrictions given in the method. This method checks all the variables containing numbers.
   *
   * @param price           The price of the item. Must be a positive integer. It must be greater
   *                        than 0 and less than 100000.
   * @param discount        The discount of the item. Must be a positive integer. It must be between
   *                        0 and 100.
   * @param weight          The weight of the item. Must be a positive double. It must be greater
   *                        than 0 and less than 100000.
   * @param length          The length of the item. Must be a positive double. It must be greater
   *                        than 0 and less than 1000.
   * @param height          The height of the item. Must be a positive double. It must be greater
   *                        than 0 and less than 1000.
   * @param amountInStorage The amount of the item in storage. Must be a positive integer. It must
   *                        be greater than 0.
   * @param categoryNumber  The category number of the item. Must be a positive integer. It must be
   *                        between 1 and 4.
   */

  private void checkValues(int price, int discount, double weight, double length, double height,
      int amountInStorage, int categoryNumber) {
    if (price < 0 || price > 100000) {
      throw new IllegalArgumentException("The price must be between 0 and 1000000");
    }

    if (discount < 0 || discount > 100) {
      throw new IllegalArgumentException("The discount must be between 0 and 100");
    }

    if (weight < 0 || weight > 100000) {
      throw new IllegalArgumentException("The weight must be between 0 and 1000000");
    }

    if (length < 0 || length > 1000) {
      throw new IllegalArgumentException("The length must be between 0 and 1000");
    }

    if (height < 0 || height > 1000) {
      throw new IllegalArgumentException("The height must be between 0 and 1000");
    }

    if (amountInStorage < 0) {
      throw new IllegalArgumentException("The amount in storage must be greater than zero");
    }

    if (categoryNumber < 1 || categoryNumber > 4) {
      throw new IllegalArgumentException("The category number must be between 1 and 4");
    }
  }

  /**
   * This method takes the values of the variables given and checks if they comply with the
   * restrictions given in the method. This method check all the String variables.
   *
   * @param itemNumber  The item number of the item. Must be a string. Can contain numbers and
   *                    letters, but no special characters or spaces.
   * @param description The description of the item. Must be a string. Can contain all characters.
   * @param brandName   The brand name of the item. Must be a string. Can contain all characters.
   * @param color       The color of the item. Must be a string. Can contain all characters.
   */
  private void checkStrings(String itemNumber, String description, String brandName,
      String color) {
    if (itemNumber.isBlank() || description.isBlank() || brandName.isBlank() || color.isBlank()) {
      throw new IllegalArgumentException("The item number, description, brand name and color must "
          + "not be empty");
    }

    for (int i = 0; i < itemNumber.length(); i++) {
      if (!Character.isDigit(itemNumber.charAt(i)) && !Character.isAlphabetic(
          itemNumber.charAt(i)) || itemNumber.charAt(i) == ' ') {
        throw new IllegalArgumentException("The item number must only contain digits and letters");
      }
    }

    for (int i = 0; i < brandName.length(); i++) {
      if (!Character.isAlphabetic(brandName.charAt(i)) && brandName.charAt(i) != ' ') {
        throw new IllegalArgumentException("The brand name must only contain letters");
      }
    }

    for (int i = 0; i < color.length(); i++) {
      if (!Character.isAlphabetic(color.charAt(i))) {
        throw new IllegalArgumentException("The color must only contain letters");
      }
    }

    if (itemNumber.length() > 20) {
      throw new IllegalArgumentException("The item number must be less than 20 characters");
    }

    if (description.length() > 10000) {
      throw new IllegalArgumentException("The description must be less than 100 characters");
    }

    if (brandName.length() > 50) {
      throw new IllegalArgumentException("The brand name must be less than 50 characters");
    }

    if (color.length() > 20) {
      throw new IllegalArgumentException("The color must be less than 20 characters");
    }
  }

  /**
   * This method is used to get the item number of the item.
   *
   * @return The item number of the item. Returns an integer.
   */

  public String getItemNumber() {
    return itemNumber;
  }

  /**
   * This method is used to get the description of the item.
   *
   * @return The description of the item. Returns a string.
   */
  public String getDescription() {
    return description;
  }

  /**
   * This method is used to give a new description for the item.
   *
   * @param description The new description of the item. Must be a string. Can contain all
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * This method is used to get the price of the item.
   *
   * @return The price of the item. Returns a double.
   */
  public int getPrice() {
    return price;
  }

  /**
   * This method is used to set a new price for the item.
   *
   * @param price The new price of the item. Must be a positive integer. It must be greater than 0
   *              and less than 100000.
   */
  public void setPrice(int price) {
    if (price < 0 || price > 100000) {
      throw new IllegalArgumentException("The price must be between 0 and 1000000");
    }
    this.price = price;
  }

  public int getDiscount() {
    return discount;
  }

  /**
   * This method is used to set a new discount for the item.
   *
   * @param discount The new discount of the item. Must be a positive integer. It must be between 0
   *                 and 100.
   */
  public void setDiscount(int discount) {
    if (discount < 0 || discount > 100) {
      throw new IllegalArgumentException("The discount must be between 0 and 100");
    }
    this.discount = discount;
  }

  public double getDiscountedPrice() {
    return price - ((double) price * discount / 100);
  }

  /**
   * This method is used to get the brand name of the item.
   *
   * @return The brand name of the item. Returns a string.
   */
  public String getBrandName() {
    return brandName;
  }

  /**
   * This method is used to get the weight of the item.
   *
   * @return The weight of the item. Returns a double.
   */
  public double getWeight() {
    return weight;
  }

  /**
   * This method is used to get the length of the item.
   *
   * @return The length of the item. Returns a double.
   */
  public double getLength() {
    return length;
  }

  /**
   * This method is used to get the height of the item.
   *
   * @return The height of the item. Returns a double.
   */
  public double getHeight() {
    return height;
  }

  /**
   * This method is used to get the color of the item.
   *
   * @return The color of the item. Returns a string.
   */
  public String getColor() {
    return color;
  }

  /**
   * This method is used to get the amount of the item in storage.
   *
   * @return The amount of the item in storage. Returns an integer.
   */
  public int getAmountInStorage() {
    return amountInStorage;
  }

  /**
   * This method is used to set the amount of the item in storage.
   *
   * @param amountInStorage The amount of the item in storage. Must be a positive integer. It must
   *                        be greater than zero.
   */
  public void setAmountInStorage(int amountInStorage) {
    this.amountInStorage = amountInStorage;
  }

  /**
   * This method is used to get the category number of the item.
   *
   * @return The category number of the item. Returns an integer.
   */
  public int getCategoryNumber() {
    return categoryNumber;
  }

  @Override
  public String toString() {
    if (discount == 0) {
      return "\nItem information:" + "\nItem number: " + getItemNumber() + "\nDescription: "
          + getDescription() + "\nPrice: " + getPrice() + "\nBrand name: " + getBrandName()
          + "\nWeight: " + getWeight() + "\nLength: " + getLength() + "\nHeight: " + getHeight()
          + "\nColor: " + getColor() + "\nAmount in storage: " + getAmountInStorage()
          + "\nCategory number: " + getCategoryNumber();
    } else {
      return "\nItem information:" + "\nItem number: " + getItemNumber() + "\nDescription: "
          + getDescription() + "\nPrice: " + getDiscountedPrice() + "\nBrand name: "
          + getBrandName()
          + "\nWeight: " + getWeight() + "\nLength: " + getLength() + "\nHeight: " + getHeight()
          + "\nColor: " + getColor() + "\nAmount in storage: " + getAmountInStorage()
          + "\nCategory number: " + getCategoryNumber();
    }
  }
}
