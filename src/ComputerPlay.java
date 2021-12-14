import java.util.Random;

class ComputerPlay {
    public void computerTurn(char[][] field) {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        while (true) {
            int col = random.nextInt(3);
            int row = random.nextInt(3);
            if (field[col][row] == ' ') {
                field[col][row] = 'X';
                break;
            }
        }
        System.out.println("Making move level \"easy\"");
        while (true) {
            int col = random.nextInt(3);
            int row = random.nextInt(3);
            if (field[col][row] == ' ') {
                field[col][row] = 'О';
                break;
            }
        }

    }

}
