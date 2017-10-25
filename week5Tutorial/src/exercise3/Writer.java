package exercise3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

class Writer {

    static void write(Double conversionOutput) throws IOException {

        try {
            FileWriter writer = new FileWriter("output.txt", true);

            writer.write("[" + conversionOutput.toString() + "] ");

            writer.close();

        } catch (NoSuchFileException e) {
            FileWriter writer = new FileWriter("output.txt");

            writer.write("[" + conversionOutput.toString() + "] ");

            writer.close();
        } catch (NumberFormatException e) {
            System.out.println("No user input");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}