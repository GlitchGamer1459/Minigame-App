package application.chess;

public class Coordinate {

    // static properties and methods:

    public static int getIndexFromCoordinate(Coordinate input) {
        return (8 * input.y) + input.x;
    }

    // instance properties and methods:

    public final int x;
    public final int y;

    public Coordinate(int X, int Y) {
        x = X;
        y = Y;
    }
}
