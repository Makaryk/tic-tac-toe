package tictactoe;

import java.util.Scanner;

class Game {
    Player x;
    Player o;
    Field field = new Field();

    Scanner scanner = new Scanner(System.in);

    public GameResult menuProcessing() {
        String userInput;
        String[] arrayUserInput;
        boolean isValid = false;
        do {
            System.out.println("Input command:");
            userInput = scanner.nextLine();
            arrayUserInput = userInput.split(" ");
            if (arrayUserInput.length == 1 && arrayUserInput[0].equals("exit")) return GameResult.EXIT;
            if (arrayUserInput.length != 3) {
                System.out.println("Bad parameters!");
                continue;
                //hard
            }
//            if (!(arrayUserInput[0].equals("start"))) {
//                System.out.println("Bad parameters!");
//                continue;
//            }
//            if (arrayUserInput[1].equals("user")) {
//                player1 = new User(field, 'X');
//            }
//            if(arrayUserInput[1].equals("hard")) {
//                //logic for hard level
//                player2 = new User(field, '0');
//                player1= new AI(field, 'X', "hard");
//            }
//            if (arrayUserInput[2].equals("user")) {
//                player2 = new User(field, 'O');
//            } else if (arrayUserInput[2].equals("medium")) {
//                player2 = new AI(field, 'O', "medium");
//            } else if (arrayUserInput[2].equals("easy")) {
//                player2 = new AI(field, 'O', "easy");

            Player playerOne = setPlayer(arrayUserInput[1], 'X');
            Player playerTwo = setPlayer(arrayUserInput[2], 'O');

            if (playerOne != null && playerTwo != null) {
                x = playerOne;
                o = playerTwo;
            } else {
                System.out.println("Bad parameters!");
                continue;
            }
            isValid = true;

        } while (!isValid);

        return GameResult.NOT_FINISHED;
    }

    private Player setPlayer(String input, char figure) {
        if (input.equals("easy") || input.equals("medium") || input.equals("hard")) {
            return new AI(field, figure, input);
        } else if (input.equals("user")) {
            return new User(field, figure);
        } else {
            return null;
        }
    }

    public void start() {
        field.emptyField();
        field.printField();
        GameResult result = field.printResult(field);
        while (result != GameResult.XWIN && result != GameResult.OWIN && result != GameResult.DRAW) {
            x.turn();
            field.printField();
            result = field.printResult(field);
            if (result == GameResult.NOT_FINISHED) {
                o.turn();
                field.printField();
                result = field.printResult(field);
            }
        }
        System.out.println(field.printResult(field).getMessage());
    }
}
