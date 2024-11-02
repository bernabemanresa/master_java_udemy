package org.example;

import org.example.model.Animal;
import org.example.model.Circle;
import org.example.model.Client;
import org.example.model.Drawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of generics in Java.
 */
public class App {
    public static void main(String[] args) {

        // Define a list of Client objects
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Paul", "McCartney"));
        clients.add(new Client("John", "Lennon"));

        // Retrieve and print client information
        Client c1 = clients.get(0);
        Client c2 = clients.get(1);
        System.out.println("Client List:");
        System.out.println(c1);  // Expected output: Client{name='Paul', surname='McCartney'}
        System.out.println(c2);  // Expected output: Client{name='John', surname='Lennon'}

        // Create an array of Animal objects
        Animal[] animalsArray = new Animal[2];
        animalsArray[0] = new Animal("Lion", false);  // Lion is not a bird
        animalsArray[1] = new Animal("Bird", true);   // Bird can fly

        // Convert the Animal array to a List using a generic method
        List<Animal> animalsList = fromArrayToList(animalsArray);
        System.out.println("\nAnimal List:");
        animalsList.forEach(System.out::println);  // Print all animals

        // Repeat the process with a Client array
        Client[] clientsArray = new Client[2];
        clientsArray[0] = new Client("Ringo", "Starr");
        clientsArray[1] = new Client("George", "Harrison");

        // Convert the Client array to a List
        List<Client> clientsList = fromArrayToList(clientsArray);
        System.out.println("\nAdditional Client List:");
        clientsList.forEach(System.out::println);  // Print all clients

        // Create a list of Circle objects, which implement Drawable
        Circle circle = new Circle();
        List<Circle> circlesList = new ArrayList<>();
        circlesList.add(circle);

        // Print all Drawable objects in the list
        printDrawablesList(circlesList);

        // Check if two arrays have the same length
        System.out.println(checkArraysSizesEquals(animalsArray, animalsArray));  // Expected output: true

        System.out.println("Bye!");
    }

    /**
     * Converts an array of any type to a List of the same type.
     *
     * @param genericArray the array to convert
     * @param <T> the type of the array elements
     * @return a List containing the elements of the array
     */
    private static <T> List<T> fromArrayToList(T[] genericArray) {
        return Arrays.asList(genericArray);
    }

    /**
     * Prints a list of objects that implement the Drawable interface.
     *
     * @param drawablesList the list of Drawable objects
     */
    private static void printDrawablesList(List<? extends Drawable> drawablesList) {
        // Call the draw method on each element in the list
        drawablesList.forEach(Drawable::draw);
    }

    /**
     * Checks if two arrays have the same length.
     *
     * @param t the first array
     * @param x the second array
     * @param <T> the type of the first array elements
     * @param <X> the type of the second array elements
     * @return true if both arrays have the same length, false otherwise
     */
    private static <T, X> boolean checkArraysSizesEquals(T[] t, X[] x) {
        return t.length == x.length;
    }
}
