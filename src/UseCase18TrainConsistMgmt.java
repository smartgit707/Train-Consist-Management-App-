import java.util.Scanner;

public class UseCase18TrainConsistMgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==========================================\n");

        // 1. Create an array of bogie IDs (unsorted)
        String[] bogieIDs = {
                "B6101",
                "B6205",
                "B6309",
                "B6412",
                "B6550"
        };

        // Display available bogie IDs
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.println(id);
        }
        System.out.println();

        // 2. Take search input from user
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine().trim();

        // 3. Perform Linear Search
        boolean found = false;
        String foundID = "";

        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                found = true;
                foundID = id;
                break;                    // Early termination - important for linear search
            }
        }

        // 4. Display result
        if (found) {
            System.out.println("\nBogie " + foundID + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchKey + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed...");

        sc.close();
    }
}