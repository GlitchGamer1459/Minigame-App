package Application.chess;

public final class Movement {

    private Movement() {

    }

    // static constraint methods to apply to pieces in overridden constraint method:

    public static boolean canMoveUpLeftFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        /*
        return toIndex == origIndex - 9 ||
                toIndex == origIndex - 18 ||
                toIndex == origIndex - 27 ||
                toIndex == origIndex - 36 ||
                toIndex == origIndex - 45 ||
                toIndex == origIndex - 54 ||
                toIndex == origIndex - 63;
        */
        return false;
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

    public static boolean canMoveLeftToRightStraightFar(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return switch (origin.x) {
            case 0 -> toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2 ||
                    toIndex == origIndex + 3 ||
                    toIndex == origIndex + 4 ||
                    toIndex == origIndex + 5 ||
                    toIndex == origIndex + 6 ||
                    toIndex == origIndex + 7;
            case 1 -> toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2 ||
                    toIndex == origIndex + 3 ||
                    toIndex == origIndex + 4 ||
                    toIndex == origIndex + 5 ||
                    toIndex == origIndex + 6;
            case 2 -> toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2 ||
                    toIndex == origIndex + 3 ||
                    toIndex == origIndex + 4 ||
                    toIndex == origIndex + 5;
            case 3 -> toIndex == origIndex - 3 ||
                    toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2 ||
                    toIndex == origIndex + 3 ||
                    toIndex == origIndex + 4;
            case 4 -> toIndex == origIndex - 4 ||
                    toIndex == origIndex - 3 ||
                    toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2 ||
                    toIndex == origIndex + 3;
            case 5 -> toIndex == origIndex - 5 ||
                    toIndex == origIndex - 4 ||
                    toIndex == origIndex - 3 ||
                    toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1 ||
                    toIndex == origIndex + 2;
            case 6 -> toIndex == origIndex - 6 ||
                    toIndex == origIndex - 5 ||
                    toIndex == origIndex - 4 ||
                    toIndex == origIndex - 3 ||
                    toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1 ||
                    toIndex == origIndex + 1;
            case 7 -> toIndex == origIndex - 7 ||
                    toIndex == origIndex - 6 ||
                    toIndex == origIndex - 5 ||
                    toIndex == origIndex - 4 ||
                    toIndex == origIndex - 3 ||
                    toIndex == origIndex - 2 ||
                    toIndex == origIndex - 1;
            default -> false;
        };
    }

    public static boolean canMoveHorse(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        return toIndex == origIndex - 6 ||
                toIndex == origIndex - 10 ||
                toIndex == origIndex - 15 ||
                toIndex == origIndex - 17 ||
                toIndex == origIndex + 6 ||
                toIndex == origIndex + 10 ||
                toIndex == origIndex + 15 ||
                toIndex == origIndex + 17;
    }

    // static highlighting methods to apply to pieces in overridden highlightAllViableMoves method:

    public static void highlightUpFar(Tile[] tileRef, boolean on, Piece piece){
        int scanIndex = Coordinate.getIndexFromCoordinate(piece.position);
        boolean running = true;

        while (running) {
            scanIndex -= 8;

            if (scanIndex < 0) {
                running = false;
            } else if (tileRef[scanIndex].occupyingPiece == null) {
                tileRef[scanIndex].setAsViable(on);
            } else if (tileRef[scanIndex].occupyingPiece != null && tileRef[scanIndex].occupyingPiece.team != piece.team) {
                tileRef[scanIndex].setAsViable(on);

                running = false;
            } else {
                running = false;
            }
        }
    }

    public static void highlightDownFar(Tile[] tileRef, boolean on, Piece piece) {
        int scanIndex = Coordinate.getIndexFromCoordinate(piece.position);
        boolean running = true;

        while (running) {
            scanIndex += 8;

            if (scanIndex > 63) {
                running = false;
            } else if (tileRef[scanIndex].occupyingPiece == null) {
                tileRef[scanIndex].setAsViable(on);
            } else if (tileRef[scanIndex].occupyingPiece != null && tileRef[scanIndex].occupyingPiece.team != piece.team) {
                tileRef[scanIndex].setAsViable(on);

                running = false;
            } else if (tileRef[scanIndex].occupyingPiece != null && tileRef[scanIndex].occupyingPiece.team == piece.team) {
                running = false;
            }
        }
    }

    public static void highlightStraightRightFar(Tile[] tileRef, boolean on, Piece piece) {
        int posIndex = Coordinate.getIndexFromCoordinate(piece.position);
        int limiter = posIndex + (7 - piece.position.x);

        for (int i = posIndex + 1; i < limiter + 1; i++) {
            if (tileRef[i].occupyingPiece == null) {
                tileRef[i].setAsViable(on);
            } else if (tileRef[i].occupyingPiece != null && tileRef[i].occupyingPiece.team != piece.team) {
                tileRef[i].setAsViable(on);
                break;
            } else if (tileRef[i].occupyingPiece != null && tileRef[i].occupyingPiece.team == piece.team) {
                break;
            }
        }
    }

    public static void highlightStraightLeftFar(Tile[] tileRef, boolean on, Piece piece) {
        // highlight to the left of piece
        int posIndex = Coordinate.getIndexFromCoordinate(piece.position);

        int limiter = posIndex - piece.position.x;

        for (int i = posIndex - 1; i > limiter - 1; i--) {
            if (tileRef[i].occupyingPiece == null) {
                tileRef[i].setAsViable(on);
            } else if (tileRef[i].occupyingPiece != null && tileRef[i].occupyingPiece.team != piece.team) {
                tileRef[i].setAsViable(on);
                break;
            } else if (tileRef[i].occupyingPiece != null && tileRef[i].occupyingPiece.team == piece.team) {
                break;
            }
        }
    }

    @Deprecated
    public static void highlightUpLeftFar(Tile[] tileRef, boolean on, Piece piece) {
        int scanIndex = Coordinate.getIndexFromCoordinate(piece.position);

        while (true) {
            scanIndex -= 9;

            if (scanIndex < 0) {
                break;
            }
            if (tileRef[scanIndex].occupyingPiece == null) {
                tileRef[scanIndex].setAsViable(on);
            }
        }
    }
}
