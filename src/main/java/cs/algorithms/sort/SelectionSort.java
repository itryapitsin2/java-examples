package cs.algorithms.sort;

import cs.types.Comparable;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] items, long count) {
        for (int i = 0; i < count - 1; i++) {
            int index = i;
            for (int j = i + 1; j < count; j++) {
                if (items[j].right(items[index])) {
                    index = j;
                }
            }
            T smallerNumber = items[index];
            items[index] = items[i];
            items[i] = smallerNumber;
        }

        return items;
    }
}
