import java.util.Scanner;

public class Formula {
public static void main (String[]args) {
    double celcius;

    Scanner in = new Scanner(System.in);
    System.out.println("Type in now");
    celcius = in.nextDouble();
    System.out.println( "Temp is " + (celcius * (9.0/5.0) + 32.0));

}

}
