import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Exercise4 {

    public static void main(String[] args) {

        Vector<Double> sortReal = new Vector<>();

        Scanner input = new Scanner(System.in);

        System.out.println("What are your real numbers? Please separate by ','");

        String[] numbers = input.nextLine().split(", ");

        for (String number : numbers) {
            sortReal.add(Double.valueOf(number));
        }

        Collections.sort(sortReal);

        System.out.println(sortReal);
    }
}
