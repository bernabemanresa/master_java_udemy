package org.example;

/**
 * A utility class for comparing objects.
 */
public class ObjectsComparator {

    /**
     * Returns the maximum of three comparable objects.
     *
     * @param <T> the type of objects being compared, which must implement Comparable
     * @param a the first object
     * @param b the second object
     * @param c the third object
     * @return the maximum object among the three provided
     * @throws NullPointerException if any of the objects are null
     */
    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        if (a == null || b == null || c == null) {
            throw new NullPointerException("One or more arguments are null");
        }

        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;

        return max;
    }
}
