package partthree;

/**
 * This class is used to make the different choices more readable.
 */
public enum UserChoice {
  REGISTER_ITEM(1, "Register item"),
  REMOVE_ITEM(2, "Remove item"),
  GET_ITEM(3, "Get item"),
  GET_ALL_ITEMS(4, "Get all items"),
  GET_ALL_ITEMS_IN_CATEGORY(5, "Get all items by category"),
  GET_NUMBER_OF_ITEMS(6, "Get number of items"),
  GET_NUMBER_OF_ITEMS_BY_CATEGORY(7, "Get number of items by category"),
  INCREASE_AMOUNT_IN_STORAGE(8, "Increase amount in storage"),
  DECREASE_AMOUNT_IN_STORAGE(9, "Decrease amount in storage"),
  SORT_ITEMS_BY_ASCENDING_PRICE(10, "Sort items by ascending price"),
  SORT_ITEMS_BY_DESCENDING_PRICE(11, "Sort items by descending price"),
  UPDATE_PRICE(12, "Update price"),
  UPDATE_DISCOUNT(13, "Update discount"),
  ITEM_OFF_SALE(14, "Item of sale"),
  UPDATE_ITEM_DESCRIPTION(15, "Update item description"),
  EXIT(16, "Exit");

  private final int choiceNumber;
  private final String choiceName;

  UserChoice(int choiceNumber, String choiceName) {
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
  public static UserChoice getChoice(int choiceNumber) {
    for (UserChoice choice : UserChoice.values()) {
      if (choice.getChoiceNumber() == choiceNumber) {
        return choice;
      }
    }
    return null;
  }
}

