package com.company;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.*;


public class PlayerVsPlayer {
    static int turn=1 , p1Index , p2Index , p1Row , p2Row;
    static BoardFrame p1;
    static BoardFrame p2;
    static Color [][] player1Result = new Color[8][];
    static Color [][] player2Result = new Color[8][];
    static Color [] [] player1Board = new Color[8][4] ;
    static Color [] [] player2Board = new Color [8][4];
    static Color [] tsofen = new Color[4];
    static boolean isOk = false;
    // מחליף בן שחקן לשחקן
    public static void switchingFrame(){
        if(p2Row==-1){
            p1.dispose();
            p2.dispose();
            WinFrame.massage.setText("draw");
            new WinFrame();
            return;
        }
        turn++;
        if(turn%2==0){
            if(turn==2){
                 new Ai();
                p1.dispose();
                p2=new BoardFrame(Homepage.code1);
            }else{//p1->p2
                p1.dispose();
                    p2=new BoardFrame(Homepage.code1 , player2Board , player2Result , p2Index , p2Row );
            }
        }else{//p2->p1
            p2.dispose();
            p1=new BoardFrame(Homepage.code2 , player1Board , player1Result , p1Index , p1Row);
        }
    }
}

