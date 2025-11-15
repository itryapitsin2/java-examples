package cs.algorithms.search;


import cs.types.Comparable;
import cs.types.OrderedArray;

public class BinarySearch<T extends Comparable<T>> implements Search<OrderedArray<T>, T> {

    public enum Type {
        RECURSIVE,
        ITERATIVE
    }

    Type type;

    public BinarySearch(Type type) {
        this.type = type;
    }
    public BinarySearch() {
        this.type = Type.ITERATIVE;
    }
    @Override
    public int find(OrderedArray<T> list, T element) {
        switch (type) {
            case ITERATIVE:
                return findIterative(list, element);
            case RECURSIVE:
                return findRecursive(list, element, 0, list.getItems().length - 1);
        }

        return -1;
    }

    private int findIterative(OrderedArray<T> list, T element) {
        int firstIndex = 0;
        int lastIndex = list.getCount() - 1;

        Comparable<T>[] items = list.getItems();

        while (firstIndex <= lastIndex) {
            int middleIndex = firstIndex + ((lastIndex - firstIndex) / 2);

            if (items[middleIndex].equals(element)) {
                return middleIndex;
            } else if (items[middleIndex].right(element)) {
                firstIndex = middleIndex + 1;
            } else if (items[middleIndex].left(element)) {
                lastIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    private int findRecursive(OrderedArray<T> list, T element, int firstIndex, int lastIndex) {
        if (lastIndex < firstIndex) {
            return -1;
        }
        Comparable<T>[] items = list.getItems();

        int middleIndex = firstIndex + ((lastIndex - firstIndex) / 2);

        if (items[middleIndex].equals(element)) {
            return middleIndex;
        } else if (items[middleIndex].right(element)) {
            return findRecursive(list, element, middleIndex + 1, lastIndex);
        } else if (items[middleIndex].left(element)) {
            return findRecursive(list, element, firstIndex, middleIndex - 1);
        }
        return -1;
    }
}
