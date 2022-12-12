package finalversion;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their price. Sorts in ascending order.
 *
 * @author Isak Mandal
 * @version 09.12.2022
 */
public class IncreasingPriceComparator implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
