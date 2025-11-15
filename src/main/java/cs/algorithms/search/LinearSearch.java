package cs.algorithms.search;

import cs.types.List;

public class LinearSearch<T> implements Search<List<T>, T> {
    public int find(List<T> list, T element) {
        for (int i = 0; i < list.getCount(); i++) {
            if (list.getItems()[i] == element) {
                return i;
            }
        }

        return -1;
    }
}
