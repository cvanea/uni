import java.util.*;

public class Exercise3 {

    public static void main(String[] args) {

        ArrayList<Integer> aList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            Integer n = rand.nextInt(100);
            aList.add(n);
        }

        System.out.println(aList);

        Integer sum = 0;

        for (Integer i: aList) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);

        ArrayList<Integer> appendList = new ArrayList<>();

        for (Iterator<Integer> i = aList.iterator(); i.hasNext();) {
            Integer integer = i.next();
            if (integer % 2 == 1) {
                appendList.add(integer);
                i.remove();
            }
        }

        aList.addAll(appendList);
        System.out.println(aList);


        Integer[] newArray = aList.toArray(new Integer[aList.size()]);

        System.out.println(Arrays.toString(newArray));
    }

}
