package tictactoe;

import java.util.Random;

class AI extends Player {

    private String difficulty;

    Random random = new Random();

    public AI(Field field, char figure, String difficulty) {
        this.field = field;
        this.figure = figure;
        this.difficulty = difficulty;
    }

    public void turn() {
        if (difficulty.equals("easy")) {
            easyTurn();
        } else if (difficulty.equals("medium")) {
            mediumTurn();
        } else if (difficulty.equals("hard")) {
            hardTurn();
        }
    }

    private void easyTurn() {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (field.getFigure(row, col) == ' ') {
                field.setFigure(row, col, figure);
                break;
            }
        }
    }

    private void mediumTurn() {
        System.out.println("Making move level \"medium\"");
        //1. If it already has two in a row and can win with one further move, it does so.
        if (field.checkForAndPlace(190, this.figure)) {
            return;
        } else if (field.checkForAndPlace(208, this.figure)) {
            return;
        } else {
            while (true) {
                int row = random.nextInt(3);
                int col = random.nextInt(3);

                if (field.getFigure(row, col) == ' ') {
                    field.setFigure(row, col, figure);
                    break;
                }
            }
        }
    }

    private void hardTurn() {

        System.out.println("Making move level \"hard\"");
        char opponent = this.figure == 'X' ? 'O' : 'X';

        if (field.checkForAndPlace(this.figure * 2 + ' ', this.figure)) {
            return;
        } else if (field.checkForAndPlace(opponent * 2 + ' ', this.figure)) {
            return;
        } else {

            int row = field.getLastMove().row;
            int col = field.getLastMove().col;

            if (field.isAvailableRow(row)) {
                for (int i = 0; i < 3; i++) {
                    if (field.getFigure(row, i) == ' ') {
                        field.setFigure(row, i, figure);
                        break;
                    }
                }
            } else if (field.isAvailableCol(col)) {
                for (int i = 0; i < 3; i++) {
                    if (field.getFigure(i, col) == ' ') {
                        field.setFigure(i, col, figure);
                        break;
                    }
                }
            } else if (field.areAvailableDiag()) {
                placeInDiag();
            } else {
                while (true) {
                    int newRow = random.nextInt(3);
                    int newCol = random.nextInt(3);

                    if (field.getFigure(newRow, newCol) == ' ') {
                        field.setFigure(newRow, newCol, figure);
                        break;
                    }
                }
            }
        }
    }

    private void placeInDiag() {
        for (int i = 0; i < 3; i++) {
            if (field.getFigure(i, i) == ' ') {
                field.setFigure(i, i, figure);
                return;
            }
        }

        for (int i = 2, j = 0; i < 3; i--, j++) {
            if (field.getFigure(i, i) == ' ') {
                field.setFigure(i, j, figure);
                return;
            }
        }
    }



}

