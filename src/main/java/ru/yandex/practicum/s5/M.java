package ru.yandex.practicum.s5;

public class M {
    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return idx;
        }
        int parentIdx = idx / 2;
        if (heap[parentIdx] < heap[idx]) {
            int tmp = heap[parentIdx];
            heap[parentIdx] = heap[idx];
            heap[idx] = tmp;

            return siftUp(heap, parentIdx);
        }

        return idx;
    }

    private static void test() {
//        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
//        int result = siftUp(sample, 5);
        int[] sample = {12, 6, 8, 3, 4, 7};
        int result = siftUp(sample, 2);
        assert result == 1;
    }

    public static void main(String[] args) {
        test();
    }
}
