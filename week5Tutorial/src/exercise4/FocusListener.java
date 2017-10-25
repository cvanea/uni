package exercise4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FocusListener {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FocusListener window = new FocusListener();
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
    public FocusListener() {
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

        JLabel lblUpdate = new JLabel("");
        lblUpdate.setBounds(169, 220, 117, 16);
        frame.getContentPane().add(lblUpdate);

        JButton btnClickMe = new JButton("Click me! 1");
        btnClickMe.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                lblUpdate.setText("Button 1!");
            }
        });
        btnClickMe.setBounds(169, 105, 117, 29);
        frame.getContentPane().add(btnClickMe);
        
        JButton btnClickMe_1 = new JButton("Click me! 2");
        btnClickMe_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                lblUpdate.setText("Button 2!");
            }
        });
        btnClickMe_1.setBounds(169, 156, 117, 29);
        frame.getContentPane().add(btnClickMe_1);
    }
}
