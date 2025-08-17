package dev.razafindratelo.benchmarks;

import dev.razafindratelo.sequences.SquareRoot;
import java.math.MathContext;

public class SquareRootBenchMarck {
  private static final SquareRoot SQUARE_ROOT = new SquareRoot();

  public static String showResult(String title, long nat, long range, long precision, double time) {

    return "[Benchmark of SquareRoot.kThValue] - "
        + title
        + "\n\t - nat\t\t= "
        + nat
        + "\n\t - range\t\t= "
        + range
        + "\n\t - precision\t= "
        + precision
        + "\n\t - duration\t= "
        + time
        + " seconds\n";
  }

  /**
   * [Benchmark of SquareRoot.kThValue] - Fraction Form - nat = 2 - range = 23 - precision =
   * 6_000_002 - duration = 226.88022827 second
   */
  public static void sqrtOfTwoFractionForm() {
    SQUARE_ROOT.targetNat(2L);
    final long lengthPrecision = 6_000_002;

    long start = System.nanoTime();
    var actual = SQUARE_ROOT.kThValue(23);
    long end = System.nanoTime();

    double durationInSeconds = (end - start) / 1_000_000_000.0;

    System.out.println(showResult("Fraction Form", 2, 23, lengthPrecision, durationInSeconds));
  }

  /**
   * [Benchmark of SquareRoot.kThValue] - Decimal Form - nat = 2 - range = 23 - precision = 6000002
   * - duration = 309.804193456 seconds
   */
  public static void sqrtOfTwoDecimalForm() {
    SQUARE_ROOT.targetNat(2L);
    final int lengthPrecision = 6_000_002;
    var precision = new MathContext(lengthPrecision + 4);

    long start = System.nanoTime();
    String actual =
        SQUARE_ROOT.kThValue(23).getValue(precision).toString().substring(0, lengthPrecision);
    long end = System.nanoTime();

    double durationInSeconds = (end - start) / 1_000_000_000.0;

    System.out.println(showResult("Decimal Form", 2, 23, lengthPrecision, durationInSeconds));
  }

  public static void main(String[] args) {
    sqrtOfTwoFractionForm();
    sqrtOfTwoDecimalForm();
  }
}
