package com.group17.hello;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name="managedBean")
@ViewScoped
public class JSFHello implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int[][] board = {
            { 0,0,3, 4,5,6, 7,8,9 },
            { 4,5,6, 7,8,9, 1,2,3 },
            { 7,8,9, 1,2,3, 4,5,6 },
            { 2,3,1, 5,6,4, 8,9,7 },
            { 5,6,4, 8,9,7, 2,3,1 },
            { 8,9,7, 2,3,1, 5,6,4 },
            { 3,1,2, 6,4,5, 9,7,8 },
            { 6,4,5, 9,7,8, 3,1,2 },
            { 9,7,8, 3,1,2, 6,4,5 } };

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}