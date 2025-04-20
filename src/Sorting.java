//sorting.java
import java.util.Random;

public class Sorting {


    private static long comparison = 0;
    System.out.println("in Sorting class");

    public static long getComparison() {
        return comparison;
    }

    public static void selectionSort(int[] arr) {



        int n = arr.length;

        // go though all position execept last
        for (int i = 0; i <= n - 2; i++) {

            int j = i; // assume is the smallest

            // find the index of i+1 to the last element
            for (int k = i + 1; k <= n-1; k++) {

                comparison++;
                if (arr[k] < arr[j]) {

                    j = k; // j points to new smallest element

                } // if

            } // for j

            // swap smallest element with arr[i]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        } // for i


    } // selectionSort


    public static void mergeSort(int[] arr) {

        // base case
        if (arr.length <= 1) {
            return;
        }

        // gets middle
        int mid = arr.length/2;

        // creates left portion
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        // creates right portion
        int[] right = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // sorts right and left half then merges them
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);

    } // mergeSort


    private static void merge(int[] left, int[] right, int[] arr){
        // used to determine size of left and right halves
        int mid = arr.length/2;

        // index for merged array
        int i = 0;
        // index for left
        int l = 0;
        // index for right
        int r = 0;

        // compare element from R and L and then places the smaller element into arr
        while (l < mid && r < arr.length - mid) {
            comparison++;
            if (left[l] < right[r]) {
                arr[i] = left[l];
                i++;
                l++;
            } else {
                arr[i] = right[r];
                i++;
                r++;
            } // else
        } // while

        // copies remaining elements if any from left and right arrays
        while (l < mid) {
            arr[i] = left[l];
            i++;
            l++;
        } // while
        while(r < arr.length - mid) {
            arr[i] = right[r];
            i++;
            r++;
        } // while


    }

    public static void heapSort(int[] arr) {

        // creates varriable for length of array
        int n = arr.length;

        // creates maxHeap
        maxHeap(arr);

        // sorts elements by removing max element one by one then shortens array length
        for (int i = n - 1; i > 0; i--) {

            // moves max to end of heap
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // insures heapinvarient is satisfied
            heapify(arr, 0, i);
        }


    }

    private static void maxHeap(int arr[]) {

        // stores number of elements
        int numEle = arr.length;
        // bubble up each node using heapify to insure heap invariant is satisfied
        for (int i = numEle/2 - 1; i >= 0; i--) {
            heapify(arr, i, numEle);
        }

    }

    private static void heapify(int arr[], int i, int size) {
        int max = i; // largest value; starts with i being greates
        int left = 2*i + 1; // left child
        int right = 2*i + 2; // right child

        // if left is greater than current max update max
        if (left < size && arr[left] > arr[max]) {
            max = left;
            comparison++;
        } else {
            comparison++;
        }

        // if right child is greater than current max update max
        if (right < size && arr[right] > arr[max]) {
            max = right;
            comparison++;
        } else {
            comparison++;
        }

        // if largest element is not at the root, swap max with the root and heapify
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            // heapify affected subtrees
            heapify(arr, max, size);
        }

    }


    public static void quickSortFirst(int[] arr, int first, int last) {

        // base case
        if (last <= first) {
            return;
        }

        // divides into left and right halves
        int pivot = partitionFirst(arr, first, last);

        // sorts left and right halves
        quickSortFirst(arr, first, pivot - 1);
        quickSortFirst(arr, pivot + 1, last);




    }
    private static int partitionFirst(int[] arr, int first, int last) {

        // makes sure all element to left of pivot are less and to the right are greater
        int pivot = arr[first];
        int i = first + 1;

        for (int j = first + 1; j <= last; j++) {
            comparison++;
            if(arr[j] < pivot) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // places pivot in correct position
        int temp = arr[first];
        arr[first] = arr[i-1];
        arr[i-1] = temp;

        return i-1;


    }

    public static void quickSortRandom(int[] arr, int first, int last) {

        // base case
        if (last <= first) {
            return;
        }

        // splits array into a right and left half
        int pivot = partitionRandom(arr, first, last);

        // sort left and right halves
        quickSortRandom(arr, first, pivot - 1);
        quickSortRandom(arr, pivot + 1, last);




    }

    private static int partitionRandom(int[] arr, int first, int last) {


        // get random index
        Random rand = new Random();
        int randomElement = rand.nextInt(last - first + 1) + first;

        // swap random element and first element

        int temp = arr[first];
        arr[first] = arr[randomElement];
        arr[randomElement] = temp;


        // makes sure all elements to left are less than pivot and elements to the right are greater
        int pivot = arr[first];
        int i = first + 1;

        for (int j = first + 1; j <= last; j++) {
            comparison++;
            if(arr[j] < pivot) {

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // place pivot in correct position
        temp = arr[first];
        arr[first] = arr[i-1];
        arr[i-1] = temp;

        return i-1;


    }


} //sorting
