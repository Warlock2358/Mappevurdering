package partthree;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their item number. Sorts in ascending order.
 *
 * @author Isak Mandal
 */
public class ItemNumberComparator3 implements Comparator<Item3> {

  @Override
  public int compare(Item3 o1, Item3 o2) {
    return o1.getItemNumber().compareTo(o2.getItemNumber());
  }
}

