package tictactoe;

abstract class Player {
    public Field field;
    public char figure;

    public abstract void turn();
}
