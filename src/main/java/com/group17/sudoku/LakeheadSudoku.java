package com.group17.sudoku;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name="managedBean")
@ViewScoped
public class LakeheadSudoku implements Serializable {
    private int[][] userBoard;

    private int[][] solvedBoard;

    public LakeheadSudoku() {
        userBoard = new int[][]{
                {0, 0, 0, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 1, 5, 6, 4, 8, 9, 7},
                {5, 6, 4, 8, 9, 7, 2, 3, 1},
                {8, 9, 7, 2, 3, 1, 5, 6, 4},
                {3, 1, 2, 6, 4, 5, 9, 7, 8},
                {6, 4, 5, 9, 7, 8, 3, 1, 2},
                {9, 7, 8, 3, 1, 2, 6, 4, 5}};

        solvedBoard = new int[][]{
                { 1,2,3, 4,5,6, 7,8,9 },
                { 4,5,6, 7,8,9, 1,2,3 },
                { 7,8,9, 1,2,3, 4,5,6 },
                { 2,3,1, 5,6,4, 8,9,7 },
                { 5,6,4, 8,9,7, 2,3,1 },
                { 8,9,7, 2,3,1, 5,6,4 },
                { 3,1,2, 6,4,5, 9,7,8 },
                { 6,4,5, 9,7,8, 3,1,2 },
                { 9,7,8, 3,1,2, 6,4,5 }};
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
}