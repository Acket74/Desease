package com.company;

import java.util.ArrayList;
import java.util.List;

public class Skin {
    private Cell[][] cells;

    private int size;

    private int currentIteration;

    public Skin(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("wrong size");
        }
        this.size = size;
        cells = new Cell[size][size];
        currentIteration = 0;
    }

    public Cell getCell(int i, int j) {
        if (i < 0 || j < 0 || i > size || j > size) {
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

    public void incrementCurrentIteration() {
        ++currentIteration;
    }

    public List<Cell> getCellsAvailableToSpresding(int i, int j) {
        ArrayList<Cell> result = new ArrayList<Cell>();
        if (j - 1 >= 0) {
            if (this.getCell(i, j - 1).getCellState() == Cell.CellState.HEALTHY) {
                result.add(this.getCell(i, j - 1));
            }
        }
        if (j + 1 < this.getSize()) {
            if (this.getCell(i, j + 1).getCellState() == Cell.CellState.HEALTHY) {
                result.add(this.getCell(i, j + 1));
            }
        }
        if (i - 1 >= 0) {
            if (this.getCell(i - 1, j).getCellState() == Cell.CellState.HEALTHY) {
                result.add(this.getCell(i - 1, j));
            }
            if (j - 1 >= 0) {
                if (this.getCell(i - 1, j - 1).getCellState() == Cell.CellState.HEALTHY) {
                    result.add(this.getCell(i - 1, j - 1));
                }
            }
            if (j + 1 < this.getSize()) {
                if (this.getCell(i - 1, j + 1).getCellState() == Cell.CellState.HEALTHY) {
                    result.add(this.getCell(i - 1, j + 1));
                }
            }
        }
        if (i + 1 <= this.getSize()) {
            if (this.getCell(i + 1, j).getCellState() == Cell.CellState.HEALTHY) {
                result.add(this.getCell(i + 1, j));
            }
            if (j - 1 >= 0) {
                if (this.getCell(i + 1, j - 1).getCellState() == Cell.CellState.HEALTHY) {
                    result.add(this.getCell(i + 1, j - 1));
                }
            }
            if (j + 1 < this.getSize()) {
                if (this.getCell(i + 1, j + 1).getCellState() == Cell.CellState.HEALTHY) {
                    result.add(this.getCell(i + 1, j + 1));
                }
            }
        }
        return result;
    }
}