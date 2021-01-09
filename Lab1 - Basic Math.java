import java.util.Scanner;

public class Lab1 {

    Scanner scanner = new Scanner(System.in);
    int number;


    public static void main(String[] args) {
        Lab1 object = new Lab1();
        object.number = object.readInt();
        object.checkInt(object.number);




}
void checkInt (int number) {

        if (number%2==0) {
            System.out.println("The number is even");
        }
        else {
            System.out.println("The number is odd");
        }


}

int readInt () {

    System.out.println("Please type in an integer");
        int number = scanner.nextInt();
        return number;


    }

}
