import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Mid2 {
    Scanner scan, scan2;
    int selection;
    int[] numbers, newNumbers;
    File file;

    public static void main(String[] args) throws IOException {

        Mid2 obj = new Mid2();
        obj.file = new File("/Users/zliberto/Downloads/input.txt");


        obj.scan = new Scanner(obj.file);
        obj.numbers = new int[10];


        for (int i = 0; i < obj.numbers.length; i++) {
            obj.numbers[i] = obj.scan.nextInt();
        }

        System.out.println("\n****** IDS401 Exam2 Menu Select ******\n");
        System.out.println("Menu: \n1. Show data\n2. Find Extrema (Minimum/maximum)\n3. Calculate average value\n4. Find Nth smallest value\n5. Delete data\n0. Exit\n");

        obj.scan2 = new Scanner(System.in);

        do {
            System.out.println("\nMenu Selection >");
            obj.selection = obj.scan2.nextInt();

            switch (obj.selection) {
                case 1:
                    obj.showArray(obj.numbers);
                    break;

                case 2:
                    obj.printExtrema(obj.numbers);
                    break;

                case 3:
                    obj.printAverage(obj.numbers);
                    break;

                case 4:
                    obj.printNthSmallest(obj.numbers);
                    break;

                case 5:
                    System.out.println("Please enter value to delete: ");
                    int val = obj.scan2.nextInt();
                    boolean found = false;

                    for (int a = 0; a < obj.numbers.length; a++) {
                        if (obj.numbers[a] == val) {
                            found = true;
                        }

                    }

                    if (found) {
                        for (int i = 0; i < obj.numbers.length; i++) {
                            if (obj.numbers[i] == val) {
                                obj.newNumbers = new int[obj.numbers.length - 1];
                                for (int ind = 0; ind < i; ind++) {
                                    obj.newNumbers[ind] = obj.numbers[ind];
                                }
                                for (int j = i; j < obj.numbers.length - 1; j++) {
                                    obj.newNumbers[j] = obj.numbers[j + 1];
                                }

                            }


                        }
                        System.out.println("The value has been deleted");
                        obj.showArray(obj.newNumbers);


                    } else {
                        System.out.println("The value is not in this array");
                    }


                    break;
                case 0:
                    System.exit(0);


            }
        } while (obj.selection != 0);


    }


    public void showArray(int[] array) {

        System.out.println("\nThe array consists of the following elements: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

    }

    public void printExtrema(int[] array) {

        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println("\nThe minimum value is: " + array[minIndex]);

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("\nThe maximum value is: " + array[maxIndex]);

    }

    public void printAverage(int[] array) {
        double sum = 0;
        int count = 0;
        double average;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            count++;
        }

        average = sum / count;
        System.out.println("The average is: " + average);
    }

    public void printNthSmallest(int[] array) {
        System.out.println("Which Nth small value to search? >");
        int n = scan2.nextInt();

        if (n <= array.length) {
            for (int i = 0; i < array.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[min]) {
                        min = j;
                    }

                }
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;

            }

            System.out.println("The " + n + " smallest value is: " + array[n - 1]);
        } else {
            System.out.println("N is out of boundaries");
        }
    }

}
