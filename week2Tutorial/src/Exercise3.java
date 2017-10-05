import java.util.Arrays;

public class Exercise3 {

    public static void main(String[] args) {

        int numbers [] = new int [20];

        numbers[0] = 1;

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i-1] * 2;
        }

        System.out.println(Arrays.toString(numbers));

        double mean[] = new double [20];

        mean[0] = numbers[0];
        mean[19] = numbers[19];

        for (int i = 1; i < 19; i++) {
            mean[i] = (numbers[i-1] + numbers[i+1])/2.0;
        }

        System.out.println((Arrays.toString(mean)));
    }
}
