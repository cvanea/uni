import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("What number would you like to check? ");
        System.out.println(isEven(input.nextInt()));
    }

    public static boolean isEven (int number){
        return number % 2 == 0;
    }
}