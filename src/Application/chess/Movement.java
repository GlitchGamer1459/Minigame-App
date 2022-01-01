package Application.chess;

public class Movement {

    // static constraint functions to apply to pieces in overridden constraint method:

    public static boolean canMoveUpLeftFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex - 9 ||
                toIndex == origIndex - 18 ||
                toIndex == origIndex - 27 ||
                toIndex == origIndex - 36 ||
                toIndex == origIndex - 45 ||
                toIndex == origIndex - 54 ||
                toIndex == origIndex - 63;
    }

    public static boolean canMoveUpRightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex - 7 ||
                toIndex == origIndex - 14 ||
                toIndex == origIndex - 21 ||
                toIndex == origIndex - 28 ||
                toIndex == origIndex - 35 ||
                toIndex == origIndex - 42 ||
                toIndex == origIndex - 49;
    }

    public static boolean canMoveDownLeftFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex + 7 ||
                toIndex == origIndex + 14 ||
                toIndex == origIndex + 21 ||
                toIndex == origIndex + 28 ||
                toIndex == origIndex + 35 ||
                toIndex == origIndex + 42 ||
                toIndex == origIndex + 49;
    }

    public static boolean canMoveDownRightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex + 9 ||
                toIndex == origIndex + 18 ||
                toIndex == origIndex + 27 ||
                toIndex == origIndex + 36 ||
                toIndex == origIndex + 45 ||
                toIndex == origIndex + 54 ||
                toIndex == origIndex + 63;
    }

    public static boolean canMoveUpStraightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex - 8 ||
                toIndex == origIndex - 16 ||
                toIndex == origIndex - 24 ||
                toIndex == origIndex - 32 ||
                toIndex == origIndex - 40 ||
                toIndex == origIndex - 48 ||
                toIndex == origIndex - 56;
    }

    public static boolean canMoveDownStraightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex + 8 ||
                toIndex == origIndex + 16 ||
                toIndex == origIndex + 24 ||
                toIndex == origIndex + 32 ||
                toIndex == origIndex + 40 ||
                toIndex == origIndex + 48 ||
                toIndex == origIndex + 56;
    }

    public static boolean canMoveLeftStraightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex - 1 ||
                toIndex == origIndex - 2 ||
                toIndex == origIndex - 3 ||
                toIndex == origIndex - 4 ||
                toIndex == origIndex - 5 ||
                toIndex == origIndex - 6 ||
                toIndex == origIndex - 7;
    }

    public static boolean canMoveRightStraightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex + 1 ||
                toIndex == origIndex + 2 ||
                toIndex == origIndex + 3 ||
                toIndex == origIndex + 4 ||
                toIndex == origIndex + 5 ||
                toIndex == origIndex + 6 ||
                toIndex == origIndex + 7;
    }
}
