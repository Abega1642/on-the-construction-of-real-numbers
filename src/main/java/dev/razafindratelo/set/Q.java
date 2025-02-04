package dev.razafindratelo.set;

import dev.razafindratelo.tools.Fraction;

/**
 *  Q stands for Rational Number as its notation in Mathematics
 */
public interface Q extends R {
    Fraction add(Fraction f);
    Fraction inverse();
    Fraction multiply(Fraction f);
    Fraction opposite();
    Fraction abs();
    Fraction divide(Fraction f);
}
