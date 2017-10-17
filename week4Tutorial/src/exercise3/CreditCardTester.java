package exercise3;

public class CreditCardTester {

    public static void main(String[] args) {

        CreditCard cc1 = new CreditCard(
            10, 2014, "Bob", "Jones", "1234567890123456");

        CreditCard cc2 = new CreditCard(
            12, 2018, "Sally", "Smith", "9283742987492459");

        System.out.println(cc1.cardToString());
        System.out.println();
        System.out.println(cc1.isValid());
        System.out.println(cc1.formatCCNumber());
        System.out.println(cc1.formatExpiryDate());
        System.out.println(cc1.formatFullName());
        System.out.println();

        System.out.println(cc2.cardToString());
        System.out.println();
        System.out.println(cc2.isValid());
        System.out.println(cc2.formatCCNumber());
        System.out.println(cc2.formatExpiryDate());
        System.out.println(cc2.formatFullName());
        System.out.println();

    }
}
