package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Homepage extends JFrame implements ActionListener{
    JButton player = new JButton();
    JButton twoPlayers = new JButton();
    static Color[] code1 = new Color[4];
    static Color [] code2 = new Color[4];
    static boolean isPlayerVsPlayer;
    static boolean isComputerVsPlayer;
    public Homepage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isPlayerVsPlayer=false;
        isComputerVsPlayer=false;
        setSize(500,500);
        twoPlayers.setText("two players");
        player.setText("one player");
        JLabel title = new JLabel();
        title.setText("master mind");
        title.setBounds(225 , 100 , 100 , 50);
        twoPlayers.setBounds(150 ,  200  , 200 , 50);
        player.setBounds(150 , 300 , 200  ,50);
        add(title);
        add(twoPlayers);
        add(player);
        setLayout(null);
        setVisible(true);
        player.addActionListener(this);
        twoPlayers.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==player){
            dispose();
            new WhoChooseFrame();
        }
        if(e.getSource()==twoPlayers){
            new WhoWillPlay();
            dispose();
        }
    }
}
