package partthree;

/**
 * This class is used to make the different choices more readable.
 *
 * @author Isak Mandal
 * @version 09.12.2022
 */
public enum ItemCategory3 {
  FLOOR_LAMINATES(1, "Floor laminates"),
  WINDOWS(2, "Windows"),
  DOORS(3, "Doors"),
  LUMBER(4, "Lumber");

  private final int categoryNumber;
  private final String categoryName;

  ItemCategory3(int categoryNumber, String categoryName) {
    this.categoryNumber = categoryNumber;
    this.categoryName = categoryName;
  }

  public int getCategoryNumber() {
    return categoryNumber;
  }

  public String getCategoryName() {
    return categoryName;
  }


  /**
   * This method is used to get the category from the category number.
   *
   * @param categoryNumber The number of the category.
   * @return The category.
   */
  public static ItemCategory3 getCategory(int categoryNumber) {
    for (ItemCategory3 category : ItemCategory3.values()) {
      if (category.getCategoryNumber() == categoryNumber) {
        return category;
      }
    }
    return null;
  }
}

