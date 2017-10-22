package exercise1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

class FileHandler {

    static void fileHandler() {

        Scanner input = new Scanner(System.in);

        System.out.println("Which files would you like? Please separate files by a space");

        String[] arrInput = input.nextLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (String i : arrInput) {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                long lineCount = bufferedReader.lines().count();
                bufferedReader.close();

                stringBuilder.append("The number of lines in ").append(i).append(": ").append(lineCount).append("\n");
            } catch (FileNotFoundException e) {
                System.out.println(i + " does not exist.\n");
            } catch (IOException e) {
                System.out.println("Error with " + i + "\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}