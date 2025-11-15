package ru.yandex.practicum.s0;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class K {

    private static List<Integer> getSecondList(int k) {
        List<Integer> list = new ArrayList<>();
        int acc = k;
        while (acc > 0) {
            list.add(acc % 10);
            acc /= 10;
        }

        return list;
    }

    private static List<Integer> getSum(List<Integer> numberList, int k) {
        int acc = 0;
        List<Integer> result = new ArrayList<>();

        var secondList = getSecondList(k);
        Collections.reverse(numberList);

        var strongestList = numberList.size() > secondList.size() ? numberList : secondList;
        var shortestList = numberList.size() > secondList.size() ? secondList : numberList;

        for (int i = 0; i < strongestList.size(); i++) {
            var strongestListNum = strongestList.get(i);
            var shortestListNum = 0;
            if (shortestList.size() > i) {
                shortestListNum = shortestList.get(i);
            }

            var sum = strongestListNum + shortestListNum + acc;
            acc = sum / 10;
            var newNum = sum % 10;

            result.add(newNum);
        }

        if (acc != 0) {
            result.add(acc);
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}