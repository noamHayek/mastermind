package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosingFrame extends JFrame implements ActionListener {
    static Color [] choose = new Color[4];
    static JButton [] code  = new JButton[4];
    static int index=0;
    static JButton ok = new JButton();
    static JButton clear = new JButton();
    static int chooosing=0;
    static  JLabel label = new JLabel();
    public ChoosingFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);
        ok.setText("continue");
        clear.setText("clear");
        ok.setBackground(Color.white);
        clear.setBackground(Color.white);
        ok.setBounds(385 , 412 ,100,50);
        clear.setBounds(285 , 412 , 100 , 50);
        ok.addActionListener(this);
        clear.addActionListener(this);
        add(clear);
        add(ok);
        int x=170;
        for (int i=0;i<4;i++){
            code[i] = new JButton();
            code[i].setBackground(Color.white);
            code[i].setEnabled(false);
            add(code[i]);
            code[i].setBounds(x , 200 , 30 ,30);
            x+=32;
        }
        if(Homepage.isPlayerVsPlayer==false)
        label.setText("Choose your code");
        label.setBounds(20 , 100 , 200 , 20);
        add(label);
        JLabel colors= new Colors();
        colors.setBounds(100 , 300 , 300 , 30);
        add(colors);
        for(int i=0;i<6;i++){
            Colors.colors[i].addActionListener(this);
        }
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).getBackground() != Color.white && index<4) {
                code[index].setBackground(((JButton) e.getSource()).getBackground());
                choose[index]=((JButton) e.getSource()).getBackground();
                ((JButton) e.getSource()).setEnabled(false);
                index++;
            }else{
                if(e.getSource()==clear){
                    for(int i=0;i<4;i++){
                        code[i].setBackground(Color.white);
                        choose[i]=null;
                    }
                    for(int i=0;i<6;i++){
                        Colors.colors[i].setEnabled(true);
                    }
                    index=0;
                }
                if(e.getSource()==ok){
                    if(index==4) {
                        for(int i=0;i<6;i++){
                            Colors.colors[i].setEnabled(true);
                        }if(Homepage.isComputerVsPlayer){
                            for(int i=0;i<4;i++){
                                Homepage.code1[i]=choose[i];
                            }
                            ComputerVsPlayer.isChoose=true;
                            new ComputerVsPlayer();
                            dispose();
                        } else if (Homepage.isPlayerVsPlayer){
                           if(chooosing==0){
                               for(int i=0;i<4;i++){
                                   Homepage.code1[i]=choose[i];
                               }
                               for(int i=0;i<4;i++){
                                   code[i].setBackground(Color.white);
                                   choose[i]=null;
                                   ChoosingFrame.label.setText("player 2 please choose your code");
                               }
                               index=0;
                               chooosing=1;
                           }else if(chooosing==1){
                               for(int i=0;i<4;i++){
                                   Homepage.code2[i]=choose[i];
                               }
                               index=0;
                               PlayerVsPlayer.p1=new BoardFrame(Homepage.code2);
                               dispose();
                           }
                        }else if(!Homepage.isPlayerVsPlayer){
                            dispose();
                            index=0;
                            new BoardFrame(choose);
                        }
                    }
                }
            }
        }
    }
}
