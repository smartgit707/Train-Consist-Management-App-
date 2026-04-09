import java.util.Arrays;

public class UseCase17TrainConsistMgmt {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==========================================\n");

        // 1. Create an array of bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        // Display original names
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        // 2. Use Arrays.sort() for efficient, alphabetical sorting
        // This replaces the manual Bubble Sort logic from UC16
        Arrays.sort(bogieNames);

        // 3. Print the sorted result using Arrays.toString()
        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        System.out.println("UC17 sorting completed...");
    }
}