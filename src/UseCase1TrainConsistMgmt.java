import java.util.*;
import java.util.stream.Collectors;

public class UseCase1TrainConsistMgmt {

    // Helper Class for UC7, UC8 & UC9
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

        // ================= UC1 to UC5 (Previous Operations) =================
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();

        // ================= UC6: HashMap Capacity Mapping =================
        Map<String, Integer> bogieCapacityMap = new HashMap<>();
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 54);
        bogieCapacityMap.put("First Class", 36);

        // ================= UC7: Sorting with Comparator =================
        System.out.println("\n=== UC7: Sorting Bogies ===");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("Sleeper", 72)); // Adding a second Sleeper for UC9 grouping
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 36));

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorted: " + bogieList);

        // ================= UC8: Filtering with Streams =================
        System.out.println("\n=== UC8: Filtering Bogies (> 50) ===");
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.getCapacity() > 50)
                .toList();
        System.out.println("Filtered List: " + filtered);

        // ================= UC9: Grouping by Type (Collectors.groupingBy) =================
        System.out.println("\n=== UC9: Grouping Bogies by Type ===");

        // 1. Convert list to stream
        // 2. Use Collectors.groupingBy to group by the Bogie Name
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the structured Map

        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: [" + type + "] -> " + list);
        });

        System.out.println("\nUC9 operations completed. Data is now categorized.");
    }
}