public class UseCase16TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort");
        System.out.println("========================================\n");

        // Original capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Print original
        System.out.println("Original Capacities:");
        printArray(capacities);

        // Bubble Sort (Ascending)
        bubbleSort(capacities);

        // Print sorted
        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }

    // ---- Bubble Sort Logic ----
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Track if any swap happens (optimization)
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps, array is already sorted
            if (!swapped) break;
        }
    }

    // ---- Utility Method ----
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}