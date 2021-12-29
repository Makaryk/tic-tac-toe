package tictactoe;

import java.util.Scanner;

class User extends Player {

    public User(Field field, char figure) {
        this.field = field;
        this.figure = figure;
    }

    Scanner scanner = new Scanner(System.in);
    Coordinates gameCoordinates;

    public void turn() {
        String coordinates;
        boolean correctInput = false;
        do {
            System.out.print("Enter the coordinates:");
            coordinates = scanner.nextLine();
            if (!checkCoords(coordinates)) {
                gameCoordinates = new Coordinates(Integer.parseInt(String.valueOf(coordinates.charAt(0))), Integer.parseInt(String.valueOf(coordinates.charAt(2))));
                if (!checkIfOccupied(gameCoordinates.getX(), gameCoordinates.getY())) {
                    field.setFigure(gameCoordinates.getX(), gameCoordinates.getY(), figure);
                    correctInput = true;
                }
            }
        }
        while (!correctInput);
    }

    public boolean checkCoords(String coordinates) {
        String[] coordArray = coordinates.split(" ");
        int i, j;
        try {
            i = Integer.parseInt(coordArray[0]);
            j = Integer.parseInt(coordArray[1]);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return true;
        }
        if ((i < 1 || i > 3) || (j < 1 || j > 3)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }
        return false;
    }

    public boolean checkIfOccupied(int x, int y) {
        if (field.getFigure(gameCoordinates.getX(), gameCoordinates.getY()) != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }
}
