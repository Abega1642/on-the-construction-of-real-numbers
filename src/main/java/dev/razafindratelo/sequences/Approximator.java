package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

/** Approximator, as a subsequence of the SquareRoot sequence, is my sequence (a_n). */
@Getter
public final class Approximator implements Sequence {
  private long targetNat;
  private long rootValue;
  private long rootValueSquared;
  private long squareDeviation;

  @Override
  public void targetNat(long targetNat) {
    if (targetNat <= 0) throw new IllegalArgumentException("n must be greater than 0");
    this.targetNat = targetNat;
    this.rootValue = (int) Math.ceil(Math.sqrt(targetNat));
    this.rootValueSquared = rootValue * rootValue;
    this.squareDeviation = rootValueSquared - targetNat;
  }

  @Override
  public Fraction kThValue(long k) {

    if (rootValueSquared == this.targetNat) return Fraction.ZERO;
    if (k == 0) return Fraction.valueOf(rootValue);
    if (k == 1) return Fraction.valueOf(rootValue << 1, squareDeviation);

    Fraction sqK2 = Fraction.valueOf(rootValue << 1, squareDeviation);
    Fraction sqK1 =
        Fraction.valueOf(
            rootValue * (rootValueSquared + this.targetNat) << 2,
            squareDeviation * squareDeviation);

    Fraction kThValue = sqK1;

    for (long i = 3; i <= k; i++) {
      kThValue = sqK1.multiply(sqK1.divide(sqK2).toThePowerOf(2).add(Fraction.TWO.opposite()));
      sqK2 = sqK1;
      sqK1 = kThValue;
    }

    return kThValue;
  }
}
