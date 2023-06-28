package com.company;

import java.awt.*;
import java.util.Random;

public class ComputerChoose {
    //בחירת קוד רנדומילת
 public static void cChoose(){
     Color [] colors = new Color[6];
     Color [] tsofen = new Color[4];
     colors[0]=Color.RED;
     colors[1]=Color.GREEN;
     colors[2]=Color.BLACK;
     colors[3]=Color.YELLOW;
     colors[4]=Color.BLUE;
     colors[5]=Color.CYAN;
     Random rand = new Random();
     for(int i=0;i<4;i++){
         int random=rand.nextInt(6);
         boolean same = false;
         for(int z=0;z<=i;z++){
             if(colors[random]==tsofen[z]){
                 same=true;
             }
         }
         if(!same)
         tsofen[i]=colors[random];
         else{
             while(same){
                 same=false;
                 random=rand.nextInt(6);
                 for(int z=0;z<=i;z++){
                     if(colors[random]==tsofen[z]){
                         same=true;
                     }
                 }
             }
             tsofen[i]=colors[random];
         }

     }
     if(Homepage.isComputerVsPlayer){
         for(int i=0;i<4;i++){
             ComputerVsPlayer.firstGuess[i]=tsofen[i];
         }
     }if(ComputerVsPlayer.playerTurn){
         for(int i=0;i<4;i++){
             ComputerVsPlayer.computerCode[i]=tsofen[i];
         }
     }
     if(!Homepage.isComputerVsPlayer)
    new BoardFrame(tsofen);

 }
}
