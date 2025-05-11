package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

class Calculator {
    JFrame frame;
    JTextField textField;
    JLabel title;

    JPanel panel, mainPanel, buttonPanel;
    JButton[] digitButtons = new JButton[10];
    JButton plus, minus, multiplication, division, equal, reset;

    Font buttonFont = new Font("Cambria", Font.PLAIN, 30);

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(380, 450); // Increased width
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setFont(new Font("Cambria", Font.PLAIN, 30));
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setMargin(new Insets(20, 10, 20, 10)); // Vertically center
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(350, 85)); // Increased width

        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        title = new JLabel("Basic Calculator");
        title.setFont(new Font("Cambria", Font.PLAIN, 15));
        title.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);
        panel.add(title);
        panel.add(textField);

        // Operator Buttons
        plus = new JButton("+");
        minus = new JButton("-");
        multiplication = new JButton("×");
        division = new JButton("÷");
        equal = new JButton("=");
        reset = new JButton("AC");

        plus.setBackground(Color.CYAN);
        minus.setBackground(Color.CYAN);
        multiplication.setBackground(Color.CYAN);
        division.setBackground(Color.CYAN);
        reset.setBackground(Color.decode("#B47EE5"));
        equal.setBackground(Color.ORANGE);
        reset.setForeground(Color.WHITE);


        // Apply font to Operator Buttons
        JButton[] ops = {plus, minus, multiplication, division, equal, reset};
        for (JButton btn : ops) {
            btn.setFont(buttonFont);
        }

        // Initialize digit buttons and apply font
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].setFont(buttonFont);
            digitButtons[i].setBackground(Color.PINK);
            int finalI = i;
            digitButtons[i].addActionListener(e -> {
                String prevText = textField.getText();
                textField.setText(prevText + finalI);
            });
        }

        // Operator button actions
        plus.addActionListener(e -> textField.setText(textField.getText() + "+"));
        minus.addActionListener(e -> textField.setText(textField.getText() + "-"));
        multiplication.addActionListener(e -> textField.setText(textField.getText() + "×"));
        division.addActionListener(e -> textField.setText(textField.getText() + "÷"));

        reset.addActionListener(e -> textField.setText(""));

        equal.addActionListener(e -> {
            try {
                String expression = textField.getText();
                expression = expression.replace("×", "*").replace("÷", "/");
                double result = 0;

                if (expression.contains("+")) {
                    String[] parts = expression.split("\\+");
                    result = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
                } else if (expression.contains("-")) {
                    String[] parts = expression.split("\\-");
                    result = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
                } else if (expression.contains("*")) {
                    String[] parts = expression.split("\\*");
                    result = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
                } else if (expression.contains("/")) {
                    String[] parts = expression.split("/");
                    double denominator = Double.parseDouble(parts[1]);
                    if (denominator == 0) {
                        textField.setText("Error: Divide by 0");
                        return;
                    }
                    result = Double.parseDouble(parts[0]) / denominator;
                } else {
                    textField.setText("Invalid");
                    return;
                }

                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        });

        // Layout Setup
        buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setPreferredSize(new Dimension(350, 200)); // Increased width
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(plus);

        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(minus);

        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(multiplication);

        buttonPanel.add(reset);
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(equal);
        buttonPanel.add(division);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.BLACK);
        mainPanel.add(panel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}

public class CalculatorExample {
    public static void main(String[] args) {
        new Calculator();
    }
}
