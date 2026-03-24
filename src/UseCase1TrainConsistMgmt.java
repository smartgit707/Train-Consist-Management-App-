import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("=======================================\n");

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

        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate
        System.out.println("Unique Bogie IDs in the train: " + bogieIDs);
        System.out.println("\nUC3 operations completed.\n");

        // ================= UC4 =================
        System.out.println("=======================================");
        System.out.println("UC4 - Maintain Ordered Bogie IDs (LinkedList)");
        System.out.println("=======================================\n");

        // Create LinkedList for ordered train consist
        LinkedList<String> orderedTrain = new LinkedList<>();

        // Add bogies in sequence
        orderedTrain.add("Engine");   // add at end
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

        System.out.println("Initial ordered train consist: " + orderedTrain);

        // Insert Pantry Car at position 2 (3rd position, zero-based index)
        orderedTrain.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + orderedTrain);

        // Remove first and last bogie
        orderedTrain.removeFirst(); // removes Engine
        orderedTrain.removeLast();  // removes Guard
        System.out.println("After removing first and last bogie: " + orderedTrain);

        System.out.println("\nUC4 operations completed.");
    }
}