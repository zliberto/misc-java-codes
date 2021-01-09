//Zuzanna Liberto
//09/12/2018

public class Module1 {
    int intField;
    double doubleField;

    public static void main(String[] args) {

        Module1 module1 = new Module1();


        module1.intField = 6;
        module1.doubleField = 4.0;


        System.out.println("New object created and initialized");


        int a = module1.intSquare(module1.intField);
        System.out.println(a);

        double b = module1.doubleSquare(module1.doubleField);
        System.out.println(b);

        int c = module1.intCube(module1.intField);
        System.out.println(c);

        double d = module1.doubleCube(module1.doubleField);
        System.out.println(d);


        System.out.println("Computations Completed");

    }


    int intSquare(int x) {
        return (int) Math.pow(x, 2);
    }

    double doubleSquare(double x) {
        return Math.pow(x, 2);
    }

    int intCube(int x) {
        return (int) Math.pow(x, 3);
    }

    double doubleCube(double x) {
        return Math.pow(x, 3);
    }

}

