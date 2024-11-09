package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.example.model.Car;
import org.example.model.Truck;

import java.util.List;

/**
 * Unit tests for the Truck class in the org.example.model package.
 */
public class GenericClassesTest extends TestCase {

    /**
     * Tests adding an object to the truck's load.
     * Ensures that the load size increases correctly.
     */
    public void testAddObjectToLoad() {
        // Create a truck with a maximum capacity of 10 objects
        Truck truck = new Truck(10);

        // Add a Car object to the truck's load
        truck.addObjectToLoad(new Car());

        // Retrieve the current load of the truck
        List<Object> loadObjects = truck.getLoad();

        // Assert that the load size is now 1
        Assert.assertEquals(1, loadObjects.size());
    }

    /**
     * Tests that a RuntimeException is thrown when adding an object to a full truck.
     * Ensures that the truck does not accept more objects than its maximum capacity.
     */
    public void testRuntimeExceptionOnAddObjectIfLoadIsComplete() {
        // Create a truck with a maximum capacity of 1 object
        Truck truck = new Truck(1);

        // Add a Car object to the truck's load
        truck.addObjectToLoad(new Car());

        try {
            // Attempt to add another Car object to the already full truck
            truck.addObjectToLoad(new Car());

            // If we reach this line, the exception was not thrown
            Assert.fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            // Assert that the exception message is as expected
            Assert.assertEquals("max objects overloaded", e.getMessage());
        }
    }
}
