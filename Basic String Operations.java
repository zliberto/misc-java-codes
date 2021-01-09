//Zuzanna Liberto
//09/27/2018

import java.util.Scanner;

public class Module2 {

    Scanner reader = new Scanner(System.in);
    String inputA;
    String inputB;
    String command;

    public Module2() {
        inputA="";
        inputB="";
        command="";

    }
    
    public static void main(String[] args) {

        Module2 object = new Module2();

        System.out.println("Starting application");

        object.inputA = object.getInputString();
        object.inputB = object.getInputString();
        object.command = object.getCommand(object.inputA, object.inputB);
        System.out.println(object.command);

        System.out.println("Ending application");

    }

    String getInputString() {

        System.out.println("Please enter a word");

        String word = reader.nextLine();

        System.out.println("Thank you");

        return word;

    }

    String getCommand(String word1, String word2) {

        System.out.println("Please enter a command");
        String result = reader.nextLine();

        switch (result){
            case "concat":
                return (word1+word2);

            case "firsts":
                return word1.valueOf(word1.charAt(0)) + word2.valueOf(word2.charAt(0));

            case "lasts":
                return word1.valueOf(word1.charAt(word1.length() - 1) + word2.valueOf(word2.charAt(word2.length() - 1)));

            default: return "Invalid command";
        }
    }
}
