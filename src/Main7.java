import java.util.Scanner;

class CountingSort {

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void countingSort(int arr[]) {
        int n = arr.length;

        if (n == 0)
            return;

        // Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // Create count array
        int count[] = new int[max + 1];

        // Store frequency of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Modify count array (cumulative count)
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}

public class Main7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter non-negative integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        CountingSort obj = new CountingSort();

        System.out.println("Original Array:");
        obj.printArray(arr);

        obj.countingSort(arr);

        System.out.println("Sorted Array:");
        obj.printArray(arr);

        sc.close();
    }
}
