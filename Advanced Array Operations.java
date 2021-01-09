/*
****** IDS 401 HW2 ******
**** Zuzanna Liberto ****
******** Seat 15 ********
** Completed? Y[x] N[] **
 */

import java.util.Random;
import java.util.Scanner;

public class HW2 {

    // define and initialize variables
    Scanner scan = new Scanner(System.in);
    public int[] initialArray = new int[50];
    public int[] finalArray = new int[50];

    public int searchKey;
    public boolean keyFound;

    public static void main(String[] args) {

        System.out.println("\nWelcome to the array app.\n" + "\nThis app will: \n1. Generate an integer array filled with 50 random integer values.\n2. Ask for a user input of a integer search key and look for it in the array.\n3. Print the unsorted array.\n4. Find and print local extrema.\n5. Copy the values of the array to another array.\n6. Sort and display the sorted array.\n" );

        // create an object
        HW2 obj = new HW2();

        // fill the array with random integers
        obj.initialArray = obj.getRandomNumbers(obj.initialArray);

        // prompt the user to input a search key integer, assign the returned value to a variable
        System.out.println("\nThe initial array is ready. Please input an integer search key you'd want to search for > ");
        obj.searchKey = obj.scan.nextInt();

        // call the method responsible for finding the search key, assign the returned value to a variable
        obj.keyFound = obj.isKeyFound(obj.initialArray, obj.searchKey);

        // print these statements depending on the value of the keyFound variable
        if (obj.keyFound == true) {
            System.out.println("\nThe key was found in the set.\n");
        } else {
            System.out.println("\nThe key is not in the set\n");
        }

        // print the elements of the initial array
        System.out.println("\nThe initial (unsorted) array consists of the following values: ");
        obj.printArray(obj.initialArray);

        // call the method responsible for finding and printing local extrema
        obj.printExtrema(obj.initialArray, "min");
        obj.printExtrema(obj.initialArray, "max");

        // call the method responsible for copying arrays, assign the returned value to a variable
        obj.finalArray = obj.copyArray(obj.initialArray, obj.finalArray);

        // call the methods responsible for sorting and printing of arrays
        obj.sortArray(obj.finalArray);

        System.out.println("\nThe final sorted array consists of the following values: ");
        obj.printArray(obj.finalArray);

        System.out.println("\nGoodbye!");

    }

    public int[] getRandomNumbers(int[] initArray) {

        // This method takes an integer array as an argument and returns it filled with random integer values

        Random rand = new Random();

        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = rand.nextInt(100);
        }
        return initArray;

    }

    public void printArray(int[] array) {

        // This method takes an integer array as an argument and prints its elements.

        int[] printNumbering = new int[50]; //This array is to offset the indices for the print text

        for (int i = 0; i < array.length; i++) {
            printNumbering[i] = i + 1;
            System.out.println("Value " + printNumbering[i] + " is: " + array[i]);
        }

    }

    public void printExtrema(int[] array, String type) {

        //This method takes an integer array and a type string indicating whether a minimum or maximum is needed.
        //It doesn't return anything. Instead, it prints out the values to a user.

        int minIndex = 0, maxIndex = 0;

        switch (type) {
            case "min":
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[minIndex]) {
                        minIndex = i;
                    }
                }
                System.out.println("\nThe minimum value in the set is: " + array[minIndex]);
                break;

            case "max":
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > array[maxIndex]) {
                        maxIndex = i;
                    }
                }
                System.out.println("\nThe maximum value in the set is: " + array[maxIndex]);
                break;
        }
    }

    public boolean isKeyFound(int[] array, int key) {

        // This method takes an integer array and an integer key as arguments. It returns a boolean value indicating whether
        // the search key was found or not.

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }

        }
        return false;
    }

    public int[] copyArray(int[] initArray, int[] destArray) {

        // This method takes an integer source array and an integer destination array and copies the values of the source
        // array to the destination array. It returns the destination array.

        for (int i = 0; i < initArray.length; i++) {
            destArray[i] = initArray[i];
        }
        return destArray;
    }

    public void sortArray(int[] array) {

        // This method sorts the values of an array. It takes an integer array and doesn't return anything.

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++ ) {
                if (array[j] < array[min]) {
                    min = j;
                }

            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

}




