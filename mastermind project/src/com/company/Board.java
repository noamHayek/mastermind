package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JPanel {
    static JButton[][] buttons = new JButton[8][4];

    public Board() {
        setBounds(150, 0, 600, 600);
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 4; c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setSize(15, 15);
                buttons[r][c].setEnabled(false);
                buttons[r][c].setBackground(Color.white);
                buttons[r][c].repaint();
                add(buttons[r][c]);
            }
        }
        setLayout(new GridLayout(8, 4, 0, 10));
    }

}
