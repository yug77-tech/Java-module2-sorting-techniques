import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class BucketSort {

    void printArray(float arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void bucketSort(float arr[]) {
        int n = arr.length;

        if (n <= 0)
            return;

        // Create n empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Put array elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)(arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }
}

public class Main6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        float arr[] = new float[n];

        System.out.println("Enter floating-point numbers in range [0,1):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
        }

        BucketSort obj = new BucketSort();

        obj.bucketSort(arr);

        System.out.println("Sorted Array:");
        obj.printArray(arr);

        sc.close();
    }
}
