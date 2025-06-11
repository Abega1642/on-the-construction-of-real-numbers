package dev.razafindratelo.tools.gmp;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

public class GMPUtil {
    private static final GMP INSTANCE = GMP.INSTANCE;

    /**
     * Computes GCD of two very large numbers (100+ digits) using GMP.
     * 
     * @param a
     *            First number as a string (base 10)
     * @param b
     *            Second number as a string (base 10)
     * @return GCD as a string (base 10)
     */
    public static String gcd(String a, String b) {
        Pointer mpzA = new Memory(16);
        Pointer mpzB = new Memory(16);
        Pointer result = new Memory(16);

        try {
            INSTANCE.__gmpz_init(mpzA);
            INSTANCE.__gmpz_init(mpzB);
            INSTANCE.__gmpz_init(result);

            if (INSTANCE.__gmpz_set_str(mpzA,a,10) != 0 || INSTANCE.__gmpz_set_str(mpzB,b,10) != 0)
                throw new NumberFormatException("Invalid number format");

            INSTANCE.__gmpz_gcd(result,mpzA,mpzB);

            Pointer strPtr = INSTANCE.__gmpz_get_str(null,10,result);

            try {
                return strPtr.getString(0);
            } finally {
                INSTANCE.free(strPtr);
            }

        } finally {
            INSTANCE.__gmpz_clear(mpzA);
            INSTANCE.__gmpz_clear(mpzB);
            INSTANCE.__gmpz_clear(result);
        }
    }

}
