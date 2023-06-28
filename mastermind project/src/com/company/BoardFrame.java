package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BoardFrame extends JFrame implements ActionListener {
    static Color[] playerTsopen = new Color[4];
    static Color[] computerTsofen = new Color[4];
    int index = 7;
    int position = 0;
    int row = 7;
    public  int getIndex() {
        return index;
    }

    public int getPosition() {
        return position;
    }

    public  int getRow() {
        return row;
    }
    static int col = 0;
    static Board board;
    CheckBoxArray checks;
    JMenu m = new JMenu("menu");
    JMenuBar menu = new JMenuBar();
    JMenuItem close = new JMenuItem("exit");
    JMenuItem restartM = new JMenuItem("restart");
    JMenuItem giveUp = new JMenuItem("give up");
    //פעולה שיוצרת לוח משחק ריק
    public BoardFrame(Color[] tsofen) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        board = new Board();
        add(board);
        checks=new CheckBoxArray();
        add(checks);
        add(new Colors());
        add(new OkAndClear());
        setLayout(null);
        setVisible(true);
        for (int i = 0; i < 4; i++) {
            computerTsofen[i] = tsofen[i];
        }
        for (int i = 0; i < 6; i++) {
            Colors.colors[i].addActionListener(this);
        }
        OkAndClear.clear.addActionListener(this);
        OkAndClear.ok.addActionListener(this);
        m.add(close);
        m.add(restartM);
        m.add(giveUp);
        menu.add(m);
        menu.setBounds(screenSize.width - 50, 0, 50, 50);
        close.addActionListener(this);
        restartM.addActionListener(this);
        giveUp.addActionListener(this);
        setJMenuBar(menu);
        if(Homepage.isComputerVsPlayer && !ComputerVsPlayer.playerTurn){
            setLine(ComputerVsPlayer.firstGuess , row);
            OkAndClear.clear.setEnabled(false);
        }else if(Homepage.isComputerVsPlayer && ComputerVsPlayer.playerTurn){
            OkAndClear.clear.setEnabled(true);
        }
    }
    //פעולה ליצירת לוח משחק והעתק נתונים לתוכה
    public BoardFrame( Color[]tsofen , Color[][] colors , Color[][]results, int index2 , int row2){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Board board2 = new Board();
        CheckBoxArray checks = new CheckBoxArray();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 4; c++) {
                ((JPanel) checks.labels[r].getComponent(0)).getComponent(c).setBackground(results[r][c]);
                board2.buttons[r][c].setBackground(colors[r][c]);
            }
        }
        add(board2);
        add(checks);
        add(new Colors());
        add(new OkAndClear());
        setLayout(null);
        setVisible(true);
        index=index2;
        row=row2;
        position=0;
        col=0;
        for (int i = 0; i < 4; i++) {
            computerTsofen[i] = tsofen[i];
        }
        for (int i = 0; i < 6; i++) {
            Colors.colors[i].addActionListener(this);
        }
        OkAndClear.clear.addActionListener(this);
        OkAndClear.ok.addActionListener(this);
        m.add(close);
        m.add(restartM);
        m.add(giveUp);
        menu.add(m);
        menu.setBounds(screenSize.width - 50, 0, 50, 50);
        close.addActionListener(this);
        restartM.addActionListener(this);
        giveUp.addActionListener(this);
        setJMenuBar(menu);
    }
    //פעולה להכנסת שורת ניחוש
    public static void setLine (Color tsofen [] , int row ){
        for(int i=0;i<4;i++){
            board.buttons[row][i].setBackground(tsofen[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (giveUp == e.getSource()) {
            if (Homepage.isPlayerVsPlayer) {
                if (Homepage.isPlayerVsPlayer) {
                    if (PlayerVsPlayer.turn % 2 == 0) {
                        WinFrame.massage.setText("Loserrrr!!!!!!!  player 1 won");
                        new WinFrame();
                        PlayerVsPlayer.p2.dispose();
                    } else {
                        WinFrame.massage.setText("Loserrrr!!!!!!!  player 2 won");
                        new WinFrame();
                        PlayerVsPlayer.p1.dispose();
                    }
                }

            } else {
                    WinFrame.massage.setText("Loserrrr!!!!!!!");
                    new WinFrame();
                    dispose();
                }
        }
        if (close == e.getSource()) {
            if (Homepage.isPlayerVsPlayer) {
                if (Homepage.isPlayerVsPlayer) {
                    if (Homepage.isPlayerVsPlayer) {
                        if (PlayerVsPlayer.turn % 2 == 0)
                            PlayerVsPlayer.p2.dispose();
                        else
                            PlayerVsPlayer.p1.dispose();
                    }
                }
            }else
                dispose();
        }
            if (restartM == e.getSource()) {
                if (Homepage.isPlayerVsPlayer) {
                    if (Homepage.isPlayerVsPlayer) {
                        if(PlayerVsPlayer.turn%2==0)
                            PlayerVsPlayer.p2.dispose();
                        else
                            PlayerVsPlayer.p1.dispose();
                        new Homepage();
                    }
                }else {
                    dispose();
                    new Homepage();
                }
            }
                if (e.getSource() instanceof JButton) {
                    if (((JButton) e.getSource()).getBackground() == Color.white) {
                        if (e.getSource() == OkAndClear.clear) {
                            for (int i = 3; i >= 0; i--) {
                                Board.buttons[row][i].setBackground(Color.white);
                            }
                            col = 0;
                        }
                        if (e.getSource() == OkAndClear.ok) {
                            //בודק אם המחשב סיים את התור שלו
                            if(Homepage.isComputerVsPlayer && GameLogic.blackFlagCount==4 || row<0){
                                if(ComputerVsPlayer.playerTurn){
                                    ComputerVsPlayer.playerScore=8-row;
                                    ComputerVsPlayer.winner();
                                }else{
                                    GameLogic.blackFlagCount=0;
                                    GameLogic.flagCount=0;
                                    ComputerVsPlayer.computerScore=8-row;
                                    row=7;
                                    index=7;
                                    ComputerVsPlayer.playerTurn=true;
                                    ComputerChoose.cChoose();
                                    dispose();
                                    new BoardFrame(ComputerVsPlayer.computerCode);
                                }
                            }
                            //בודק אם הניחוש תקין
                            if (GameLogic.checkValid(row, board.buttons)) {
                                for (int j = 0; j < 4; j++) {
                                    playerTsopen[j] = Board.buttons[row][j].getBackground();
                                }
                                Color[] temp = new Color[4];
                                for (int i = 0; i < 4; i++) {
                                    temp[i] = computerTsofen[i];
                                }
                                //קבלת פידבק על הניחוש
                                GameLogic.getResult(temp, playerTsopen, index, position);
                                col = 0;
                                position = 0;
                                index--;
                                row--;
                                if (row == -1 && !Homepage.isPlayerVsPlayer && !Homepage.isComputerVsPlayer) {
                                    WinFrame.massage.setText("you didnt managed to solve the code maybe next time");
                                    dispose();
                                    new WinFrame();
                                }
                                //זימון פעולת הAI לפי הפידבק
                                if(Homepage.isComputerVsPlayer && !ComputerVsPlayer.playerTurn){
                                    if(GameLogic.flagCount==2){
                                        Ai.inCaseOfTwo(playerTsopen);
                                    }else if(GameLogic.flagCount==3){
                                        Ai.inCaseOfThree(playerTsopen);
                                    }else if(GameLogic.flagCount==4){
                                        if(GameLogic.blackFlagCount==0){
                                            Ai.inCaseOfFourW(playerTsopen);
                                        }else if(GameLogic.blackFlagCount==1){
                                            Ai.inCaseOfOneB(playerTsopen);
                                        }else if(GameLogic.blackFlagCount==2){
                                            Ai.inCaseOfTwoB(playerTsopen);
                                        }
                                    }
                                }
                                //בדיקת תור מי והעתקת נתוניו
                                if (Homepage.isPlayerVsPlayer && !GameLogic.isFinished) {
                                    if(PlayerVsPlayer.turn%2!=0){
                                        for (int r = 0; r < 8; r++) {
                                            for (int c = 0; c < 4; c++) {
                                                PlayerVsPlayer.player1Board[r][c]=(board.buttons[r][c].getBackground());
                                            }
                                            Color result [] = new Color[4];
                                            for(int i=0;i<4;i++){
                                                result[i]=((JPanel)checks.labels[r].getComponent(0)).getComponent(i).getBackground();
                                            }
                                            PlayerVsPlayer.player1Result[r]=new Color[]{result[0],result[1],result[2],result[3]};
                                        }
                                        PlayerVsPlayer.p1Index=index;
                                        PlayerVsPlayer.p1Row=row;
                                    }if(PlayerVsPlayer.turn%2==0){
                                        for (int r = 0; r < 8; r++) {
                                            for (int c = 0; c < 4; c++) {
                                                PlayerVsPlayer.player2Board[r][c]=(board.buttons[r][c].getBackground());
                                            }
                                            Color result [] = new Color[4];
                                            for(int i=0;i<4;i++){
                                                result[i]=((JPanel)checks.labels[r].getComponent(0)).getComponent(i).getBackground();
                                            }
                                            PlayerVsPlayer.player2Result[r]=new Color[]{result[0],result[1],result[2],result[3]};
                                        }
                                        PlayerVsPlayer.p2Index=index;
                                        PlayerVsPlayer.p2Row=row;
                                    }
                                    PlayerVsPlayer.isOk=true;
                                    PlayerVsPlayer.switchingFrame();
                                }
                            }
                        }
                    } else {
                        if (col < 4) {
                            Board.buttons[row][col].setBackground(((JButton) e.getSource()).getBackground());
                            col++;
                        }
                    }
                }
            }
        }






