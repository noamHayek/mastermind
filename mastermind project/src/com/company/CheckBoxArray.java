package com.company;

import javax.swing.*;
import java.awt.*;

public class CheckBoxArray extends JLabel {
    static JLabel labels [] = new JLabel[8];
    public CheckBoxArray(){
        for(int i=0;i<8;i++){
            labels[i]=new JLabel();
            labels[i].add(new CheckBox());
            add(labels[i]);
        }
        setBounds(50 , 10 , 200 , 600);
        setLayout(new GridLayout(8,0,10,0));
    }
}
