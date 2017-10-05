public class Exercise5 {

    public static void main( String [ ] args ) {
        // print the message ”Hello Worlds” 10 times in a row
        for (int counter = 9; counter > -1; counter--) {
            System.out.println("Counter: " + counter);
            }
        whileCounter();
        }

    public static void whileCounter() {
        int counter = 0;
        while (counter < 10) {
            System.out.println("Counter: " + counter);
            counter++;
        }
    }

}
