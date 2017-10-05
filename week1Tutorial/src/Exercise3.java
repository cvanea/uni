import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your first name?");

        // Save user's input in a String variable called 'name'.
        String fname = scanner.nextLine();

        System.out.println("What is your second name?");

        String sname = scanner.nextLine();

        // Print welcome message on screen including the saved input
        System.out.println("Hello! I thought your name might be " + fname + " " + sname + "!");

    }
}
