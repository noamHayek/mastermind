package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhoWillPlay extends JFrame implements ActionListener {
    JButton pvp = new JButton();
    JButton pvc = new JButton();
    public WhoWillPlay(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        pvc.setText("you Vs computer");
        pvp.setText("playe Vs player");
        pvc.setBounds(150 ,  200  , 200 , 50);
        pvp.setBounds(150 , 300 , 200  ,50);
        add(pvp);
        add(pvc);
        setLayout(null);
        setVisible(true);
        pvp.addActionListener(this);
        pvc.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pvp){
            dispose();
            Homepage.isPlayerVsPlayer=true;
            ChoosingFrame.label.setText("player 1 please choose your code");
            new ChoosingFrame();
        }else{
            Homepage.isComputerVsPlayer=true;
            new ComputerVsPlayer();
            dispose();
        }
    }
}
