package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Ai {
    //מצב של קבלת פידבק של שתי דגלים
    public static void inCaseOfTwo(Color tsofen []) {
        int flagCount;
        ArrayList<Color> found = new ArrayList<>();
        Color temp [] = new Color[4];
        found.add(Color.RED);
        found.add(Color.GREEN);
        found.add(Color.YELLOW);
        found.add(Color.BLUE);
        found.add(Color.BLACK);
        found.add(Color.CYAN);
            for (int j = 0; j < 4; j++) {
                found.remove(tsofen[j]);
            }
            for (int i = 0; i < 4; i++) {
                temp[i] = tsofen[i];
            }
            temp[0] = tsofen[0];
            temp[1] = tsofen[1];
            temp[2] = found.get(0);
            temp[3] = found.get(1);
// temp = (a,b,e,f)
            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
            ComputerVsPlayer.computer.col = 0;
            ComputerVsPlayer.computer.position = 0;
            ComputerVsPlayer.computer.index--;
            ComputerVsPlayer.computer.row--;
            flagCount = GameLogic.flagCount;
            if (flagCount == 4) {
//found four colors(a, b, e, f)
                found.add(tsofen[0]);
                found.add(tsofen[1]);
                if (GameLogic.blackFlagCount == 0) {
                    inCaseOfFourW(temp);
                } else if (GameLogic.blackFlagCount == 1) {
                    inCaseOfOneB(temp);
                } else if (GameLogic.blackFlagCount == 2) {
                    inCaseOfTwoB(temp);
                }
            } else if (flagCount == 2) { //(a,b,e,f)=2 flags
                //(c, d)=2 flags
                found.clear();
                found.add(Color.RED);
                found.add(Color.GREEN);
                found.add(Color.YELLOW);
                found.add(Color.BLUE);
                found.add(Color.BLACK);
                found.add(Color.CYAN);
                for (int j = 0; j < 4; j++) {
                    found.remove(temp[j]);
                }
                temp[0]=found.get(0);
                temp[1]=found.get(1);
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.flagCount;
                if (flagCount == 4) {
                    found.clear();
                    for (int j = 0; j < 4; j++) {
                        found.add(temp[j]);
                    }
                    if (GameLogic.blackFlagCount == 0) {
                        inCaseOfFourW(temp);
                    } else if (GameLogic.blackFlagCount == 1) {
                        inCaseOfOneB(temp);
                    } else if (GameLogic.blackFlagCount == 2) {
                        inCaseOfTwoB(temp);
                    }
                }
            } else {
                temp[1] = tsofen[2]; //temp=(a,c,e,f)
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.flagCount;
                if (flagCount == 4) {
//found four colors(a, c, e, f)
                    found.add(tsofen[0]);
                    found.add(tsofen[2]);
                    if (GameLogic.blackFlagCount == 0) {
                        inCaseOfFourW(temp);
                    } else if (GameLogic.blackFlagCount == 1) {
                        inCaseOfOneB(temp);
                    } else if (GameLogic.blackFlagCount == 2) {
                        inCaseOfTwoB(temp);
                    }
                } else if (flagCount == 2) { //(a,c,e,f)=2 flags
                    //(b, d)=2 flags
                    temp[0]=tsofen[1];
                    temp[1]=tsofen[3];
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.flagCount;
                    if (flagCount == 4) {
                        found.clear();
                        for (int j = 0; j < 4; j++) {
                            found.add(temp[j]);
                        }
                        if (GameLogic.blackFlagCount == 0) {
                            inCaseOfFourW(temp);
                        } else if (GameLogic.blackFlagCount == 1) {
                            inCaseOfOneB(temp);
                        } else if (GameLogic.blackFlagCount == 2) {
                            inCaseOfTwoB(temp);
                        }
                    }
                } else {
                    temp[1] = tsofen[3];
//temp=(a,d,e,f)
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.flagCount;
                    if(flagCount==2){
                        inCaseOfTwo(temp);
                    }else if(flagCount==3){
                        inCaseOfThree(temp);
                    }else if (flagCount == 4) {
                        found.clear();
                        for (int j = 0; j < 4; j++) {
                            found.add(temp[j]);
                        }
                        if (GameLogic.blackFlagCount == 0) {
                            inCaseOfFourW(temp);
                        } else if (GameLogic.blackFlagCount == 1) {
                            inCaseOfOneB(temp);
                        } else if (GameLogic.blackFlagCount == 2) {
                            inCaseOfTwoB(temp);
                        }
                    }
                }
            }

    }
    //מצב של קבלת של שלוש דגלים
    public static void inCaseOfThree( Color tsofen []) {
        int flagCount;
        ArrayList<Color> found = new ArrayList<>();
        ArrayList<Color> notIn = new ArrayList<>();
        Color temp [] = new Color[4];
        notIn.add(Color.red);
        notIn.add(Color.green);
        notIn.add(Color.yellow);
        notIn.add(Color.blue);
        notIn.add(Color.black);
        notIn.add(Color.cyan);

            for (int j = 0; j < 4; j++) {
                notIn.remove(tsofen[j]);
//notIn =(e,f)
            }
            for (int i = 0; i < 4; i++) {
                temp[i] = tsofen[i];
            }
            temp[3] = notIn.get(0); //temp=(a,b,c,e)
            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
            ComputerVsPlayer.computer.col = 0;
            ComputerVsPlayer.computer.position = 0;
            ComputerVsPlayer.computer.index--;
            ComputerVsPlayer.computer.row--;
            flagCount = GameLogic.flagCount;
            if (flagCount == 4) {
                found.clear();
                for (int j = 0; j < 4; j++) {
                    found.add(tsofen[j]);
                }
                if (GameLogic.blackFlagCount == 0) {
                    inCaseOfFourW(temp);
                } else if (GameLogic.blackFlagCount == 1) {
                    inCaseOfOneB(temp);
                } else if (GameLogic.blackFlagCount == 2) {
                    inCaseOfTwoB(temp);
                }
            } else if (flagCount == 3) {
                temp[3] = notIn.get(1); //temp=(a,b,c,f)

                if (flagCount == 4) {
                    found.clear();
                    for (int j = 0; j < 4; j++) {
                        found.add(temp[j]);
                    }
                    if (GameLogic.blackFlagCount == 0) {
                        inCaseOfFourW(temp);
                    } else if (GameLogic.blackFlagCount == 1) {
                        inCaseOfOneB(temp);
                    } else if (GameLogic.blackFlagCount == 2) {
                        inCaseOfTwoB(temp);
                    }
                } else { //(a,b,c)=2 flags
                    // (e,d)=2 flags
                    for (int i = 0; i < 4; i++) {
                        temp[i] = tsofen[i];
                    }
                    found.add(tsofen[3]); // d
                    found.add(notIn.get(0)); // e
                    temp[2] = tsofen[3];
                    temp[3] = notIn.get(0); //temp=(a,b,d,e)
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.flagCount;
                    if (flagCount == 4) {
                        found.clear();
                        for (int j = 0; j < 4; j++) {
                            found.add(temp[j]);
                        }
                        if (GameLogic.blackFlagCount == 0) {
                            inCaseOfFourW(temp);
                        } else if (GameLogic.blackFlagCount == 1) {
                            inCaseOfOneB(temp);
                        } else if (GameLogic.blackFlagCount == 2) {
                            inCaseOfTwoB(temp);
                        }
                    }
                        else if (flagCount==2){
                           inCaseOfTwo(temp);
                        }
                     else {
                        temp[1] = tsofen[2]; //temp=(a,c,d,e)
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.flagCount;
                        if (flagCount == 4) {
                            found.clear();
                            for (int j = 0; j < 4; j++) {
                                found.add(temp[j]);
                            }
                            if (GameLogic.blackFlagCount == 0) {
                                inCaseOfFourW(temp);
                            } else if (GameLogic.blackFlagCount == 1) {
                                inCaseOfOneB(temp);
                            } else if (GameLogic.blackFlagCount == 2) {
                                inCaseOfTwoB(temp);
                            }
                        } else { //temp=(b,c,d,e)
                            found.clear();
                            found.add(tsofen[1]);
                            found.add(tsofen[2]);
                            found.add(temp[2]);
                            found.add(temp[3]);
                            temp[0] = tsofen[1];
                            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                            ComputerVsPlayer.computer.col = 0;
                            ComputerVsPlayer.computer.position = 0;
                            ComputerVsPlayer.computer.index--;
                            ComputerVsPlayer.computer.row--;
                            flagCount = GameLogic.flagCount;
                            if (flagCount == 4) {
                                found.clear();
                                for (int j = 0; j < 4; j++) {
                                    found.add(temp[j]);
                                }
                                if (GameLogic.blackFlagCount == 0) {
                                    inCaseOfFourW(temp);
                                } else if (GameLogic.blackFlagCount == 1) {
                                    inCaseOfOneB(temp);
                                } else if (GameLogic.blackFlagCount == 2) {
                                    inCaseOfTwoB(temp);
                                }
                            }
                        }
                    }
                }
            } else { //(a,b,c)=2 flags
                //(d,f)=2 flags
                for (int i = 0; i < 4; i++) {
                    temp[i] = tsofen[i];
                }
                temp[2] = tsofen[3];
                temp[3] = notIn.get(1); //temp=(a,b,d,f)
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.flagCount;
                if (flagCount == 4) {
                    found.clear();
                    for (int j = 0; j < 4; j++) {
                        found.add(temp[j]);
                    }
                    if (GameLogic.blackFlagCount == 0) {
                        inCaseOfFourW(temp);
                    } else if (GameLogic.blackFlagCount == 1) {
                        inCaseOfOneB(temp);
                    } else if (GameLogic.blackFlagCount == 2) {
                        inCaseOfTwoB(temp);
                    }
                } else {
                    temp[1] = tsofen[2]; //temp=(a,c,d,f)
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.flagCount;
                    if (flagCount == 4) {
                        found.clear();
                        for (int j = 0; j < 4; j++) {
                            found.add(temp[j]);
                        }
                        if (GameLogic.blackFlagCount == 0) {
                            inCaseOfFourW(temp);
                        } else if (GameLogic.blackFlagCount == 1) {
                            inCaseOfOneB(temp);
                        } else if (GameLogic.blackFlagCount == 2) {
                            inCaseOfTwoB(temp);
                        }
                    } else { //temp=(b,c,d,f)
                        found.add(tsofen[1]);
                        found.add(tsofen[2]);
                        temp[0] = tsofen[1];
                        temp[1] = tsofen[2];
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.flagCount;
                        if(flagCount==2){
                            inCaseOfTwo(temp);
                        }else if(flagCount==3){
                            inCaseOfThree(temp);
                        }else if (flagCount == 4) {
                            found.clear();
                            for (int j = 0; j < 4; j++) {
                                found.add(temp[j]);
                            }
                            if (GameLogic.blackFlagCount == 0) {
                                inCaseOfFourW(temp);
                            } else if (GameLogic.blackFlagCount == 1) {
                                inCaseOfOneB(temp);
                            } else if (GameLogic.blackFlagCount == 2) {
                                inCaseOfTwoB(temp);
                            }
                        }

                    }
                }
            }

    }
    //מצב של קבלת ארבע דגלים לבנים
    public static void inCaseOfFourW(Color tsofen[]) {
        int flagCount=0;
        Color temp[] = new Color[4];
        ArrayList<Color> notIn = new ArrayList<>();
        notIn.add(Color.red);
        notIn.add(Color.green);
        notIn.add(Color.yellow);
        notIn.add(Color.blue);
        notIn.add(Color.black);
        notIn.add(Color.cyan);
        for (int j = 0; j < 4; j++) {
            notIn.remove(tsofen[j]);
//found = (e,f)
        }
        Color a = tsofen[0];
        Color b = tsofen[1];
        Color c = tsofen[2];
        Color d = tsofen[3];
        Color e = notIn.remove(0), f = notIn.remove(0);
        temp[0]=e;
        temp[1]=b;
        temp[2]=a;
        temp[3]=f; //(e,b,a,f)
        if(ComputerVsPlayer.computer.getRow() > -1) {
            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
            ComputerVsPlayer.computer.col = 0;
            ComputerVsPlayer.computer.position = 0;
            ComputerVsPlayer.computer.index--;
            ComputerVsPlayer.computer.row--;
            flagCount = GameLogic.blackFlagCount;
        }
        if(flagCount==1) { //found a - (, ,a, )
            temp[0]=b;
            temp[1]=e;
            temp[2]=a;
            temp[3]=f; //(b,e,a,f)
            if(ComputerVsPlayer.computer.getRow()>-1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
            if(flagCount==2) { //found a,b -(b, ,a, )
                temp[0]=b;
                temp[1]=c;
                temp[2]=a;
                temp[3]=d; //(b,c,a,d)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount!=4) {
                    temp[0]=b;
                    temp[1]=d;
                    temp[2]=a;
                    temp[3]=c; //(b,d,a,c)
                    if(ComputerVsPlayer.computer.getRow()>-1 ){
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
            }
//found a,b - ( , ,a,b)
            else { //(e,f,a,b)
                temp[0]=c;
                temp[1]=d;
                temp[2]=a;
                temp[3]=b; //(c,d,a,b)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount!=4) {
                    temp[0]=d;
                    temp[1]=c;
                    temp[2]=a;
                    temp[3]=b; //(d,c,a,b)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
            }
        }
        else {
            temp[0]=e;
            temp[1]=b;
            temp[2]=f;
            temp[3]=a; //(e,b,f,a)
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
            if(flagCount==1) { //found a - (, , ,a)
                temp[0]=b;
                temp[1]=e;
                temp[2]=f;
                temp[3]=a; //(b,e,f,a)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount==2) {
//found a,b - (b, , ,a)
                    temp[0]=b;
                    temp[1]=c;
                    temp[2]=d;
                    temp[3]=a; //(b,c,d,a)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                    if(flagCount!=4) {
                        temp[0]=b;
                        temp[1]=d;
                        temp[2]=c;
                        temp[3]=a;
//(b,d,c,a)
                        if(ComputerVsPlayer.computer.getRow() > -1) {
                            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                            ComputerVsPlayer.computer.col = 0;
                            ComputerVsPlayer.computer.position = 0;
                            ComputerVsPlayer.computer.index--;
                            ComputerVsPlayer.computer.row--;
                            flagCount = GameLogic.blackFlagCount;
                        }
                    }
                }
                else {
//found a,b - ( , ,b,a)
                    temp[0]=c;
                    temp[1]=d;
                    temp[2]=b;
                    temp[3]=a; //(c,d,b,a)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                    if(flagCount!=4) {
                        temp[0]=d;
                        temp[1]=c;
                        temp[2]=b;
                        temp[3]=a;
//(c,d,b,a)
                        if(ComputerVsPlayer.computer.getRow() > -1) {
                            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                            ComputerVsPlayer.computer.col = 0;
                            ComputerVsPlayer.computer.position = 0;
                            ComputerVsPlayer.computer.index--;
                            ComputerVsPlayer.computer.row--;
                            flagCount = GameLogic.blackFlagCount;
                        }
                    }
                }
            }
            else {
//found a - ( ,a, , )
                temp[0]=b;
                temp[1]=a;
                temp[2]=e;
                temp[3]=f; //(b,a,e,f)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount==2) {
//found a,b - (b,a, , )
                    temp[0]=b;
                    temp[1]=a;
                    temp[2]=d;
                    temp[3]=c; //(b,a,d,c)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
                else {
                    temp[0]=e;
                    temp[1]=a;
                    temp[2]=b;
                    temp[3]=f; //(e,a,b,f)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                    if(flagCount==2) {
//found a,b - ( ,a,b, )
                        temp[0]=d;
                        temp[1]=a;
                        temp[2]=b;
                        temp[3]=c;
//(d,a,b,c)
                        if(ComputerVsPlayer.computer.getRow() > -1) {
                            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                            ComputerVsPlayer.computer.col = 0;
                            ComputerVsPlayer.computer.position = 0;
                            ComputerVsPlayer.computer.index--;
                            ComputerVsPlayer.computer.row--;
                            flagCount = GameLogic.blackFlagCount;
                        }
                        else {
//found a,b - ( ,a, ,b)
                            temp[0]=c;
                            temp[1]=a;
                            temp[2]=d;
                            temp[3]=b;
//(c,a,d,b)
                            if(ComputerVsPlayer.computer.getRow() > -1) {
                                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                                ComputerVsPlayer.computer.col = 0;
                                ComputerVsPlayer.computer.position = 0;
                                ComputerVsPlayer.computer.index--;
                                ComputerVsPlayer.computer.row--;
                                flagCount = GameLogic.blackFlagCount;
                            }
                        }
                    }
                }
            }
        }
    }
    //מצב של קבלת שתי דגלים שחורים
    public static void inCaseOfTwoB(Color tsofen[]) {
        int flagCount=0;
        Color temp[] = new Color[4];
        ArrayList<Color> notIn = new ArrayList<>();
        notIn.add(Color.red);
        notIn.add(Color.green);
        notIn.add(Color.yellow);
        notIn.add(Color.blue);
        notIn.add(Color.black);
        notIn.add(Color.cyan);
        for (int j = 0; j < 4; j++) {
            notIn.remove(tsofen[j]);
//found = (e,f)
        }
        Color a = tsofen[0];
        Color b = tsofen[1];
        Color c = tsofen[2];
        Color d = tsofen[3];
        Color e = notIn.remove(0), f = notIn.remove(0);
        temp[0]=a;
        temp[1]=b;
        temp[2]=e;
        temp[3]=f; //(a,b,e,f)
        if(ComputerVsPlayer.computer.getRow() > -1) {
            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
            ComputerVsPlayer.computer.col = 0;
            ComputerVsPlayer.computer.position = 0;
            ComputerVsPlayer.computer.index--;
            ComputerVsPlayer.computer.row--;
            flagCount = GameLogic.blackFlagCount;
        }
        if(flagCount==2) {
            temp[0]=a;
            temp[1]=b;
            temp[2]=d;
            temp[3]=c;
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
        }

       else if(flagCount==0) {
            temp[0]=b;
            temp[1]=a;
            temp[2]=c;
            temp[3]=d; //(b,e,a,f)
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
        }
        else {
            temp[0]=a;
            temp[1]=e;
            temp[2]=c;
            temp[3]=f; //(a,e,c,f)
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
            if(flagCount==2) {
                temp[0]=a;
                temp[1]=d;
                temp[2]=c;
                temp[3]=b; //(e,b,a,f)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else if(flagCount==0) {
                temp[0]=c;
                temp[1]=b;
                temp[2]=a;
                temp[3]=d; //(e,b,a,f)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else {
                temp[0]=a;
                temp[1]=e;
                temp[2]=f;
                temp[3]=d; //(a,e,f,d)
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount==2) {
                    temp[0]=a;
                    temp[1]=c;
                    temp[2]=b;
                    temp[3]=d; //(a,c,b,d)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
                else {
                    temp[0]=d;
                    temp[1]=b;
                    temp[2]=c;
                    temp[3]=a; //(e,b,a,f)
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
            }
        }
    }
    //מצב של קבלת דגל אחד שחור
    public static void inCaseOfOneB(Color tsofen[]) {
        int flagCount=0;
        Color temp[] = new Color[4];
        ArrayList<Color> notIn = new ArrayList<>();
        notIn.add(Color.red);
        notIn.add(Color.green);
        notIn.add(Color.yellow);
        notIn.add(Color.blue);
        notIn.add(Color.black);
        notIn.add(Color.cyan);
        for (int j = 0; j < 4; j++) {
            notIn.remove(tsofen[j]);
//found = (e,f)
        }
        Color a = tsofen[0];
        Color b = tsofen[1];
        Color c = tsofen[2];
        Color d = tsofen[3];
        Color e = notIn.remove(0), f = notIn.remove(0);
        temp[0]=a;
        temp[1]=b;
        temp[2]=e;
        temp[3]=f; //(e,b,a,f)
        if(ComputerVsPlayer.computer.getRow() > -1) {
            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
            ComputerVsPlayer.computer.col = 0;
            ComputerVsPlayer.computer.position = 0;
            ComputerVsPlayer.computer.index--;
            ComputerVsPlayer.computer.row--;
            flagCount = GameLogic.blackFlagCount;
        }
        if(flagCount==1) {
            temp[0]=e;
            temp[1]=b;
            temp[2]=a;
            temp[3]=f;
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
            if(flagCount==2) {
                temp[0]=d;
                temp[1]=b;
                temp[2]=a;
                temp[3]=c;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else if(flagCount==1) {
                temp[0]=c;
                temp[1]=b;
                temp[2]=d;
                temp[3]=a;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else {
                temp[0]=a;
                temp[1]=e;
                temp[2]=b;
                temp[3]=f;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount==2) {
                    temp[0]=a;
                    temp[1]=d;
                    temp[2]=b;
                    temp[3]=c;
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
                else {
                    temp[0]=a;
                    temp[1]=c;
                    temp[2]=d;
                    temp[3]=b;
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
            }
        }
        else {
            temp[0]=e;
            temp[1]=b;
            temp[2]=a;
            temp[3]=f;
            if(ComputerVsPlayer.computer.getRow() > -1) {
                BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                ComputerVsPlayer.computer.col = 0;
                ComputerVsPlayer.computer.position = 0;
                ComputerVsPlayer.computer.index--;
                ComputerVsPlayer.computer.row--;
                flagCount = GameLogic.blackFlagCount;
            }
            if(flagCount==2) {
                temp[0]=c;
                temp[1]=b;
                temp[2]=a;
                temp[3]=d;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else if(flagCount==1) {
                temp[0]=b;
                temp[1]=c;
                temp[2]=a;
                temp[3]=d;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
            }
            else {
                temp[0]=e;
                temp[1]=b;
                temp[2]=f;
                temp[3]=a;
                if(ComputerVsPlayer.computer.getRow() > -1) {
                    BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                    GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                    ComputerVsPlayer.computer.col = 0;
                    ComputerVsPlayer.computer.position = 0;
                    ComputerVsPlayer.computer.index--;
                    ComputerVsPlayer.computer.row--;
                    flagCount = GameLogic.blackFlagCount;
                }
                if(flagCount==2) {
                    temp[0]=d;
                    temp[1]=b;
                    temp[2]=c;
                    temp[3]=a;
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
                else if(flagCount==1) {
                    temp[0]=b;
                    temp[1]=d;
                    temp[2]=c;
                    temp[3]=a;
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                }
                else {
                    temp[0]=c;
                    temp[1]=a;
                    temp[2]=b;
                    temp[3]=d;
                    if(ComputerVsPlayer.computer.getRow() > -1) {
                        BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                        GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                        ComputerVsPlayer.computer.col = 0;
                        ComputerVsPlayer.computer.position = 0;
                        ComputerVsPlayer.computer.index--;
                        ComputerVsPlayer.computer.row--;
                        flagCount = GameLogic.blackFlagCount;
                    }
                    if(flagCount!=4) {
                        temp[0]=d;
                        temp[1]=a;
                        temp[2]=c;
                        temp[3]=b;
                        if(ComputerVsPlayer.computer.getRow() > -1) {
                            BoardFrame.setLine(temp, ComputerVsPlayer.computer.getRow());
                            GameLogic.getResult(Homepage.code1, temp, ComputerVsPlayer.computer.getIndex(), ComputerVsPlayer.computer.getPosition());
                            ComputerVsPlayer.computer.col = 0;
                            ComputerVsPlayer.computer.position = 0;
                            ComputerVsPlayer.computer.index--;
                            ComputerVsPlayer.computer.row--;
                            flagCount = GameLogic.blackFlagCount;
                        }
                    }
                }
            }
        }
    }
}

