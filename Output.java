/*
Liberto, Zuzanna
 */

import java.sql.SQLOutput;
import java.util.Scanner;

public class HW1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*** IDS410 Student Data Input ***");
        System.out.println("Type in your name in FirstName LastName format >");
        String name = new String(scanner.nextLine());

        int space = name.indexOf(" ");
        String firstName = new String(name.substring(0,space));
        String lastName = new String(name.substring(0,space));

        System.out.println("Type in your seat number >");
        int seatNumber = scanner.nextInt();

        System.out.println("Provide your gender >");
        String gender = new String(scanner.nextLine());

        System.out.println("Type in your academic status (Undergraduate/Graduate) >");
        String academicStatus = new String(scanner.nextLine());

        System.out.println("Type in your address >");
        String address = new String(scanner.nextLine());


        System.out.println("*** Student Information ***" + "\n" + "Last Name: " + lastName + "\t" + "First Name: " + firstName + "\n" + "Seat Number: " + seatNumber + "\n" + "Gender: " + gender + "\n" + "Academic Status: " + academicStatus + "\n" + "Address: " + address );


    }
}
