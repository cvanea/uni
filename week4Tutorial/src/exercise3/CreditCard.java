package exercise3;

import java.util.Calendar;

class CreditCard {

    private int expiryMonth;
    private int expiryYear;
    private String firstName;
    private String lastName;
    private String ccNumber;

    CreditCard(int expiryMonth, int expiryYear, String firstName, String
        lastName, String ccNumber) {
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ccNumber = ccNumber;
    }

    String formatExpiryDate() {
        return expiryMonth + "/" + (expiryYear - 2000);
    }

    String formatFullName() {
        return firstName + " " + lastName;
    }

    String formatCCNumber() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ccNumber.length(); i++) {
            if (i % 4 == 0 && i != 0) {
                result.append(" ");
                result.append(ccNumber.charAt(i));
            } else {
                result.append(ccNumber.charAt(i));
            }
        }
        return result.toString();
    }

    boolean isValid() {
        Calendar now = Calendar.getInstance();

        return expiryYear > now.get(Calendar.YEAR)  ||
            expiryYear == now.get(Calendar.YEAR) && expiryMonth > now.get(Calendar.MONTH);
    }

    String cardToString() {
        return "Number: " + formatCCNumber() + "\nExpiry date: " +
            formatExpiryDate() + "\nAccount holder: " + formatFullName() + "\nIs valid: " + isValid();
    }
}
