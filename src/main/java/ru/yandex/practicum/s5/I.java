package ru.yandex.practicum.s5;

import java.util.Scanner;

public class I {
    private static int countDistinct(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += countDistinct(i-1) * countDistinct(n-i);
        }

        return sum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int nodeCount = scanner.nextInt();

            System.out.println(countDistinct(nodeCount));
        }
    }
}
