package partthree;

/**
 * This class is used to make the different choices more readable.
 */
public enum UserChoice {
  REGISTER_ITEM(1, "Register item"),
  REMOVE_ITEM(2, "Remove item"),
  GET_ITEM(3, "Get item"),
  GET_ALL_ITEMS(4, "Get all items"),
  GET_NUMBER_OF_ITEMS(5, "Get number of items"),
  GET_NUMBER_OF_ITEMS_BY_CATEGORY(6, "Get number of items by category"),
  INCREASE_AMOUNT_IN_STORAGE(7, "Increase amount in storage"),
  DECREASE_AMOUNT_IN_STORAGE(8, "Decrease amount in storage"),
  UPDATE_PRICE(9, "Update price"),
  UPDATE_DISCOUNT(10, "Update discount"),
  ITEM_OFF_SALE(11, "Item of sale"),
  UPDATE_ITEM_DESCRIPTION(12, "Update item description"),
  EXIT(13, "Exit");

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

