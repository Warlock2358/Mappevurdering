package partthree;

/**
 * This class is used to make the different choices more readable.
 */
public enum UserChoice3 {
  REGISTER_ITEM(1, "Register item"),
  REMOVE_ITEM(2, "Remove item"),
  GET_ITEM(3, "Get item"),
  GET_ITEM_BY_DESCRIPTION(4, "Get item by description"),
  GET_ALL_ITEMS(5, "Get all items"),
  GET_ALL_ITEMS_IN_CATEGORY(6, "Get all items by category"),
  GET_NUMBER_OF_ITEMS(7, "Get number of items"),
  GET_NUMBER_OF_ITEMS_BY_CATEGORY(8, "Get number of items by category"),
  INCREASE_AMOUNT_IN_STORAGE(9, "Increase amount in storage"),
  DECREASE_AMOUNT_IN_STORAGE(10, "Decrease amount in storage"),
  SORT_ITEMS_BY_ASCENDING_PRICE(11, "Sort items by ascending price"),
  SORT_ITEMS_BY_DESCENDING_PRICE(12, "Sort items by descending price"),
  UPDATE_PRICE(13, "Update price"),
  UPDATE_DISCOUNT(14, "Update discount"),
  ITEM_OFF_SALE(15, "Item of sale"),
  UPDATE_ITEM_DESCRIPTION(16, "Update item description"),
  EXIT(17, "Exiting program...");

  private final int choiceNumber;
  private final String choiceName;

  UserChoice3(int choiceNumber, String choiceName) {
    this.choiceNumber = choiceNumber;
    this.choiceName = choiceName;
  }

  public int getChoiceNumber() {
    return choiceNumber;
  }

  public String getChoiceName() {
    return choiceName;
  }

  /**
   * This method is used to get the choice from the choice number.
   *
   * @param choiceNumber The number of the choice.
   * @return The choice.
   */
  public static UserChoice3 getChoice(int choiceNumber) {
    for (UserChoice3 choice : UserChoice3.values()) {
      if (choice.getChoiceNumber() == choiceNumber) {
        return choice;
      }
    }
    return null;
  }
}

