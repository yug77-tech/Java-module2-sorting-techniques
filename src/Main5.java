import java.util.Scanner;

class HeapSortWithCount {

    int totalComparisons = 0;

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void heapSort(int arr[]) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            int comparisons = heapify(arr, n, i);
            System.out.println("Comparisons in heapify (build phase): " + comparisons);
            printArray(arr);
            System.out.println();
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            // Swap root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            int comparisons = heapify(arr, i, 0);

            System.out.println("After extracting element " + (n - i) + ":");
            printArray(arr);
            System.out.println("Comparisons in this iteration: " + comparisons);
            System.out.println();
        }

        System.out.println("Total Comparisons: " + totalComparisons);
    }

    int heapify(int arr[], int n, int i) {
        int comparisons = 0;

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;
            totalComparisons++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparisons++;
            totalComparisons++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            comparisons += heapify(arr, n, largest);
        }

        return comparisons;
    }
}

public class Main5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        HeapSortWithCount obj = new HeapSortWithCount();
        obj.heapSort(arr);

        sc.close();
    }
}
