package CounterMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CounterFrame {
    public static void main(String[] args) {

        //Frame
        JFrame frame = new JFrame("Counter Machine Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);      // Shows the interface in Center of the Computer's Screen

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10)); // padding 4 sides


        //Title Panel
        JPanel p3 = new JPanel();
        p3.setBackground(Color.decode("#FFEBEE"));  // Color by Hexadecimal Code
        JLabel title = new JLabel("Counter Machine");
        title.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        title.setForeground(Color.decode("#32292F"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        p3.add(title);

        //Label and Text Field Panel
        JPanel p1 = new JPanel();
        p1.setBackground(Color.decode("#FFFFFF"));  // Color by Hexadecimal Code
        JLabel counter = new JLabel("Counter");
        counter.setFont(new Font("Cambria", Font.PLAIN, 16));
        JTextField text = new JTextField("0", 15);
        text.setFont(new Font("Cambria", Font.PLAIN, 16));
        text.setEditable(false);
        p1.add(counter);
        p1.add(text);


        //Button Panel
        JPanel p2 = new JPanel();
        p2.setBackground(Color.decode("#B0BEC5"));  // Color by Hexadecimal Code

        //Count Button
        JButton cntBtn = new JButton("Count");
        cntBtn.setBackground(Color.CYAN);
        cntBtn.setOpaque(true);
        cntBtn.setBorderPainted(false);

        //Undo Button
        JButton rvrsBtn = new JButton("Undo");
        rvrsBtn.setBackground(Color.CYAN);
        rvrsBtn.setOpaque(true);
        rvrsBtn.setBorderPainted(false);

        //Reset Button
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBackground(Color.CYAN);
        resetBtn.setOpaque(true);
        resetBtn.setBorderPainted(false);

        p2.add(cntBtn);
        p2.add(rvrsBtn);
        p2.add(resetBtn);

        //Button Text Format
        Font ButtonFont = new Font("Cambria", Font.PLAIN, 14);
        cntBtn.setFont(ButtonFont);
        rvrsBtn.setFont(ButtonFont);
        resetBtn.setFont(ButtonFont);

        // Set mnemonics for buttons
        cntBtn.setMnemonic(KeyEvent.VK_C); // Alt+C
        rvrsBtn.setMnemonic(KeyEvent.VK_U); // Alt+U
        resetBtn.setMnemonic(KeyEvent.VK_R);  // Alt+R

        //Formation
        mainPanel.add(p3);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(p1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(p2);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);


        //Action Listeners
        cntBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(text.getText());
                text.setText(String.valueOf(a + 1));
            }
        });

        rvrsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(text.getText());
                if (a > 0) {
                    text.setText(String.valueOf(a - 1));
                }
            }
        });


        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("0");
            }
        });
    }
}