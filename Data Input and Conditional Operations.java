/*
IDS401 HW1
Liberto, Zuzanna
Seat 15
Completed? Y[x] N[]
 */

import java.util.Scanner;

public class HW1 {

    //define variables
    final Scanner scanner = new Scanner(System.in);
    String name, firstName, lastName, gender, academicStatus, address;
    int seatNumber;

    public static void main(String[] args) {
        //initialize an student
        HW1 student = new HW1();
        //print the initial welcome line
        System.out.println("*** IDS410 Student Data Input ***");

        //method calls
        student.name = student.getName();
        student.gender = student.getGender();
        student.academicStatus = student.getAcademicStatus();
        student.address = student.getAddress();
        student.seatNumber = student.getSeatNumber();

        //confirmation printout of student's inputted info
        System.out.println("*** Student Information ***" + "\n" + "Last Name: " + student.getSubName("last", student.name) + "\n" + "First Name: " + student.getSubName("first", student.name) + "\n" + "Seat Number: " + student.seatNumber + "\n" + "Gender: " + student.gender + "\n" + "Academic Status: " + student.academicStatus + "\n" + "Full Address: " + student.address + "\n" + "City : " + student.addressManipulation("city", student.address) + "\n" + "ZIP Code: " + student.addressManipulation("zip", student.address) + "\n" + "State: " + student.addressManipulation("state", student.address));


    }


    String getName() {
        // This method gets user input, and assigns it to the "name" variable and returns it.
        System.out.println("Type in your name in FirstName LastName format >");
        name = scanner.nextLine();
        return name;

    }

    String getSubName(String type, String name) {
        //This method takes a "type" String, which has two options: first or last.
        //The method returns either first or last name, depending on the "type" argument.

        //find the space
        int space = name.indexOf(" ");


        switch (type) {

            case "first":
                firstName = name.substring(0, space);
                return firstName;

            case "last":
                lastName = name.substring(space + 1);
                return lastName;


            default:
                return ("first");


        }

    }

    int getSeatNumber() {
        //This method gets a student's seat number and assigns it to a variable.
        System.out.println("Type in your seat number >");
        seatNumber = scanner.nextInt();
        return seatNumber;


    }

    String getGender() {
        //This method gets a student's gender and assigns it to a String.
        // This method can only take a specified type of input, which is enforced by a while loop.
        System.out.println("Provide your gender >");
        gender = scanner.nextLine();
        while (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") )) {
            System.out.println("Error. Provide a valid gender >");
            gender = scanner.nextLine();

        }
        char initial = gender.charAt(0);
        String initialString = String.valueOf(initial);
        gender = initialString.toUpperCase();

        return gender;
    }

    String getAcademicStatus() {
        //This method gets a student's academic status and assigns it to a string.
        //This method can only take a specified type of input, which is enforced by a while loop.
        System.out.println("Type in your academic status (Undergraduate/Graduate) >");
        academicStatus = scanner.nextLine();


        while (!(academicStatus.equals("Undergraduate") || academicStatus.equalsIgnoreCase("Graduate") || academicStatus.equalsIgnoreCase("Undergrad") || academicStatus.equalsIgnoreCase("Grad") || academicStatus.equalsIgnoreCase("u") || academicStatus.equalsIgnoreCase("g"))) {
            System.out.println("Error. Type in a valid academic status (Undergraduate/Graduate) >");
            academicStatus = scanner.nextLine();
        }


        char initial = academicStatus.charAt(0);
        String academicStatusInitial = String.valueOf(initial);
        academicStatus = academicStatusInitial.toUpperCase();

        return academicStatus;

    }

    String getAddress() {
        //This method gets a student's address and assigns it to a String.
        System.out.println("Type in your address. For accurate results, please use a period in between your street address and your city, and a comma in between your city and your state. \nExample: 555 Harrison Ave. Chicago, IL 60607 >");
        address = scanner.nextLine();

        return address;
    }

    String addressManipulation(String type, String address) {
        //This method takes a "type" argument which indicates which part of a student's address should be returned, and a student's address.
        //The method returns the indicated part of a student's address.
        int period = address.indexOf(".");
        int comma = address.indexOf(",");
        switch (type) {
            case "address":
                return (address.substring(0, period));
            case "city":
                return (address.substring(period + 2, comma));
            case "state":
                return (address.substring(comma + 2, comma + 5));
            case "zip":
                return (address.substring(comma + 5));
            default:
                return "address";
        }

    }

}
