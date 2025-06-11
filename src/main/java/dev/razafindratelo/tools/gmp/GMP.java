package dev.razafindratelo.tools.gmp;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import java.util.Collections;

public interface GMP extends Library {

    GMP INSTANCE = Native.load("gmp",GMP.class,Collections.emptyMap());

    void __gmpz_init(Pointer x);
    int __gmpz_set_str(Pointer x, String str, int base);
    void __gmpz_gcd(Pointer result, Pointer a, Pointer b);
    Pointer __gmpz_get_str(Pointer buffer, int base, Pointer x);
    void __gmpz_clear(Pointer x);
    void free(Pointer ptr);
}
