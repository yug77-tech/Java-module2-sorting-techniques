import java.util.Scanner;
import java.util.Random;

class SortingMethods2 {

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // SELECTION SORT
    void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("After iteration " + (i + 1) + ":");
            printArray(arr);
        }
    }

    //  QUICK SORT (PIVOT FIRST)
    void quickSortFirst(int arr[], int low, int high) {
        if (low < high) {
            int pi = partitionFirst(arr, low, high);
            System.out.println("After partition (First Pivot):");
            printArray(arr);

            quickSortFirst(arr, low, pi - 1);
            quickSortFirst(arr, pi + 1, high);
        }
    }

    int partitionFirst(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= j && arr[i] <= pivot)
                i++;
            while (i <= j && arr[j] > pivot)
                j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }

    //  QUICK SORT (PIVOT LAST)
    void quickSortLast(int arr[], int low, int high) {
        if (low < high) {
            int pi = partitionLast(arr, low, high);
            System.out.println("After partition (Last Pivot):");
            printArray(arr);

            quickSortLast(arr, low, pi - 1);
            quickSortLast(arr, pi + 1, high);
        }
    }

    int partitionLast(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    //  QUICK SORT (RANDOM PIVOT)
    void quickSortRandom(int arr[], int low, int high) {
        if (low < high) {
            int pi = partitionRandom(arr, low, high);
            System.out.println("After partition (Random Pivot):");
            printArray(arr);

            quickSortRandom(arr, low, pi - 1);
            quickSortRandom(arr, pi + 1, high);
        }
    }

    int partitionRandom(int arr[], int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);

        int temp1 = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp1;

        return partitionLast(arr, low, high);
    }
}

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int arr2[] = arr1.clone();
        int arr3[] = arr1.clone();
        int arr4[] = arr1.clone();

        SortingMethods2 obj = new SortingMethods2();

        System.out.println("\nSelection Sort:");
        obj.selectionSort(arr1);

        System.out.println("\nQuick Sort (Pivot = First):");
        obj.quickSortFirst(arr2, 0, arr2.length - 1);

        System.out.println("\nQuick Sort (Pivot = Last):");
        obj.quickSortLast(arr3, 0, arr3.length - 1);

        System.out.println("\nQuick Sort (Pivot = Random):");
        obj.quickSortRandom(arr4, 0, arr4.length - 1);

        sc.close();
    }
}
