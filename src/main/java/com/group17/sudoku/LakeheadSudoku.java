package com.group17.sudoku;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Random;

@ManagedBean(name="managedBean")
@ViewScoped
public class LakeheadSudoku implements Serializable {

   // private static final long serialVersionUID = 1L;
    public String data = "54";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    private int[][] userBoard = new int[9][9];

    private int[][] solvedBoard = new int[9][9];

    public LakeheadSudoku() {
        generateSudoku(0,0);
        copyBoard();
        removeBoardValues(Integer.parseInt(data));
    }

    public int[][] getUserBoard() {
        return userBoard;
    }

    public void setUserBoard(int[][] userBoard) {
        this.userBoard = userBoard;
    }

    public int[][] getSolvedBoard() {
        return solvedBoard;
    }

    public void setSolvedBoard(int[][] solvedBoard) {
        this.solvedBoard = solvedBoard;
    }

    public boolean generateSudoku(int x, int y)
    {
        int nextX = x;
        int nextY = y;
        int [] possibleValues = {1,2,3,4,5,6,7,8,9};
        Random random = new Random();
        int temp = 0;
        int current = 0;
        int top = 9;

        for(int i=top-1;i>0;i--)
        {
            current = random.nextInt(i);
            temp = possibleValues[current];
            possibleValues[current] = possibleValues[i];
            possibleValues[i] = temp;
        }

        for(int i=0;i<possibleValues.length;i++)
        {
            if(checkForLegality(x, y, possibleValues[i]))
            {
                solvedBoard[x][y] = possibleValues[i];
                if(x == 8)
                {
                    if(y == 8)
                        return true;
                    else
                    {
                        nextX = 0;
                        nextY = y + 1;
                    }
                }
                else
                {
                    nextX = x + 1;
                }
                if(generateSudoku(nextX, nextY))
                    return true;
            }
        }
        solvedBoard[x][y] = 0;
        return false;
    }

    private boolean checkForLegality(int x, int y, int current)
    {
        int cornerX = 0, cornerY = 0;

        for(int i=0;i<9;i++)
            if(current == solvedBoard[x][i])
                return false;
        for(int i=0;i<9;i++)
            if(current == solvedBoard[i][y])
                return false;

        if(x > 2)
            if(x > 5)
                cornerX = 6;
            else
                cornerX = 3;
        if(y > 2)
            if(y > 5)
                cornerY = 6;
            else
                cornerY = 3;

        for(int i=cornerX;i<9 && i<cornerX+3;i++)
            for(int j=cornerY;j<9 && j<cornerY+3;j++)
                if(current == solvedBoard[i][j])
                    return false;
        return true;
    }

    public void copyBoard() {
        // Copy contents of solvedBoard to userBoard
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                userBoard[i][j] = solvedBoard[i][j];
    }

    public void removeBoardValues(int h)    // h is the holes to be made
    {
        double remS = 81;               // remaining squares
        double remH = (double)h;        // remaining holes

        // Make holes in the userBoard
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++) {
                double chance = remH/remS;
                if(Math.random() <= chance)
                {
                    userBoard[i][j] = 0;
                    remH--;
                }
                remS--;
            }
    }

    public void removeBoardValues()    // h is the holes to be made
    {
        int h = 25;
        double remS = 81;               // remaining squares
        double remH = (double)h;        // remaining holes

        // Make holes in the userBoard
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++) {
                double chance = remH/remS;
                if(Math.random() <= chance)
                {
                    userBoard[i][j] = 0;
                    remH--;
                }
                remS--;
            }
    }
}
