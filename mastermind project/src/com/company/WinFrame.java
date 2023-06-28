package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WinFrame extends JFrame {
    static JLabel massage = new JLabel();
    public WinFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize( 500 , 500);
        setLayout(null);
        massage.setBounds(60 , 100 , 350 ,200 );
        add(massage);
        if(!Homepage.isPlayerVsPlayer && !Homepage.isComputerVsPlayer) {
            JLabel label = new JLabel();
            label.setText("the code is:");
            label.setBounds(150 , 300 , 125 , 75);
            add(label);
            JButton[] cTsofen = new JButton[4];
            setBackground(Color.white);
            int x = 220;
            for (int i = 0; i < 4; i++) {
                cTsofen[i] = new JButton();
                cTsofen[i].setEnabled(false);
                cTsofen[i].setBackground(BoardFrame.computerTsofen[i]);
                cTsofen[i].setBounds(x, 330, 15, 15);
                x += 20;
                add(cTsofen[i]);
            }
        }
        setVisible(true);
    }
}
