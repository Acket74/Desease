package com.company;

import com.sun.javafx.beans.annotations.NonNull;

public class DeseaseApi {

    public static int SKIN_SIZE = 51;

    public static Skin initSkin() {
        Skin result = new Skin(SKIN_SIZE);
        for (int i = 0; i < result.getSize(); ++i) {
            for (int j = 0; j < result.getSize(); ++j) {
                result.getCell(i, j).setCellState(Cell.CellState.HEALTHY);
                result.getCell(i, j).setCurrentIteration(0);
                result.getCell(i, j).setIllIteration(0);
            }
        }
        result.getCell(result.getSize() / 2, result.getSize() / 2).setCellState(Cell.CellState.INFECTED);
        result.getCell(result.getSize() / 2, result.getSize() / 2).setCurrentIteration(0);
        result.getCell(result.getSize() / 2, result.getSize() / 2).setIllIteration(0);
        result.setCurrentIteration(0);
        return result;
    }

    public void doSpread(@NonNull Skin skin) {
        skin.incrementCurrentIteration();
        for (int i = 0; i < skin.getSize(); ++i) {
            for (int j = 0; j < skin.getSize(); ++j) {
                if (skin.getCell(i, j).getCurrentIteration() < skin.getCurrentIteration()) {
                    switch (skin.getCell(i, j).getCellState()) {
                        case INFECTED:
                            for (Cell cell : skin.getCellsAvailableToSpresding(i, j)) {
                                if (cell.getCurrentIteration() < skin.getCurrentIteration() && Math.random() < 0.5) {
                                    cell.setCellState(Cell.CellState.INFECTED);
                                    cell.incrementIllIteration();
                                    cell.incrementCurrentIteration();
                                }
                            }
                            skin.getCell(i, j).incrementIllIteration();
                            skin.getCell(i, j).incrementCurrentIteration();
                            break;
                        case IMMUNE:
                            skin.getCell(i, j).incrementCurrentIteration();
                        case HEALTHY:
                            break;
                    }
                }
            }
        }
        for (int i = 0; i < skin.getSize(); ++i) {
            for (int j = 0; j < skin.getSize(); ++j) {
                skin.getCell(i,j).setCurrentIteration(skin.getCurrentIteration());
            }
        }
    }


}