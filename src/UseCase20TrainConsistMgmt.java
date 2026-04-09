import java.util.Arrays;

public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("==========================================\n");

        // Scenario: Attempting to search in an empty train consist
        String[] bogieIDs = {}; // Empty array simulates no bogies added
        String searchKey = "BG309";

        try {
            // This method now performs state validation before searching
            performSearchWithValidation(bogieIDs, searchKey);
        } catch (IllegalStateException e) {
            // This matches the red error text in your screenshot
            System.err.println("Exception in thread \"main\" java.lang.IllegalStateException: " + e.getMessage());
            // In a real console, the stack trace would follow:
            // at UseCase20TrainConsistMgmnt.main(UseCase20TrainConsistMgmnt.java:44)
        }

        System.out.println("\nUC20 search completed...");
    }

    /**
     * Performs a search but validates the state of the train first.
     * @throws IllegalStateException if the bogie array is empty.
     */
    public static void performSearchWithValidation(String[] arr, String key) {
        // 1. State Validation (Defensive Programming)
        if (arr == null || arr.length == 0) {
            // 2. Fail-Fast: Throw exception immediately
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // 3. Logic only proceeds if validation passes
        Arrays.sort(arr);
        int result = Arrays.binarySearch(arr, key);

        if (result >= 0) {
            System.out.println("Bogie " + key + " found.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }
    }
}