package com.company;

import java.awt.*;

public class ComputerVsPlayer {
    static int computerScore=0;
    static int playerScore =0;
    static Color firstGuess[] = new Color[4];
    static Color computerCode [] = new Color[4];
    static BoardFrame computer;
    static boolean isFinish = false;
    static boolean isChoose = false;
    static boolean playerTurn = false;
    static boolean computerSolve=false;
    static boolean playerSolve = false;
    public ComputerVsPlayer(){
        if(!isFinish){
            Homepage.isComputerVsPlayer=true;
            if(!isChoose)
           new ChoosingFrame();
            else {
                ComputerChoose.cChoose();
                computer = new BoardFrame(Homepage.code1);
            }
        }
    }
    //בודק מי ניצח
    public static void winner(){
        if(!computerSolve && playerSolve){
            WinFrame.massage.setText("player won");
            new WinFrame();
        }else if(computerSolve&&!playerSolve){
            WinFrame.massage.setText("computer won");
            new WinFrame();
        }else if(playerScore==computerScore){
            WinFrame.massage.setText("draw");
            new WinFrame();
        }else if(computerScore<playerScore){
            WinFrame.massage.setText("computer won");
            new WinFrame();
        }else{
            WinFrame.massage.setText("player won");
            new WinFrame();
        }
    }
}
