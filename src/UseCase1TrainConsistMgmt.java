import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UseCase1TrainConsistMgmt {

    // Helper Class for Passenger Bogies (UC7-UC11)
    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
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

    // New Helper Class for Goods Bogies (UC12)
    public static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }

        @Override
        public String toString() {
            return type + " carrying " + cargo;
        }
    }

    public static void main(String[] args) {

        // ================= UC1 to UC6 (Basic Collections) =================
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        Set<String> bogieIDs = new HashSet<>();
        Map<String, Integer> capacityMap = new HashMap<>();
        // ... (Logic remains same as previous versions)

        // ================= UC7 to UC10 (Streams & Aggregation) =================
        List<Bogie> passengerList = new ArrayList<>();
        passengerList.add(new Bogie("Sleeper", 72));
        passengerList.add(new Bogie("AC Chair", 54));

        int totalSeats = passengerList.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
        System.out.println("Total Seats: " + totalSeats);

        // ================= UC11: Regex Validation =================
        boolean isTrainValid = Pattern.matches("TRN-\\d{4}", "TRN-1234");
        System.out.println("Train ID Format Valid: " + isTrainValid);

        // ================= UC12: Safety Compliance Check (allMatch) =================
        System.out.println("\n=======================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("=======================================\n");

        // 1. Prepare a list of Goods Bogies
        List<GoodsBogie> goodsTrain = new ArrayList<>();
        goodsTrain.add(new GoodsBogie("Open", "Coal"));
        goodsTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsTrain.add(new GoodsBogie("Box", "Grain"));
        // Uncomment the next line to test a safety violation:
        // goodsTrain.add(new GoodsBogie("Cylindrical", "Coal"));

        // 2. Define the Safety Rule:
        // IF type is Cylindrical, THEN cargo MUST be Petroleum.

        boolean isSafe = goodsTrain.stream().allMatch(b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are always safe in this rule
        });

        // 3. Display Result
        System.out.println("Checking Goods Train Formation...");
        for (GoodsBogie gb : goodsTrain) {
            System.out.println(">> Checking: " + gb);
        }

        if (isSafe) {
            System.out.println("\n✅ STATUS: Train is Safety Compliant.");
        } else {
            System.out.println("\n❌ ALERT: Safety Violation Detected! Cylindrical bogies can only carry Petroleum.");
        }

        System.out.println("\n=== All Use Cases (1-12) Successfully Completed ===");
    }
}