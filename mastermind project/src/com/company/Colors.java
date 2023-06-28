package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Colors extends JLabel {
    public static JButton colors [] = new JButton[6];
    public Colors(){
        setBounds(150 , 600 , 600 , 50);
        for(int i=0;i<6;i++){
            colors[i]=new JButton();
            colors[i].setSize(15,15);

            add(colors[i]);
        }
        colors[0].setBackground(Color.RED);
        colors[1].setBackground(Color.GREEN);
        colors[2].setBackground(Color.BLACK);
        colors[3].setBackground(Color.YELLOW);
        colors[4].setBackground(Color.BLUE);
        colors[5].setBackground(Color.CYAN);
        setLayout(new GridLayout(1,6,0,0));
    }
}
