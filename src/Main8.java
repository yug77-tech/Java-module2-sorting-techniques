import java.util.Scanner;

class RadixSort {

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // Counting Sort used by Radix Sort (based on digit represented by exp)
    void countingSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10]; // digits 0-9

        // Store count of occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it contains actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    void radixSort(int arr[]) {
        int max = getMax(arr);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);

            System.out.println("After sorting on digit place " + exp + ":");
            printArray(arr);
            System.out.println();
        }
    }
}

public class Main8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter non-negative integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        RadixSort obj = new RadixSort();

        System.out.println("Original Array:");
        obj.printArray(arr);
        System.out.println();

        obj.radixSort(arr);

        System.out.println("Final Sorted Array:");
        obj.printArray(arr);

        sc.close();
    }
}
