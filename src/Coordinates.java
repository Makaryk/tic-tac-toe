class Coordinates {
    public int y;
    public int x;

    public Coordinates(int y, int x) {
        this.y = y - 1;
        this.x = x - 1;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
