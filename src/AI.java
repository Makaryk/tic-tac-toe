import java.util.Random;

class AI extends Player {

    public AI(Field field, char figure) {
        this.field = field;
        this.figure = figure;
    }

    public void turn() {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        while (true) {
            int col = random.nextInt(3);
            int row = random.nextInt(3);
            if (field.getFigure(col, row) == ' ') {
                field.setFigure(col, row, figure);
                break;
            }
        }
    }
}
