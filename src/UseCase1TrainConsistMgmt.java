import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// --- UC14: Custom Exception Class ---
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase1TrainConsistMgmt {

    // Updated Bogie Class with Fail-Fast Validation (UC14)
    public static class Bogie {
        private String name;
        private int capacity;

        // Constructor now throws a Checked Exception
        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return name + " (Cap: " + capacity + ")";
        }
    }

    public static void main(String[] args) {
        // ================= UC1 to UC13 Recap =================
        // (Lists, Sets, Maps, Streams, Regex, Benchmarking)

        System.out.println("=== Train Consist Management App ===");

        // ================= UC14: Custom Exception Handling =================
        System.out.println("\n=======================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=======================================\n");

        List<Bogie> safeBogieList = new ArrayList<>();

        // Test Case 1: Valid Capacity
        try {
            System.out.println("Attempting to create a valid bogie (Sleeper, 72)...");
            Bogie b1 = new Bogie("Sleeper", 72);
            safeBogieList.add(b1);
            System.out.println("✔ Success: " + b1);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        // Test Case 2: Zero Capacity (Should Fail)
        try {
            System.out.println("\nAttempting to create an invalid bogie (Empty, 0)...");
            Bogie b2 = new Bogie("Empty", 0);
            safeBogieList.add(b2);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        // Test Case 3: Negative Capacity (Should Fail)
        try {
            System.out.println("\nAttempting to create an invalid bogie (Broken, -10)...");
            Bogie b3 = new Bogie("Broken", -10);
            safeBogieList.add(b3);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nFinal Valid Bogie Count: " + safeBogieList.size());
        System.out.println("\n=== All Use Cases (1-14) Successfully Completed ===");
    }
}