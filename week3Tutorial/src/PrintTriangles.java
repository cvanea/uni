import java.util.ArrayList;
import java.util.Scanner;

public class PrintTriangles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many rows would you like for your triangle?");

        printPascalTriangle(input.nextInt());

    }

    private static void printPascalTriangle(int numRows) {

    ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            triangle.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle.get(i).add(1);
                } else if (j == i) {
                    triangle.get(i).add(1);
                } else {
                    triangle.get(i).add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = triangle.size(); j >= i; j--) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(triangle.get(i)).append("\n");
        }

        String finalTriangle = stringBuilder.toString().replace(",", "")
            .replace("[","").replace("]", "");

        System.out.println(finalTriangle);

    }

}
