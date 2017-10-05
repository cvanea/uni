import java.util.Scanner;

public class Exercise4 {

    public static void main(String [ ] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine() ;
        if (name.isEmpty() || name.equals(" ")) {
            System.out.println("Fine, don’t tell me your name. Goodbye!");
        } else if (name.length() < 2) {
            System.out.println("Wow! You have a very short name.");
        } else {
            System.out.println("Hello! I thought that your name might be "+ name + "!");
        }
    }
}
