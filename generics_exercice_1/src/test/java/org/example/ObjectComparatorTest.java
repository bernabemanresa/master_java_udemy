package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for the ObjectsComparator class.
 */
public class ObjectComparatorTest extends TestCase {

    /**
     * Test the maximum method with String objects.
     * This test checks if the maximum of three String objects is determined correctly.
     */
    public void testStringComparator() {
        String a = "abc";
        String b = "bcd";
        String c = "cdf";

        String max = ObjectsComparator.maximum(a, b, c);

        // Assert that the maximum string is correctly identified
        Assert.assertEquals(c, max);
    }

    /**
     * Test the maximum method with Integer objects.
     * This test checks if the maximum of three Integer objects is determined correctly.
     */
    public void testIntegerComparator() {
        Integer a = 1;
        Integer b = 99;
        Integer c = 50;

        Integer max = ObjectsComparator.maximum(a, b, c);

        // Assert that the maximum integer is correctly identified
        Assert.assertEquals(b, max);
    }
}
