package finalversion;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their price. Sorts in descending order.
 *
 * @author Isak Mandal
 * @version 09.12.2022
 */
public class DecreasingPriceComparator implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    return Double.compare(o2.getPrice(), o1.getPrice());
  }
}
