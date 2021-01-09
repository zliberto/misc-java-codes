import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class M2 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zliberto/eclipse-workspace/M2/grades.txt");
        Scanner scan;
        double average;
        DecimalFormat avgFormat = new DecimalFormat("00.00");
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        int sumA = 0, sumB = 0, sumC = 0, sumD = 0, sumF = 0;

        scan = new Scanner(file);

        int sum = 0;
        int count = 0;
        average = 0;

        while (scan.hasNextInt()) {

            sum += scan.nextInt();
            count++;

            int score = scan.nextInt();

            if (score >= 90) {
                countA++;
                sumA += score;

            }
            if (score >= 80 && score < 90) {
                countB++;
                sumB += score;

            }
            if (score >= 70 && score < 80) {
                countC++;
                sumC += score;
            }
            if (score >= 60 && score < 70) {
                countD++;
                sumD += score;
            }
            if (score < 60) {
                countF++;
                sumF += score;
            }


        }

        if (count != 0) {

            average = (double) sum / count;
        } else System.out.println("Can't divide by 0");

        System.out.println("Average of class: " + avgFormat.format(average));


        System.out.println("Number of A grades: " + countA + " " + "Average of A: " + avgFormat.format((double) sumA / countA) + "\n" + "Number of B grades: " + countB + " " + "Average of B: " + avgFormat.format((double) sumB / countB) + "\n" + "Number of C grades: " + countC + " " + "Average of C: " + avgFormat.format((double) sumC / countC) + "\n" + "Number of D grades: " + countD + " " + "Average of D: " + avgFormat.format((double) sumD / countD) + "\n" + "Number of F grades: " + countF + " " + "Average of F: " + avgFormat.format((double) sumF / countF));


    }


}



