import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==========================================\n");

        // Input data (if unsorted, we must sort it first as per requirements)
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Step 1: Precondition - Sort the array
        Arrays.sort(bogieIDs);

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }
        System.out.println();

        // Step 2: Define search key
        String searchKey = "BG309";

        // Step 3: Perform Binary Search
        boolean found = performBinarySearch(bogieIDs, searchKey);

        if (found) {
            System.out.println("Bogie " + searchKey + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC19 search completed...");
    }

    /**
     * Manual implementation of Binary Search logic
     */
    public static boolean performBinarySearch(String[] arr, String key) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Compare key with middle value using compareTo()
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // Match Found
            } else if (comparison > 0) {
                low = mid + 1; // Key is in the right half
            } else {
                high = mid - 1; // Key is in the left half
            }
        }

        return false; // Exhausted search range, not found
    }
}