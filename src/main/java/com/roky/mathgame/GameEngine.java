package com.roky.mathgame;

import java.util.Random;

/**
 * Created by Administrator on 2016-05-09.
 */
public class GameEngine {
    private int totalPoint;
    private int rightCount;
    private int level;

    public GameEngine() {
        totalPoint = 0;
        rightCount = 0;
        level = 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalPoint(){
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getRightCount() {
        return rightCount;
    }

    public void setRightCount(int rightCount) {
        this.rightCount = rightCount;
    }

    public String[] getArgs(){
        String[] retValue = new String[5];
        String[] opList = {"+", "-", "*", "/"};
        int randomBase1 = (level - 1) * 5;
        int randomBase2 = level * 5 - 1;
        Random r = new Random();
        int order = r.nextInt(1);;
        int i1 = r.nextInt(4) + randomBase1 + 1;
        int i2 = r.nextInt(randomBase2) + 1;
        if (order == 0){
            retValue[0] = String.valueOf(i1);
            retValue[1] = String.valueOf(i2);
        }else {
            retValue[0] = String.valueOf(i2);
            retValue[1] = String.valueOf(i1);
        }
        retValue[2] = opList[0];
        if (retValue[2] == "+"){
            retValue[3] = String.valueOf(String.valueOf(i1 + i2).length());
        }else if(retValue[2] == "-") {
            retValue[3] = String.valueOf(String.valueOf(i1 - i2).length());
        }else if(retValue[2] == "*") {
            retValue[3] = String.valueOf(String.valueOf(i1 * i2).length());
        }else if(retValue[2] == "/") {
            retValue[3] = String.valueOf(String.valueOf(i1 / i2).length());
        }

            return retValue;
    }

    public boolean checkAnswer(int arg1, int arg2, int answer, String operator)
    {
        if (operator == "+"){
            if (arg1 + arg2 == answer){
                updateResult();
            } else {
                return false;
            }
        } else if (operator == "-") {
            if (arg1 - arg2 == answer) {
                updateResult();
            } else {
                return false;
            }
        } else if (operator == "*") {
            if (arg1 * arg2 == answer) {
                updateResult();
            } else {
                return false;
            }
        } else if (operator == "/") {
            if (arg1 / arg2 == answer) {
                updateResult();
            } else {
                return false;
            }
        }
        return true;

    }

    private void updateResult(){
        rightCount++;
        totalPoint += level;
        if (rightCount % 5 == 0)
        {
            level++;
        }
    }

}
