package exercise3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrencyConverter {

    private JFrame frame;
    private JTextField textField;
    String amount;
    Currency currencyFrom;
    Currency currencyTo;

    Currency GBP = new Currency("GBP", 1.0);
    Currency USD = new Currency("USD", 1.32);
    Currency YEN = new Currency("YEN", 148.91);
    Currency EU = new Currency("EU", 1.12);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurrencyConverter window = new CurrencyConverter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CurrencyConverter() {
        initialize();
    }

    /**
     * Initialise the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCurrencyConverter = new JLabel("Currency Converter");
        lblCurrencyConverter.setBounds(163, 6, 121, 16);
        frame.getContentPane().add(lblCurrencyConverter);

        JLabel lblAmount = new JLabel("Amount to convert:");
        lblAmount.setBounds(42, 87, 122, 16);
        frame.getContentPane().add(lblAmount);

        textField = new JTextField();
        textField.setBounds(176, 82, 130, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JComboBox comboBox = new JComboBox(returnCurrencyName(returnCurrencies(GBP, USD, YEN, EU)));
        comboBox.setToolTipText("");
        comboBox.setBounds(318, 83, 75, 27);
        frame.getContentPane().add(comboBox);

        JLabel lblCurrencyConvertngTo = new JLabel("Currency converting to:");
        lblCurrencyConvertngTo.setBounds(42, 139, 162, 26);
        frame.getContentPane().add(lblCurrencyConvertngTo);

        JComboBox comboBox_1 = new JComboBox(returnCurrencyName(returnCurrencies(GBP, USD, YEN, EU)));
        comboBox_1.setBounds(216, 140, 75, 27);
        frame.getContentPane().add(comboBox_1);

        JButton btnConvert = new JButton("Convert");
        btnConvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amount = textField.getText();
                String currencyFromString = (String) comboBox.getSelectedItem();
                String currencyToString = (String) comboBox_1.getSelectedItem();

                switch (currencyFromString) {
                    case "GBP":
                        currencyFrom = GBP;
                        break;
                    case "USD":
                        currencyFrom = USD;
                        break;
                    case "YEN":
                        currencyFrom = YEN;
                        break;
                    case "EU":
                        currencyFrom = EU;
                        break;
                }

                switch (currencyToString) {
                    case "GBP":
                        currencyTo = GBP;
                        break;
                    case "USD":
                        currencyTo = USD;
                        break;
                    case "YEN":
                        currencyTo = YEN;
                        break;
                    case "EU":
                        currencyTo = EU;
                        break;
                }

                try {
                    Writer.write(converter(currencyTo, currencyFrom, amount));
                } catch (NumberFormatException e1) {
                    System.out.println("No user input");
                } catch (Throwable e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnConvert.setBounds(167, 214, 117, 29);
        frame.getContentPane().add(btnConvert);
    }

    private static ArrayList<Currency> returnCurrencies(Currency GBP, Currency USD, Currency YEN, Currency EU) {
        ArrayList<Currency> currencies = new ArrayList<>();

        currencies.add(GBP);
        currencies.add(USD);
        currencies.add(YEN);
        currencies.add(EU);

        return currencies;
    }

    private static String[] returnCurrencyName(ArrayList<Currency> currencies) {
        String[] result = new String[4];

        int count = 0;
        for (Currency i : currencies) {
            result[count] = i.getName();
            count++;
        }
        return result;
    }

    private static Double converter(Currency currencyTo, Currency currencyFrom, String amount) {
        Double GBP = Double.parseDouble(amount) / currencyFrom.getRate();

        return GBP * currencyTo.getRate();
    }
}
