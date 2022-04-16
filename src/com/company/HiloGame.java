package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiloGame {
    private JTextField input;
    private JButton OKButton;
    private JButton exitButton;
    private JPanel window;
    private JLabel title;
    private JLabel text;

    private int answer;
    private boolean guess = true;

    public HiloGame() {
        answer = (int)(Math.random() * 100);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!guess) {
                    text.setText("Guess a number from 1 to 100");
                    answer = (int)(Math.random() * 100);
                    guess = true;
                    input.setText("");
                } else {
                    int user;
                    String input_text = input.getText().toString();
                    user = Integer.parseInt(input_text);
                    if (user < answer) {
                        text.setText("To small!");
                    } else if (user > answer) {
                        text.setText("To big!");
                    } else {
                        text.setText("You are right! Let's play again. ");
                        guess = false;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HiloGame");
        frame.setContentPane(new HiloGame().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(250, 250);
        frame.setResizable(false);
    }
}
