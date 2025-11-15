package ru.yandex.practicum.s0.feedback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Link to the report: https://contest.yandex.ru/contest/22450/run-report/115436087/
 */
public class B {
    private static final int NUMBERS_COUNT = 10;
    private static final int ROWS_COUNT = 4;
    private static final int COLS_COUNT = 4;
    public static final int PERSONS_COUNT = 2;

    public static int calcPoints(int k, int[] index) {
        int result = 0;
        int maxCountOfPressedButtons = PERSONS_COUNT * k;

        for (int i = 1; i < index.length; i++) {
            if (index[i] != 0 && index[i] <= maxCountOfPressedButtons) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(reader.readLine());
            int[] index = readIndex(reader);
            int result = calcPoints(k, index);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readIndex(BufferedReader reader) throws IOException {
        int[] index = new int[NUMBERS_COUNT];
        for(int i = 0; i < ROWS_COUNT && reader.ready(); i++) {
            char[] splitRow = reader.readLine().toCharArray();
            for(int j = 0; j < COLS_COUNT; j++) {
                if(splitRow[j] != '.') {
                    int value = Character.getNumericValue(splitRow[j]);
                    int savedValue = index[value];
                    savedValue++;
                    index[value] = savedValue;
                }
            }
        }
        return index;
    }
}
