import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;

public class Exercise4 {

    public static void main(String[] args) {

        Vector<Double> sortReal = new Vector<>();

        Scanner input = new Scanner(System.in);

        System.out.println("What are your real numbers? Please separate numbers by a space and input 0 to exit");


        ArrayList<String> numbers2 = new ArrayList<>();

        while (input.hasNext() && !input.hasNext("0") && numbers2.size() < 50) {
                numbers2.add(input.next());
        }

        for (String number : numbers2) {
            sortReal.add(Double.valueOf(number));
        }

        Collections.sort(sortReal);

        System.out.println(numbers2);
        System.out.println(numbers2.size());
        System.out.println(sortReal);
    }
}
