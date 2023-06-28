package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameLogic {
    static int flagCount=0;
    static int blackFlagCount=0;
    static boolean isWon = false;
    static boolean isFinished = false;
    //פעולה הבודקת אם הקוד תקין
    public static boolean checkValid (int row, JButton[][] array){
        for(int i=0;i<4;i++){
            if(array[row][i].getBackground()== Color.white)
                return false;
        }
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        colors.add(Color.BLACK);
        colors.add(Color.CYAN);
        for(int i=0;i<4;i++){
            colors.remove(array[row][i].getBackground());
        }
        if(colors.size()>2){
            return false;
        }
        return true;
    }
    //פעולה הבודקת את הפידבק הרצוי
    public static void getResult (Color [] computer , Color [] player , int index , int position){
        Color tsofen []= new Color[4];
        Color code [] = new Color[4];
        for(int i=0;i<4;i++){
            tsofen[i]=computer[i];
            code[i]=player[i];
        }
        int blacks=0;
        blackFlagCount=0;
        flagCount=0;
        for(int i=0;i<4;i++){
            if(computer!=null)
                if(computer[i].equals(player[i])){
                    flagCount++;
                    blackFlagCount++;
                    ((JPanel) CheckBoxArray.labels[index].getComponent(0)).getComponent(position).setBackground(Color.BLACK);
                    computer[i]=null;
                    player[i]=null;
                    position++;
                    blacks++;
                }
        }
        if(blacks==4 && Homepage.isComputerVsPlayer && !ComputerVsPlayer.playerTurn){
            ComputerVsPlayer.computerSolve=true;
        }
        if(blacks==4 && !Homepage.isComputerVsPlayer){
            if(Homepage.isPlayerVsPlayer){
                if(PlayerVsPlayer.turn%2==0){
                    if(isWon)
                        WinFrame.massage.setText("draw");
                    else
                    WinFrame.massage.setText("player 2 is the winner");
                    PlayerVsPlayer.p1.dispose();
                    PlayerVsPlayer.p2.dispose();
                    isFinished=true;
                    new WinFrame();
                }else{
                    isWon=true;
                }
            }else {
                WinFrame.massage.setText("good job you manage to solve the code");
                new WinFrame();
            }
            return;
        }else if(isWon){
            WinFrame.massage.setText("player 1 is the winner");
            PlayerVsPlayer.p1.dispose();
            PlayerVsPlayer.p2.dispose();
            isFinished=true;
            new WinFrame();
        }
        for(int i=0;i<4;i++){
            if(player[i]!=null)
                for(int j=0;j<4;j++){
                    if(player[i].equals(computer[j])) {
                        flagCount++;
                        computer[j]=null;
                        ((JPanel) CheckBoxArray.labels[index].getComponent(0)).getComponent(position).setBackground(Color.white);
                        position++;
                        break;
                    }
                }
        }
        for(int i=0;i<4;i++){
            computer[i]=tsofen[i];
            player[i]=code[i];
        }
    }
}
