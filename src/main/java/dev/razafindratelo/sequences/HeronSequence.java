package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;
import lombok.Getter;

@Getter
public final class HeronSequence implements Sequence {
  private long targetNat;
  private static final Fraction TWO = Fraction.valueOf(2);
  private static final Fraction ONE_HALF = TWO.inverse();

  public static HeronSequence init() {
    var init = new HeronSequence();
    init.targetNat(2L);
    return init;
  }

  @Override
  public void targetNat(long targetNat) {
    if (targetNat <= 0)
      throw new IllegalArgumentException("Target natural number should be positive");
    this.targetNat = targetNat;
  }

  @Override
  public Fraction kThValue(long k) {
    if (k < 0) throw new IllegalArgumentException("k must be greater than zero");

    if (k == 0) return Fraction.valueOf(2);

    Fraction previous = kThValue(k - 1);

    return ONE_HALF.multiply(previous.add(TWO.divide(previous)));
  }
}
