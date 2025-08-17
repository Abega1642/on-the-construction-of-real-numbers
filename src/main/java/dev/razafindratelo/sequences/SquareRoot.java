package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

/** SquareRoot sequence: the sequence (x_n) */
@Getter
public final class SquareRoot implements Sequence {
  private long targetNat;
  private final Approximator approximator = new Approximator();

  @Override
  public void targetNat(long targetNat) {
    if (targetNat <= 0) throw new IllegalArgumentException("n must be greater than 0");
    this.targetNat = targetNat;
    approximator.targetNat(targetNat);
  }

  @Override
  public Fraction kThValue(long k) {
    if (this.targetNat == 1) return Fraction.ONE;

    if (this.targetNat == approximator.getRootValueSquared())
      return Fraction.valueOf(approximator.getRootValue());

    if (k == 0) {
      return Fraction.valueOf(approximator.getRootValue());
    } else {
      Fraction kThValue = Fraction.ZERO;

      for (int i = 1; i <= k; i++) {
        kThValue = kThValue.add(approximator.kThValue(i).inverse().opposite());
      }

      return kThValue.add(approximator.getRootValue());
    }
  }
}
