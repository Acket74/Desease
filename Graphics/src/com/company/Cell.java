package com.company;

import com.sun.javafx.beans.annotations.NonNull;

import java.awt.*;

public class Cell {

    public enum CellState{
        HEALTHY(new Color(0, 255, 0)),
        INFECTED(new Color(255, 0, 0)),
        IMMUNE(new Color(0, 255, 255));

        CellState(Color color) {
            this.color = color;
        }

        private Color color;
    }

    @NonNull
    CellState cellState;

    int currentIteration;
    int illIteration;

    public Cell(CellState cellState, int currentIteration, int illIteration) {
        this.cellState = cellState;
        this.currentIteration = currentIteration;
        this.illIteration = illIteration;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getCurrentIteration() {
        return currentIteration;
    }

    public void setCurrentIteration(int currentIteration) {
        this.currentIteration = currentIteration;
    }

    public int getIllIteration() {
        return illIteration;
    }

    public void setIllIteration(int illIteration) {
        this.illIteration = illIteration;
    }

    public void incrementIllIteration(){illIteration++;}

    public void incrementCurrentIteration(){currentIteration++;}
}