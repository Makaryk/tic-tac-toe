package tictactoe;

class Field {
    char[][] field = new char[3][3];
    private final Move lastMove = new Move(0, 0);

    public char[][] getField(){
        return field;
    }

    public char getFigure(int row, int col) {
        return field[row][col];
    }

    public void setFigure(int row, int col, char figure) {
        field[row][col] = figure;
        lastMove.row = row;
        lastMove.col = col;
    }

    public void emptyField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';

            }
        }
    }

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public GameResult printResult(Field gameField) {
        for (int i = 0; i < 3; i++) {
            if (field[0][i] + field[1][i] + field[2][i] == 264) {
                return GameResult.XWIN;
            }
            if (field[0][i] + field[1][i] + field[2][i] == 237) {
                return GameResult.OWIN;
            }
            if (field[i][0] + field[i][1] + field[i][2] == 264) {
                return GameResult.XWIN;
            }
            if (field[i][0] + field[i][1] + field[i][2] == 237) {
                return GameResult.OWIN;
            }
        }
        if (field[0][0] + field[1][1] + field[2][2] == 264
                || field[0][2] + field[1][1] + field[2][0] == 264) {
            return GameResult.XWIN;
        }
        if (field[0][0] + field[1][1] + field[2][2] == 237
                || field[0][2] + field[1][1] + field[2][0] == 237) {
            return GameResult.OWIN;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ' ') {
                    return GameResult.NOT_FINISHED;
                }
            }
        }
        return GameResult.DRAW;
    }

    public boolean checkForAndPlace(int needValue, char figure) {
        for (int cell = 0; cell < field.length; cell++) {
            //Check horizontals
            if (field[cell][0] + field[cell][1] + field[cell][2] == needValue) {
                for (int i = 0; i < 3; i++) {
                    if (field[cell][i] == ' ') {
                        setFigure(cell, i, figure);
                        return true;
                    }
                }
            }
            //Check verticals
            if (field[0][cell] + field[1][cell] + field[2][cell] == needValue) {
                for (int i = 0; i < 3; i++) {
                    if (field[i][cell] == ' ') {
                        setFigure(i, cell, figure);
                        return true;
                    }
                }
            }
        }

        //Check first diagonal
        if (field[0][0] + field[1][1] + field[2][2] == needValue) {
            for (int i = 0; i < 3; i++) {
                if (field[i][i] == ' ') {
                    setFigure(i, i, figure);
                    return true;
                }
            }
        }
        //Check second diagonal
        if (field[0][2] + field[1][1] + field[2][0] == needValue) {
            for (int row = 2, col = 0; row < 3; row--, col++) {
                if (field[row][col] == ' ') {
                    setFigure(row, col, figure);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAvailableRow(int row) {
        return field[row][0] == ' ' || field[row][1] == ' ' || field[row][2] == ' ';
    }

    public boolean isAvailableCol(int col) {
        return field[0][col] == ' ' || field[1][col] == ' ' || field[2][col] == ' ';
    }

    public boolean areAvailableDiag() {
        return field[0][0] == ' ' || field[1][1] == ' ' || field[2][2] == ' ' ||
                field[2][0] == ' ' || field[0][2] == ' ';
    }

    public Move getLastMove() {
        return lastMove;
    }
}
