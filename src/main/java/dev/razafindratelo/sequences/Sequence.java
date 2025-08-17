package dev.razafindratelo.sequences;

import dev.razafindratelo.tools.Fraction;

public interface Sequence {

  void targetNat(long targetNat);

  /**
   * @param k: k is range of the square root sequence
   * @return the k-th value of the square root sequence
   */
  Fraction kThValue(long k);
}
