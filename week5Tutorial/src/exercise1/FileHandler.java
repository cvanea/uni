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
            stringBuilder.append("The number of lines in ").append(i).append(": ").append(fileReader(i)).append("\n");
        }

        System.out.println(stringBuilder.toString());

    }

    private static int fileReader(String filename) {

        String line;

        try {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                count++;
            }

            bufferedReader.close();

            return count;

        } catch (FileNotFoundException e) {
            System.out.println(filename + " does not exist.");
            return 0;
        } catch (IOException e) {
            System.out.println("Error");
            return 0;
        }

    }
//
//    private static int lineCounter(String filename) {
//
//    }

}