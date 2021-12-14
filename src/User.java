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
                if (!checkIfOccupied(gameCoordinates.getY(), gameCoordinates.getX())) {
                    field.setFigure(gameCoordinates.getY(), gameCoordinates.getX(), figure);
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

    public boolean checkIfOccupied(int y, int x) {
        if (field.getFigure(gameCoordinates.getY(), gameCoordinates.getX()) != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }
}
