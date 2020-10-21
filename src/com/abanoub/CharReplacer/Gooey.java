package com.abanoub.CharReplacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gooey {
    JTextArea inputText;
    JTextArea outputText;
    JButton replaceButton;
    JTextArea lib;
    JPanel mainPanel;
    JButton setArrayButton;
    JTextField shiftChars;

    public Gooey() {
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.setReplacementArray();
                String string = Main.replace(inputText.getText(), shiftChars.getText());
                outputText.setText(string);
            }
        });
        setArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.setReplacementArray();
            }
        });
    }
    void run() {
        JFrame frame = new JFrame("Char Rep 2.31");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getLib() {
        return lib.getText();
    }
}
