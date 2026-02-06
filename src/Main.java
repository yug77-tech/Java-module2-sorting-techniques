import java.util.Scanner;

class SortingMethods {

    // print array
    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // a. Insertion Sort
    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            System.out.println("After iteration " + i + ":");
            printArray(arr);
        }
    }

    // b. Bubble Sort
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("After iteration " + (i + 1) + ":");
            printArray(arr);
        }
    }

    // c. Merge Sort
    void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

            System.out.println("After merging from index " + left + " to " + right + ":");
            printArray(arr);
        }
    }

    void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Create copies
        int arr2[] = arr1.clone();
        int arr3[] = arr1.clone();

        SortingMethods obj = new SortingMethods();

        System.out.println("\nInsertion Sort:");
        obj.insertionSort(arr1);

        System.out.println("\nBubble Sort:");
        obj.bubbleSort(arr2);

        System.out.println("\nMerge Sort:");
        obj.mergeSort(arr3, 0, arr3.length - 1);

        sc.close();
    }
}
