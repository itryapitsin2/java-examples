package ru.yandex.practicum.s0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    private static int[] calcBits(int first, int second, int acc) {
        int cal = first + second + acc;

        return new int[]{cal / 2, cal % 2};
    }

    private static String sumOfBinaries(String a, String b) {
        int acc = 0;
        var result = new StringBuilder();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        var longestString = a.length() > b.length() ? a : b;
        var shortestString = a.length() > b.length() ? b : a;

        for (int i = 0; i < longestString.length(); i++) {
            var aChar = Character.getNumericValue(longestString.charAt(i));
            var bChar = 0;

            if (shortestString.length() > i) {
                bChar = Character.getNumericValue(shortestString.charAt(i));
            }

            var calcResult = calcBits(aChar, bChar, acc);

            var el = calcResult[1];
            acc = calcResult[0];

            result.append(el);
        }

        if (acc != 0) {
            result.append(acc);
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();

            System.out.println(sumOfBinaries(a, b));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
