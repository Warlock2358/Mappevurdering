package experiments;

public class ExperimentMethods {

  public String toString(int i) {
    return switch (i) {
      case 1 -> """

          Item information:
          Item number: 123
          Description: Hello
          Price: 2
          """;
      case 2 -> """

          Item information:
          Item number: 123
          Description: Bye
          Price: 1
          """;
      default -> "unknown";
    };
  }
}
