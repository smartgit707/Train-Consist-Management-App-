import java.util.*;
import java.util.stream.Collectors;

public class UseCase1TrainConsistMgmt {

    // Helper Class for UC7 & UC8
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
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // ================= UC1: ArrayList Initialization =================
        System.out.println("=== UC1: Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized. Initial Bogie Count: " + trainConsist.size());

        // ================= UC2: List Operations =================
        System.out.println("\n=== UC2: Add/Remove Passenger Bogies ===");
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.remove("AC Chair");
        System.out.println("Current Passenger Bogies: " + passengerBogies);

        // ================= UC3: HashSet for Unique IDs =================
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101"); // Duplicate ignored
        System.out.println("Unique IDs: " + bogieIDs);

        // ================= UC4: LinkedList for Order =================
        System.out.println("\n=== UC4: Ordered Train (LinkedList) ===");
        LinkedList<String> orderedTrain = new LinkedList<>();
        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("Guard");
        orderedTrain.add(1, "Pantry Car"); // Insert at index 1
        System.out.println("Train Sequence: " + orderedTrain);

        // ================= UC5: LinkedHashSet for Preservation =================
        System.out.println("\n=== UC5: Unique & Ordered Formation ===");
        LinkedHashSet<String> linkedHashTrain = new LinkedHashSet<>();
        linkedHashTrain.add("Engine");
        linkedHashTrain.add("Sleeper");
        linkedHashTrain.add("Cargo");
        linkedHashTrain.add("Sleeper"); // Duplicate ignored
        System.out.println("Formation: " + linkedHashTrain);

        // ================= UC6: HashMap for Capacity Mapping =================
        System.out.println("\n=== UC6: Bogie to Capacity Mapping ===");
        Map<String, Integer> bogieCapacityMap = new HashMap<>();
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 54);
        bogieCapacityMap.put("First Class", 36);
        bogieCapacityMap.forEach((k, v) -> System.out.println(k + " capacity: " + v));

        // ================= UC7: Comparator Sorting =================
        System.out.println("\n=== UC7: Sorting Bogies by Capacity ===");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 36));

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorted Bogies: " + bogieList);

        // ================= UC8: Stream API Filtering =================
        System.out.println("\n=== UC8: Filter High-Capacity Bogies (> 50) ===");

        List<Bogie> highCapacity = bogieList.stream()
                .filter(b -> b.getCapacity() > 50)
                .toList();

        highCapacity.forEach(b -> System.out.println("Filtered: " + b.getName()));

        System.out.println("\nAll Use Cases (1-8) successfully executed.");
    }
}