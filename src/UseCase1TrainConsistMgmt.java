import java.util.ArrayList;
import java.util.List;

public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("=======================================\n");

        // Create dynamic list for entire train consist
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...\n");

        // ================= UC2 =================
        System.out.println("=======================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("=======================================\n");

        // Create list for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display after adding bogies
        System.out.println("Bogies after addition: " + passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Check if Sleeper bogie exists
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie is available in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT available.");
        }

        // Display final state of passenger bogies
        System.out.println("Final bogies after removal: " + passengerBogies);

        System.out.println("\nUC2 operations completed.");
    }
}