package dev.razafindratelo;

import dev.razafindratelo.tools.Fraction;

/**
 *  Q stands for Rational Number as its notation in Mathematics
 */
public interface Q extends R {
    Fraction add(Fraction f);
    void inverse();
}
