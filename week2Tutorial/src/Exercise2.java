import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Simple calculator. Please choose an operation:");
        System.out.println();
        System.out.println("1. Add");
        System.out.println();
        System.out.println("2. Subtract");
        System.out.println();
        System.out.println("3. Multiply");
        System.out.println();
        System.out.println("4. Divide");
        System.out.println();
        System.out.println("5. Factorial");
        System.out.println();
        System.out.println("6. Exit ");

        int operation = console.nextInt();

        if (operation < 5 && operation > 0) {
            System.out.print("Please enter your first number: ");

            int a = console.nextInt();

            System.out.print("Please enter your second number: ");

            int b = console.nextInt();

            switch (operation) {
                case 1:
                    System.out.println(add(a, b));
                    break;
                case 2:
                    System.out.println(subtract(a, b));
                    break;
                case 3:
                    System.out.println(multiply(a, b));
                    break;
                case 4:
                    System.out.println(divide(a, b));
                    break;
            }
        } else if (operation == 5) {
            System.out.print("Please enter your number: ");

            int a = console.nextInt();

            System.out.println(factorial(a));
        } else if (operation == 6) {
            System.exit(0);
        } else {
            System.out.println("That is not a valid input!");
        }

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static int factorial(int a) {
        if (a == 0) {
            return 1;
        } else return a * factorial(a -1);
    }

}
