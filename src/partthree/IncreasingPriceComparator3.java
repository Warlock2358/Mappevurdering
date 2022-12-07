package partthree;

import java.util.Comparator;

/**
 * Compares two Item3 objects by their price. Sorts in ascending order.
 *
 * @author Isak Mandal
 */
public class IncreasingPriceComparator3 implements Comparator<Item3> {

  @Override
  public int compare(Item3 o1, Item3 o2) {
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
