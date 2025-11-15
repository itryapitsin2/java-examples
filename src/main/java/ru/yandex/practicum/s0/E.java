package ru.yandex.practicum.s0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
//    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
//        List<Integer> result = new ArrayList<>();
//        Collections.sort(arr);
//
//        int left = 0;
//        int right = arr.size() - 1;
//
//        while (left < right) {
//            int sum = arr.get(left) + arr.get(right);
//            if (sum == targetSum) {
//                result.add(arr.get(left));
//                result.add(arr.get(right));
//                return result;
//            } else if (sum > targetSum) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//
//        return result;
//    }

    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int a: arr) {
            int x = targetSum - a;
            if(map.containsKey(x)) {
                result.add(map.get(x));
                result.add(a);
            } else {
                map.put(a, a);
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }

            System.gc();
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}
