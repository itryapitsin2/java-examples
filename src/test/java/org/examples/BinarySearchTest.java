package org.examples;

import cs.algorithms.search.BinarySearch;
import cs.algorithms.search.BinarySearch.Type;
import cs.algorithms.sort.BubbleSort;
import cs.algorithms.sort.CombSort;
import cs.algorithms.sort.InsertionSort;
import cs.algorithms.sort.MixSort;
import cs.algorithms.sort.SelectionSort;
import cs.types.Comparable;
import cs.types.OrderedArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class BinarySearchTest {

    static class Element implements Comparable<Element> {

        private final int value;

        public int getValue() {
            return value;
        }

        public Element(int value) {
            this.value = value;
        }

        @Override
        public boolean left(Element element) {
            return element.value > value;
        }

        @Override
        public boolean right(Element element) {
            return element.value < value;
        }

        @Override
        public boolean equals(Object element) {
            if (element instanceof Element) {
                return ((Element) element).value == value;
            }

            return false;
        }
    }

    @Test
    public void searchInBubbleOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new BubbleSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.find(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.find(array, i), 9);

        Assertions.assertNotEquals(linearSearch.find(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInInsertionOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new InsertionSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.find(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.find(array, i), 9);

        Assertions.assertNotEquals(linearSearch.find(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInSelectionOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new SelectionSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>(Type.RECURSIVE);
        Assertions.assertEquals(5, linearSearch.find(array, i));

        i = array.getItem(9);
        Assertions.assertEquals(9, linearSearch.find(array, i));

        Assertions.assertNotEquals(linearSearch.find(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInMixSortOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new MixSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.find(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.find(array, i), 9);

        Assertions.assertNotEquals(linearSearch.find(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInCombSortOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new CombSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.find(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.find(array, i), 9);

        Assertions.assertNotEquals(linearSearch.find(array, new Element(i.getValue() + 1000)), 9);
    }
}
