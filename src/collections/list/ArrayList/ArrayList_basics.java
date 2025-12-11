import java.util.ArrayList;

public class ArrayList_basics {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> colors = new ArrayList<>();

        // Add elements
        colors.add("Blue"); // adds to the end
        colors.add("Red");
        colors.add(1, "Green"); // Inserts "Green" at index 1

        // Access elements
        String firstColor = colors.get(0); // Returns the element at index 0

        // Change an element
        colors.set(2, "Yellow"); // Replaces the element at index 2

        // Remove an element
        colors.remove(0); // Removes the element at index 0

        // Get the size
        int size = colors.size(); // Returns the number of elements
        
        System.out.println("ArrayList: " + colors); 
        // Example output after operations: ArrayList: [Green, Yellow]
    }
}
