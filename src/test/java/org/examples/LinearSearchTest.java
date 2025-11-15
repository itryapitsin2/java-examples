package org.examples;

import cs.algorithms.search.LinearSearch;
import cs.types.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class LinearSearchTest {

    @Test
    public void testSearch() {
        int maxCount = 25;
        Array<Integer> array = new Array<>(Integer.class, maxCount);
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, rand.nextInt(100));
        }

        int i = array.getItem(5);
        LinearSearch<Integer> linearSearch = new LinearSearch<>();
        Assertions.assertEquals(linearSearch.find(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.find(array, i), 9);

        Assertions.assertNotEquals(linearSearch.find(array, i + 1000), 9);
    }
}
