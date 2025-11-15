package cs.algorithms.calc;

public class GreatestCommonDivisor {
    /**
     * Description in russian: https://ru.wikipedia.org/wiki/Алгоритм_Евклида
     * Description in english: https://en.wikipedia.org/wiki/Euclidean_algorithm
     *
     * @param a
     * @param b
     * @return greatest common divisor
     */
    public int euclideanAlgorithm(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Description in russian: https://ru.wikipedia.org/wiki/Бинарный_алгоритм_вычисления_НОД
     * Description in english: https://en.wikipedia.org/wiki/Binary_GCD_algorithm
     *
     * @param a
     * @param b
     * @return greatest common divisor
     */
    public int binaryGCD(int a, int b) {
        if (a == 0)
            return b;                            // GCD(0, b) = b
        if (b == 0)
            return a;                            // GCD(a, 0) = a
        if (a == b)
            return a;                            // GCD(a, a) = a
        if (a == 1 || b == 1)
            return 1;                            // GCD(1, b) = GCD(a, 1) = 1
        if ((a & 1) == 0)                        // If а — even, ...
            return ((b & 1) == 0)
                    ? binaryGCD(a >> 1, b >> 1) << 1       // …if b — even, то GCD(a, b) = 2 * GCD(a / 2, b / 2)
                    : binaryGCD(a >> 1, b);                // …if b — odd, то GCD(a, b) = GCD(a / 2, b)
        else                                     // if a — odd, then…
            return ((b & 1) == 0)
                    ? binaryGCD(a, b >> 1)                 // …if b — even, then GCD(a, b) = GCD(a, b / 2)
                    : binaryGCD(b, a > b ? a - b : b - a); // …if b — even, then GCD(a, b) = GCD(b, |a - b|)
    }
}
