package experiments;

public class ExperimentClient {

  public static void main(String[] args) {
    ExperimentMethods experimentMethods = new ExperimentMethods();
    System.out.println(experimentMethods.toString(1));
    System.out.println(experimentMethods.toString(2));
    System.out.println(experimentMethods.toString(3));
  }
}
