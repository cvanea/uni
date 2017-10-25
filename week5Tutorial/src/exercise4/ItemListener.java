package exercise4;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ItemListener {

    private JFrame frame;
    String selected;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ItemListener window = new ItemListener();
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
    public ItemListener() {
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

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"One", "Two", "Three", "Four"}));
        comboBox.setBounds(164, 125, 116, 27);
        comboBox.addItemListener(e -> {
            selected = (String)comboBox.getSelectedItem();
            if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(frame, selected);
            }
        });
        frame.getContentPane().add(comboBox);

    }
}
