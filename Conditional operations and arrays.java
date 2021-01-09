//Zuzanna Liberto
// 10.13.2018

import java.util.Scanner;
import java.util.Arrays;

public class Module3 {

    Scanner reader = new Scanner(System.in);
    int data[] = new int[0];

    public static void main(String[] args) {

        Module3 object = new Module3();

        System.out.println("Staring application");

        object.getCommand();

    }

    public void getCommand() {

        while (true) {
            System.out.println("\nEnter one of the following commands: input, display, filter, resize or exit");
            String command = reader.next();

           switch (command) {
               case "input":
                    data = getInput(data);
                    break;
               case "display":
                    displayContents(data);
                    break;
                case "filter":
                    data = removeEvens(data);
                    break;
                case "resize":
                    data = resize(data);
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }

        int[] getInput (int[] initialArray){

            System.out.println("Enter an integer");
            int value = reader.nextInt();
            int newArray[] = new int[initialArray.length + 1];
            newArray = Arrays.copyOf(initialArray, initialArray.length + 1);
            newArray[((newArray.length) - 1)] = value;
            displayContents(newArray);
            return newArray;
        }


        void displayContents (int[] initialArray){

            for (int i = 0; i < initialArray.length; i++) {
                System.out.print(initialArray[i]+",");
            }
        }


        int[] removeEvens (int[] initialArray){

            int oddCount = 0;

            for (int i = 0; i < initialArray.length; i++) {
                if (initialArray[i] % 2 == 1) {
                    oddCount++;
                }
            }
            int newArray[] = new int[oddCount];
            newArray = Arrays.stream(initialArray).filter(x -> x % 2 != 0).toArray();
            displayContents(newArray);
            return newArray;
        }

        int[] resize (int[] initialArray){

            System.out.println("Enter an integer");
            int size = reader.nextInt();
            int[] newArray = new int[size];
            newArray = Arrays.copyOf(initialArray, size);
            displayContents(newArray);
            return newArray;
        }

    }
