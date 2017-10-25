package exercise4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener {

    private JFrame frame;
    private JTextField textField;
    char charInput;
    String input;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KeyListener window = new KeyListener();
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
    public KeyListener() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUpdates = new JLabel("");
        lblUpdates.setBounds(6, 91, 438, 16);
        frame.getContentPane().add(lblUpdates);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                charInput = e.getKeyChar();
                input = String.valueOf(charInput);
                lblUpdates.setText(lblUpdates.getText() + input);
            }
        });
        textField.setBounds(16, 119, 428, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }
}
