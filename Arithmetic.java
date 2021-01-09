
// Zuzanna Liberto
// 09/11/2018

import java.util.*;

public class Module1  {
    static int intField;
    static double doubleField;

    public static void main (String[] args) {

        Module1 module1 = new Module1();
        
        intField = 6;
        doubleField = 4.0;

        System.out.println("New object created and initialized");

        int z = intSquare(intField);
         System.out.println(z);

        double b = doubleSquare(doubleField);
         System.out.println(b);

        int c = intCube(intField);
        System.out.println(c);

        double v = doubleCube(doubleField);
        System.out.println (v);

        System.out.println("Computations Completed");}

    public static int intSquare (int x)  {
        return (int) Math.pow(x,2) ;}

    public static double doubleSquare (double x)  {
        return Math.pow(x,2);}

    public static int intCube (int x)  {
        return (int) Math.pow( x, 3);}

    public static double doubleCube (double x)  {
        return Math.pow(x ,3);}

}




