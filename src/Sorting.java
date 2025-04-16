//sorting.java

public class Sorting {

    System.out.println("in Sorting class");


    public static void selectionSort(int[] arr) {

        System.out.println("in selectionSort");

        for (int i = 0; i < (n - 2) i++) {

            int j = i;

            for (int k = i + 1; k < n-1; k++) {

                if (arr[k] < arr[j]) {

                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[j] = temp;


                } // if

            } // for j


        } // for i


    } // selectionSort

} //sorting
