import java.util.Scanner;

class InsertionSortWithCount {

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void insertionSort(int arr[]) {
        int n = arr.length;
        int totalComparisons = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            int iterationComparisons = 0;

            while (j >= 0) {
                iterationComparisons++;
                totalComparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;

            System.out.println("After iteration " + i + ":");
            printArray(arr);
            System.out.println("Comparisons in this iteration: " + iterationComparisons);
            System.out.println();
        }

        System.out.println("Total Comparisons: " + totalComparisons);
    }
}

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        InsertionSortWithCount obj = new InsertionSortWithCount();
        obj.insertionSort(arr);

        sc.close();
    }
}
