package ru.yandex.practicum.s0.feedback;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Link to the report: https://contest.yandex.ru/contest/22450/run-report/115381213/
 */

public class A {

    private static void downgradeLength(List<Integer> list, int from,  int to) {
        int steps = from == -1 ? to : (to - from) / 2;
        int j = to - 1;
        for (int i = 1; i <= steps; i++) {
            list.set(to - i, to - j);
            j--;
        }
    }

    private static List<Integer> calcDistance(List<Integer> street, int streetLength) {
        List<Integer> result = new ArrayList<>(street);

        int dist = 0;
        int lastZero = -1;

        for (int i = 0; i < street.size(); i++) {
            var element = street.get(i);

            if (element == 0) {
                dist = 0;
                result.set(i, dist);
                downgradeLength(result, lastZero, i);
                lastZero = i;
            } else {
                dist++;
                result.set(i, dist);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> street = readList(reader);
            List<Integer> distance = calcDistance(street, n);

            printList(distance, writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static<T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                    try {
                        writer.write(String.valueOf(elem));
                        writer.write(" ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}