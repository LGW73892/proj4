//SortDriver.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SortDriver {

    public static void main(String[] args) {

    System.out.println("in SortDriver class MAIN");

    String fileName = args[0];
    int[] numArr;
    int count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        String line1;
        while ((line1 = br.readLine()) != null) {

            String[] numbers = line1.split("\\s+");
            count += numbers.length;


        } //while

    } catch (IOException e) {

        System.out.println("Error reading the file");
        return;
    } // try -> catch

    numArr = new int[count];
    int index = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        String line2;
        while ((line2 = br.readLine()) != null) {

            String[] numbers = line2.split("\\s+");

            for (String num : numbers) {

                try {

                    numArr[index++] = Integer.parseInt(num.trim());

                } catch (NumberFormatException e) {

                    System.out.println("Invalid number format in file: " + num);

                } // try -> catch

            } // for

        } //while


    } catch (IOException e) {


        System.out.println("Error reading the file: " + e.getMessage());

    } // catch

        // Print the array
    System.out.println("Array of integers:");
    for (int value : numArr) {
        System.out.print(value + " ");
    }

    System.out.println("");
    System.out.println("slection-sort (s)");
    System.out.println("merge-sort (m)");
    System.out.println("heap-sort (h)");
    System.out.println("quick-sort-fp (q)");
    System.out.println("quick-sort-rp (r)");
    System.out.println("Enter the algorithm: ");

    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    System.out.print("");

    if (str.equals("s")) {
        System.out.println("testing selection-sort");
        Sorting.selectionSort(numArr);

    } else if (str.equals("m")) {
        System.out.println("testing merge-sort");

    } else if (str.equals("h")) {
        System.out.println("testing heap-sort");

    } else {
        System.out.println("invalid command");
    } // if -> else if -> else if -> else

    } // main
} // SortDriver
