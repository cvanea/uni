package exercise3;

import javax.swing.*;
import java.util.ArrayList;

public class CurrencyConverter {
    private JPanel p;
//    private JTextField convertAmount = new JTextField();
    private JComboBox currencyList;
    private JComboBox currencyList2;

//    private CurrencyConverter() {
//
////        convertAmount = new JTextField();
//        currencyList = new JComboBox<>(returnCurrencies().toArray());
//        currencyList2 = new JComboBox<>(new String[] {"a", "b"});
//
//    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("CurrencyConverter");
        frame.setContentPane(new CurrencyConverter().p);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private static ArrayList<Currency> returnCurrencies() {
        ArrayList<Currency> currencies = new ArrayList<>();

        Currency GBP = new Currency("GBP", 1.0);
        Currency USD = new Currency("USD", 1.32);
        Currency YEN = new Currency("YEN", 148.91);
        Currency EU = new Currency("EU",1.12);

        currencies.add(GBP);
        currencies.add(USD);
        currencies.add(YEN);
        currencies.add(EU);

        return currencies;
    }

    private void createUIComponents() {
        currencyList = new JComboBox<>(returnCurrencies().toArray());
        currencyList2 = new JComboBox<>(new String[] {"a", "b"});
    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }
}



//    JComboBox currencyList = new JComboBox(currencies.toArray());
