package Application.control;

public class Coordinate {

    int x;
    int y;

    public static int getIndexFromCoordinate(Coordinate input) {
        return (8 * input.y) + input.x;
    }

    public static Coordinate getCoordinateFromIndex(int position) {
        return new Coordinate(position % 8, (int)(position / 8));
    }

    public Coordinate(int X, int Y) {
        x = X;
        y = Y;
    }
}
