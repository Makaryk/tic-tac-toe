package tictactoe;

enum GameResult {
    XWIN("X wins"),
    OWIN("O wins"),
    DRAW("Draw"),
    NOT_FINISHED("Game not finished"),
    EXIT("Exit");

    public String getMessage() {
        return message;
    }

    private final String message;

    GameResult(String message) {
        this.message = message;
    }
}
