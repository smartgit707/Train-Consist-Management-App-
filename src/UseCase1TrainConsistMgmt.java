import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UseCase1TrainConsistMgmt {

    // Helper Class for Advanced Use Cases (UC7 - UC11)
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

    public static void main(String[] args) {

        // ================= UC1: Initialization =================
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("UC1: Initial Bogie Count: " + trainConsist.size());

        // ================= UC2: List Operations =================
        List<String> passengerNames = new ArrayList<>();
        passengerNames.add("Sleeper");
        passengerNames.add("AC Chair");
        passengerNames.add("First Class");
        passengerNames.remove("AC Chair");
        System.out.println("UC2: Passenger Bogies: " + passengerNames);

        // ================= UC3: HashSet (Uniqueness) =================
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG101"); // Duplicate ignored
        System.out.println("UC3: Unique IDs: " + bogieIDs);

        // ================= UC4: LinkedList (Order) =================
        LinkedList<String> orderedTrain = new LinkedList<>();
        orderedTrain.add("Engine");
        orderedTrain.add("Guard");
        orderedTrain.add(1, "Pantry Car");
        System.out.println("UC4: Ordered Sequence: " + orderedTrain);

        // ================= UC5: LinkedHashSet =================
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Sleeper"); // Ignored
        System.out.println("UC5: Formation: " + formation);

        // ================= UC6: HashMap =================
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 54);
        System.out.println("UC6: Capacity Map: " + capacityMap);

        // --- Setup for UC7 - UC11 ---
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 36));

        // ================= UC7: Sorting =================
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nUC7: Sorted Bogies: " + bogieList);

        // ================= UC8: Filtering =================
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.getCapacity() > 50)
                .toList();
        System.out.println("UC8: Filtered (>50): " + filtered);

        // ================= UC9: Grouping =================
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
        System.out.println("UC9: Grouped by Type: " + grouped.keySet());

        // ================= UC10: Reduction =================
        int totalSeats = bogieList.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("UC10: Total Train Seats: " + totalSeats);

        // ================= UC11: Regex Validation =================
        System.out.println("\n=== UC11: Input Validation (Regex) ===");
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean isTrainValid = Pattern.matches("TRN-\\d{4}", trainId);
        boolean isCargoValid = Pattern.matches("PET-[A-Z]{2}", cargoCode);

        System.out.println("Train ID " + trainId + " Valid? " + isTrainValid);
        System.out.println("Cargo Code " + cargoCode + " Valid? " + isCargoValid);

        System.out.println("\n=== All Use Cases (1-11) Successfully Executed ===");
    }
}