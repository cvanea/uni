import java.util.Arrays;

public class Exercise2 {

    public static void main(String[] args) {

        String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ",
            "over ", "the ", "lazy ", "dog."};

        String[] newArr = remIndex(arr, 7);
        System.out.println(Arrays.toString(newArr));
    }

    public static String[] remIndex(String[] array, int index) {

        String[] newArray = new String[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else if (i > index) {
                newArray[i - 1] = array[i];
            }
        }

        return newArray;
    }

}
