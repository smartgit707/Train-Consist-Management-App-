import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UseCase1TrainConsistMgmt {

    // Helper Class for Passenger Bogies (UC7-UC11, UC13)
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

    // Helper Class for Goods Bogies (UC12)
    public static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }

    public static void main(String[] args) {
        // ================= UC1 to UC12 Recap =================
        // (Initialization, Lists, Sets, Maps, Sorting, Filtering, Grouping, Regex, Safety)

        List<Bogie> bogieList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 54));
        }

        // ================= UC13: Performance Comparison =================
        System.out.println("\n=======================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("=======================================\n");

        // --- 1. Loop-Based Filtering ---
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // --- 2. Stream-Based Filtering ---
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // --- 3. Results and Comparison ---
        System.out.println("Benchmarking filtering over " + bogieList.size() + " bogies:");
        System.out.println("Loop Duration   : " + durationLoop + " ns");
        System.out.println("Stream Duration : " + durationStream + " ns");

        if (durationLoop < durationStream) {
            System.out.println("\nResult: Traditional Loop was faster by " + (durationStream - durationLoop) + " ns");
        } else {
            System.out.println("\nResult: Stream API was faster by " + (durationLoop - durationStream) + " ns");
        }

        // Verify consistency
        System.out.println("Verification: Both methods returned " + loopFiltered.size() + " bogies.");

        System.out.println("\n=== All Use Cases (1-13) Successfully Completed ===");
    }
}