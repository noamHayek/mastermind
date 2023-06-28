package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhoChooseFrame extends JFrame implements ActionListener {
    static int isComputer  ;
    JButton computer = new JButton();
    JButton player = new JButton();
    static BoardFrame frame;
    public WhoChooseFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setSize(400 , 400);
        JLabel label = new JLabel();
        label.setBounds( 100,125 ,300 , 50);
        label.setText("who do you want to choose the code");
        add(label);
        computer.setText("computer");
        player.setText("player");
        computer.setBounds(50,200 , 150 , 50);
        player.setBounds(201 , 200 , 150 , 50);
        add(computer);
        add(player);
        player.addActionListener(this);
        computer.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==player){
            isComputer=0;
            setVisible(false);
            new ChoosingFrame();
        }
        if(e.getSource()==computer){
            isComputer=1;
            setVisible(false);
            ComputerChoose.cChoose();
        }
    }
}
