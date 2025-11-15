package cs.algorithms.sort;

import cs.types.Comparable;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] items, long count) {
        int i, j;
        T key;
        for (i = 1; i < count; i++) {
            key = items[i];
            j = i - 1;

            while (j >= 0 && items[j].left(key)) {
                items[j + 1] = items[j];
                j = j - 1;
            }
            items[j + 1] = key;
        }

        return items;
    }
}
