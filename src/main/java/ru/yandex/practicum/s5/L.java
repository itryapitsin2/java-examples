package ru.yandex.practicum.s5;

public class L {
    public static int siftDown(int[] heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int largestIndex = 0;

        if (heap.length - 1 < left) {
            return idx;
        }

        if (right < heap.length && heap[left] < heap[right]) {
            largestIndex = right;
        } else {
            largestIndex = left;
        }

        if (heap[idx] < heap[largestIndex]) {
            int tmp = heap[largestIndex];
            heap[largestIndex] = heap[idx];

            heap[idx] = tmp;

            return siftDown(heap, largestIndex);
        }

        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        int result = siftDown(sample, 2);

        assert result == 5;
    }

    public static void main(String[] args) {
        test();
    }
}
