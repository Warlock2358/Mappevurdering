package partthree;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their price. Sorts in descending order.
 *
 * @author Isak Mandal
 */
public class DecreasingPriceComparator implements Comparator<Item3> {

  @Override
  public int compare(Item3 o1, Item3 o2) {
    return Double.compare(o2.getPrice(), o1.getPrice());
  }
}
