package exercise1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import exercise1.MyLogger;

public class UseLogger {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private void printPascalTriangle(int numRows) {

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

        // now we demo the logging

        // set the LogLevel to Severe, only severe Messages will be written
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
    }

    public static void main(String[] args) {
        UseLogger tester = new UseLogger();
        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        tester.printPascalTriangle(5);
    }
}