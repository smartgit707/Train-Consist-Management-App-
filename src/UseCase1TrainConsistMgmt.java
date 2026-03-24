import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Initialize train consist
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);
        System.out.println("\nSystem ready for operations...\n");

        // ================= UC2 =================
        System.out.println("=======================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("=======================================\n");

        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Bogies after addition: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie is available in the train.");
        }
        System.out.println("Final bogies after removal: " + passengerBogies);
        System.out.println("\nUC2 operations completed.\n");

        // ================= UC3 =================
        System.out.println("=======================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=======================================\n");

        // Create a HashSet for unique bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs (intentionally include duplicates)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs in the train: " + bogieIDs);

        System.out.println("\nUC3 operations completed.");
    }
}