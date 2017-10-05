import java.lang.Math;
import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {

        final String[] UNITS = {"B", "KB", "MB", "GB"};

        Scanner input = new Scanner(System.in);

        System.out.print("What is your initial value? ");

        double b = input.nextDouble();
        String measure = input.next();

        System.out.print("What would you like to convert to? (B/KB/MB/GB) ");

        String convertTo = input.next();

        switch (measure) {
            case "B":
            switch (convertTo) {
                case "B":
                System.out.println(b + " " + UNITS[0]);
                break;
                case "KB":
                System.out.println(convert1(b) + UNITS[1]);
                break;
                case "MB":
                System.out.println(convert2(b) + UNITS[2]);
                break;
                default:
                System.out.println(convert3(b) + UNITS[3]);
                break;
            }
            break;
            case "KB":
            switch (convertTo) {
                case "B":
                System.out.println(convert01(b) + UNITS[0]);
                break;
                case "KB":
                System.out.println(b + " " + UNITS[1]);
                break;
                case "MB":
                System.out.println(convert1(b) + UNITS[2]);
                break;
                default:
                System.out.println(convert2(b) + UNITS[3]);
                break;
            }
            break;
            case "MB":
            switch (convertTo) {
                case "B":
                System.out.println(convert02(b) + UNITS[0]);
                break;
                case "KB":
                System.out.println(convert01(b) + UNITS[1]);
                break;
                case "MB":
                System.out.println(b + " " + UNITS[2]);
                break;
                default:
                System.out.println(convert1(b) + UNITS[3]);
                break;
            }
            break;
            case "GB":
            switch (convertTo) {
                case "B":
                System.out.println(convert03(b) + UNITS[0]);
                break;
                case "KB":
                System.out.println(convert02(b) + UNITS[1]);
                break;
                case "MB":
                System.out.println(convert01(b) + UNITS[2]);
                break;
                default:
                System.out.println(b + " " + UNITS[3]);
                break;
            }
            break;
        }
    }

    public static String convert1(double x) {
        return (x*Math.pow(2, -10) + " ");
    }

    public static String convert2(double x) {
        return x*Math.pow(2, -20) + " ";
    }

    public static String convert3(double x) {
        return x*Math.pow(2, -30) + " ";
    }

    public static String convert01(double x) {
        return x*Math.pow(2, 10) + " ";
    }

    public static String convert02(double x) {
        return x*Math.pow(2, 20) + " ";
    }

    public static String convert03(double x) {
        return x*Math.pow(2, 30) + " ";
    }
}