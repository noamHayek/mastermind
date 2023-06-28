package com.company;

import javax.swing.*;
import java.awt.*;

public class OkAndClear extends JPanel {
    static JButton ok = new JButton();
    static JButton clear = new JButton();
    public OkAndClear(){
        setBounds(0 , 600 , 150 , 50);
        ok.setText("ok");
        ok.setBackground(Color.white);
        clear.setBackground(Color.white);
        clear.setText("clear");
        ok.setSize(75 ,50);
        clear.setSize(75 , 50);
        add(ok);
        add(clear);
        setLayout(new GridLayout(1,2));
    }
}
