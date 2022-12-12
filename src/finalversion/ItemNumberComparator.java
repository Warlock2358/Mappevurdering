package finalversion;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their item number. Sorts in ascending order.
 *
 * @author Isak Mandal
 * @version 09.12.2022
 */
public class ItemNumberComparator implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    return o1.getItemNumber().compareTo(o2.getItemNumber());
  }
}

