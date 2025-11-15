package ru.yandex.practicum.s0.last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Link to the report: https://contest.yandex.ru/contest/22450/run-report/115407241/
 */
public class B {
    public static int calculateAllPoints(int k, int[][] matrix) {
        int result = 0;
        int maxCountOfPressedButtons = 2 * k;
        int[] index = new int[10];
        for (int[] ints : matrix) {
            for (int value : ints) {
                int savedValue = index[value];
                savedValue++;
                index[value] = savedValue;
            }
        }

        for (int i = 1; i < index.length; i++) {
            if (index[i] == 0) {
                continue;
            }
            if (index[i] <= maxCountOfPressedButtons) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(reader.readLine());
            int[][] matrix = readMatrix(reader);
            int result = calculateAllPoints(k, matrix);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] readMatrix(BufferedReader reader) throws IOException {
        int m = 4;
        int n = 4;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m && reader.ready(); i++) {
            char[] splitRow = reader                    .readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                if(splitRow[j] == '.') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Character.getNumericValue(splitRow[j]);
                }
            }
        }
        return matrix;
    }
}
