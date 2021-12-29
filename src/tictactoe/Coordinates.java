package tictactoe;

class Coordinates {
    public int y;
    public int x;

    public Coordinates(int x, int y) {
        this.x = x - 1;
        this.y = y - 1;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
