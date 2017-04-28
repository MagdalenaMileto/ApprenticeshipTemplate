package board.scoreboard;

public enum Point {
    Love,
    Fifteen,
    Thirty,
    Forty;

    public Point next() {
        Integer nextIndex = (this.ordinal() + 1) % 4;
        return Point.values()[nextIndex];
    }
}
