package ru.yandex.practicum.s5.final_tasks;

import java.util.*;

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/24810/run-report/116778271/
 */
public class A {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var count = scanner.nextInt();
            scanner.nextLine();

            var data = readData(scanner, count);

            var sortedData = heapSort(data);

            sortedData
                    .stream()
                    .map(Record::name)
                    .forEach(System.out::println);
        }
    }

    private static List<Record> heapSort(List<Record> data) {
        var heap = new ArrayList<Record>();
        heap.add(null);
        for (Record item : data) {
            heapAdd(heap, item);
        }

        var sortedArray = new ArrayList<Record>();
        while (!heap.isEmpty() && heap.getLast() != null) {
            var max = popMax(heap);
            sortedArray.add(max);
        }
        return sortedArray;
    }

    private static void heapAdd(List<Record> heap, Record key) {
        heap.add(key);
        int index = heap.size() - 1;
        siftUp(heap, index);
    }

    private static Record popMax(List<Record> heap) {
        var result = heap.get(1);
        heap.set(1, heap.getLast());
        heap.removeLast();
        siftDown(heap, 1);
        return result;
    }

    private static void siftUp(List<Record> heap, int idx) {
        if (idx == 1) {
            return;
        }
        int parentIdx = idx / 2;
        if (heap.get(parentIdx).compareTo(heap.get(idx)) < 0) {
            Collections.swap(heap, parentIdx, idx);
            siftUp(heap, parentIdx);
        }
    }

    private static void siftDown(List<Record> heap, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        if (left >= heap.size()) {
            return;
        }

        int indexLargest = left;
        if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) > 0) {
            indexLargest = right;
        }

        if (heap.get(indexLargest).compareTo(heap.get(index)) > 0) {
            Collections.swap(heap, index, indexLargest);
            siftDown(heap, indexLargest);
        }
    }

    private static List<Record> readData(Scanner scanner, int count) {
        var records = new ArrayList<Record>();

        for (int i = 0; i < count; i++) {
            String[] data = scanner.nextLine().split(" ");

            records.add(new Record(
                    data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2])));
        }

        return records;
    }

    protected record Record(String name, int success, int penalty) implements Comparable<Record> {

        @Override
            public int compareTo(Record o) {
                int result = Integer.compare(this.success, o.success);
                if (result != 0) {
                    return result;
                }

                result = Long.compare(o.penalty, this.penalty);
                if (result != 0) {
                    return result;
                }

                result = o.name.compareTo(name);
                return result;
            }
        }
}
