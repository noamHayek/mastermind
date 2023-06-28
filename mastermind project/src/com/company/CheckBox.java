package com.company;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JPanel {
    static JButton result [] = new JButton[4];
    public CheckBox(){
        setSize(50 , 50);
        for(int i=0;i<4;i++){
            result[i]=new JButton();
            result[i].setSize(5,5);
            result[i].setEnabled(false);
            add(result[i]);
        }
        setLayout(new GridLayout(2,2 ,0,0));
    }
}
