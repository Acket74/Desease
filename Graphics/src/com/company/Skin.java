package com.company;

public class Skin {
    private Cell[][] cells;
    private int size;
    private int currentIteration;

    public Skin(int size){
        if(size <= 0){
            throw new IllegalArgumentException("wrong size");
        }
        this.size = size;
        cells = new Cell[size][size];
        currentIteration = 0;
    }

    public Cell getCell(int i, int j){
        if(i < 0 || j < 0 || i > size || j > size){
            throw new IllegalArgumentException("Wrong params");
        }
        return cells[i][j];
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public int getCurrentIteration() {
        return currentIteration;
    }

    public void setCurrentIteration(int currentIteration) {
        this.currentIteration = currentIteration;
    }

    public void incrementCurrentIteration(){
        ++currentIteration;
    }
}