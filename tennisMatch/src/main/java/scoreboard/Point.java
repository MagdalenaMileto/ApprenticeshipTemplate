package scoreboard;

public enum Point {
    Love,
    Fifteen,
    Thirty,
    Forty;

    public Point next() {
        Integer nextPosition = (this.ordinal() + 1) % 4;
        return Point.values()[nextPosition];
    }
}