package exercise4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MouseListener {

    private JFrame frame;
    int coordX;
    int coordY;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseListener window = new MouseListener();
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
    public MouseListener() {
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

        JLabel lblTypeCoords = new JLabel("Type Coords");
        lblTypeCoords.setBounds(157, 244, 142, 16);
        frame.getContentPane().add(lblTypeCoords);

        JButton btnButton = new JButton("Button");
        btnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnButton.setBounds(159, 81, 117, 29);
        btnButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                coordX = e.getX() + btnButton.getX();
                coordY = e.getY() + btnButton.getY();

                btnButton.setBounds(coordX, coordY, 101, 16);

                lblTypeCoords.setText("Button " + coordX + " " + coordY);
            }
        });
        frame.getContentPane().add(btnButton);

        JRadioButton rdbtnRadioButton = new JRadioButton("Radio Button");
        rdbtnRadioButton.setBounds(157, 153, 141, 23);
        rdbtnRadioButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                coordX = e.getX() + rdbtnRadioButton.getX();
                coordY = e.getY() + rdbtnRadioButton.getY();

                rdbtnRadioButton.setBounds(coordX, coordY, 101, 16);

                lblTypeCoords.setText("Radio Button " + coordX + " " + coordY);
            }
        });
        frame.getContentPane().add(rdbtnRadioButton);
    }
}
