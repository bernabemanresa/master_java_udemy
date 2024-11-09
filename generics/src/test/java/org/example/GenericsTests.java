package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.example.model.shapes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for demonstrating the use of generics with various wildcard scenarios.
 */
public class GenericsTests extends TestCase {

    /**
     * Test conversion of an array of Drawable objects to a List of the same type.
     */
    public void testFromArrayToListConversion() {
        // Create an array of Drawable objects
        Drawable[] drawableArray = new Drawable[2];
        drawableArray[0] = new Circle();
        drawableArray[1] = new Rectangle();

        // Convert the Drawable array to a List using a generic method
        List<Drawable> drawablesList = fromArrayToList(drawableArray);

        // Assert the new list is of the same size as the array.
        Assert.assertEquals(2, drawablesList.size());

        Assert.assertEquals(1, 2);
    }

    /**
     * Test handling of a list of Drawable objects with an exact match class.
     */
    public void testExactMatchClass() {
        // Create a list of Drawable objects
        List<Drawable> drawablesList = new ArrayList<>();
        drawablesList.add(new Circle());
        drawablesList.add(new Rectangle());
        drawablesList.add(new SimpleRectangle());

        // Retrieve the draw messages
        List<String> messages = getDrawableClassesMessages(drawablesList);

        // Assert the size of the messages list
        Assert.assertEquals(3, messages.size());
    }

    /**
     * Test handling of a list of Drawables using an upper-bounded wildcard.
     */
    public void testUpperBoundedWildcard() {
        // Create a list of Drawable objects
        List<Drawable> drawablesList = new ArrayList<>();
        drawablesList.add(new Circle());
        drawablesList.add(new Rectangle());
        drawablesList.add(new SimpleRectangle());

        // Retrieve the draw messages using upper-bounded wildcard
        List<String> messages = getDrawableSubclassesMessages(drawablesList);

        // Assert the size of the messages list
        Assert.assertEquals(3, messages.size());
    }

    /**
     * Test handling of a list of supertypes of SimpleRectangle using a lower-bounded wildcard.
     */
    public void testLowerBoundedWildcard() {
        // Create a list of Drawable objects
        List<Drawable> drawablesList = new ArrayList<>();
        drawablesList.add(new Circle());
        drawablesList.add(new Rectangle());
        drawablesList.add(new SimpleRectangle());
        drawablesList.add(new VerySimpleRectangle());

        // Retrieve the draw messages using lower-bounded wildcard
        List<String> messages = getSimpleRectangleSuperclassesMessages(drawablesList);

        // Assert the size of the messages list
        Assert.assertEquals(4, messages.size());
    }

    /**
     * Converts an array of any type to a List of the same type.
     *
     * @param genericArray the array to convert
     * @param <T>          the type of the array elements
     * @return a List containing the elements of the array
     */
    private static <T> List<T> fromArrayToList(T[] genericArray) {
        return Arrays.asList(genericArray);
    }

    /**
     * This method takes a list of Drawable objects and returns a list of strings
     * containing the result of calling the draw method on each element.
     *
     * @param drawables A list of Drawable objects.
     * @return A list of strings where each string is the result of the draw method
     * called on the corresponding element in the input list.
     */
    private static List<String> getDrawableClassesMessages(List<Drawable> drawables) {
        List<String> messages = new ArrayList<>();

        for (Drawable drawable : drawables) {
            messages.add(drawable.draw());
        }

        return messages;
    }

    /**
     * This method takes a list of objects that are subtypes of Drawable, calls the draw method on each
     * element in the list, and returns a list of strings containing the results of each draw call.
     *
     * @param drawables A list of objects that extend the Drawable interface.
     * @return A list of strings where each string is the result of the draw method
     * called on the corresponding element in the input list.
     */
    private static List<String> getDrawableSubclassesMessages(List<? extends Drawable> drawables) {
        List<String> messages = new ArrayList<>();

        for (Drawable drawable : drawables) {
            messages.add(drawable.draw());
        }

        return messages;
    }

    /**
     * This method takes a list of objects that are supertypes of SimpleRectangle, calls the draw method on each
     * element, and returns a list of strings containing the results of each draw call.
     *
     * @param simpleRectangles A list of objects that are supertypes of SimpleRectangle.
     * @return A list of strings where each string is the result of the draw method
     * called on the corresponding element in the input list.
     */
    private static List<String> getSimpleRectangleSuperclassesMessages(List<? super SimpleRectangle> simpleRectangles) {
        List<String> messages = new ArrayList<>();
        simpleRectangles.forEach(s -> messages.add(((Drawable) s).draw()));
        return messages;
    }

}
