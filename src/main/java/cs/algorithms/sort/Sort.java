package cs.algorithms.sort;

import cs.types.Comparable;

public interface Sort<T extends Comparable<T>> {
    T[] sort(T[] items, long count);
}
