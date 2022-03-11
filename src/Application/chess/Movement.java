package Application.chess;

public final class Movement {

    // private constructor to prevent instantiation of class
    private Movement() {}

    // static constraint methods to apply to pieces in overridden constraint method:

    public static boolean canMoveUpLeftFar(Coordinate moveTo, Coordinate origin) {
        int y = origin.y;
        
        for (int x = origin.x; x >= 0; x--) {
            if (y < 0) {
                return false;
            }
            if (moveTo.x == x && moveTo.y == y) {
                return true;
            }
            y--;
        }
        
        return false;
    }

    public static boolean canMoveUpRightFar(Coordinate moveTo, Coordinate origin) {
        int y = origin.y;

        for (int x = origin.x; x < 8; x++) {
            if (y < 0) {
                return false;
            }
            if (moveTo.x == x && moveTo.y == y) {
                return true;
            }
            y--;
        }

        return false;
    }

    public static boolean canMoveDownLeftFar(Coordinate moveTo, Coordinate origin) {
        int y = origin.y;

        for (int x = origin.x; x >= 0; x--) {
            if (y == 8) {
                return false;
            }
            if (moveTo.x == x && moveTo.y == y) {
                return true;
            }
            y++;
        }

        return false;
    }

    public static boolean canMoveDownRightFar(Coordinate moveTo, Coordinate origin) {
        int y = origin.y;

        for (int x = origin.x; x < 8; x++) {
            if (y == 8) {
                return false;
            }
            if (moveTo.x == x && moveTo.y == y) {
                return true;
            }
            y++;
        }

        return false;
    }

    public static boolean canMoveUpStraightFar(Coordinate moveTo, Coordinate origin) {
        for (int y = origin.y; y >= 0; y--) {
            if (moveTo.y == y && moveTo.x == origin.x) {
                return true;
            }
        }

        return false;
    }

    public static boolean canMoveDownStraightFar(Coordinate moveTo, Coordinate origin) {
        for (int y = origin.y; y < 8; y++) {
            if (moveTo.y == y && moveTo.x == origin.x) {
                return true;
            }
        }

        return false;
    }

    public static boolean canMoveLeftStraightFar(Coordinate moveTo, Coordinate origin) {
        for (int x = origin.x; x >= 0; x--) {
            if (moveTo.x == x && moveTo.y == origin.y) {
                return true;
            }
        }

        return false;
    }

    public static boolean canMoveRightStraightFar(Coordinate moveTo, Coordinate origin) {
        for (int x = origin.x; x < 8; x++) {
            if (moveTo.x == x && moveTo.y == origin.y) {
                return true;
            }
        }

        return false;
    }

    @Deprecated // idk if im going to remove it yet but ive left it here for posterity ig
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

    // TODO: needs to be rewritten to avoid portalling
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

    public static void highlightUpFar(Tile[][] tileRef, boolean on, Piece piece){
        for (int y = piece.position.y - 1; y >= 0; y--) {
            if (tileRef[y][piece.position.x].occupyingPiece == null) {
                tileRef[y][piece.position.x].setAsViable(on);
            } else if (tileRef[y][piece.position.x].occupyingPiece != null &&
                    tileRef[y][piece.position.x].occupyingPiece.team != piece.team) {
                tileRef[y][piece.position.x].setAsViable(on);

                break;
            } else {
                break;
            }
        }
    }

    public static void highlightDownFar(Tile[][] tileRef, boolean on, Piece piece) {
        for (int y = piece.position.y + 1; y < 8; y++) {
            if (tileRef[y][piece.position.x].occupyingPiece == null) {
                tileRef[y][piece.position.x].setAsViable(on);
            } else if (tileRef[y][piece.position.x].occupyingPiece != null &&
                    tileRef[y][piece.position.x].occupyingPiece.team != piece.team) {
                tileRef[y][piece.position.x].setAsViable(on);

                break;
            } else {
                break;
            }
        }
    }

    public static void highlightStraightRightFar(Tile[][] tileRef, boolean on, Piece piece) {
        for (int x = piece.position.x + 1; x < 8; x++) {
            if (tileRef[piece.position.y][x].occupyingPiece == null) {
                tileRef[piece.position.y][x].setAsViable(on);
            } else if (tileRef[piece.position.y][x].occupyingPiece != null &&
                    tileRef[piece.position.y][x].occupyingPiece.team != piece.team) {
                tileRef[piece.position.y][x].setAsViable(on);

                break;
            } else {
                break;
            }
        }
    }

    public static void highlightStraightLeftFar(Tile[][] tileRef, boolean on, Piece piece) {
        for (int x = piece.position.x - 1; x >= 0; x--) {
            if (tileRef[piece.position.y][x].occupyingPiece == null) {
                tileRef[piece.position.y][x].setAsViable(on);
            } else if (tileRef[piece.position.y][x].occupyingPiece != null &&
                    tileRef[piece.position.y][x].occupyingPiece.team != piece.team) {
                tileRef[piece.position.y][x].setAsViable(on);

                break;
            } else {
                break;
            }
        }
    }

    public static void highlightUpLeftFar(Tile[][] tileRef, boolean on, Piece piece) {
        int y = piece.position.y - 1;

        for (int x = piece.position.x - 1; x >=0; x--) {
            if (y < 0) {
                break;
            }
            if (tileRef[y][x].occupyingPiece == null) {
                tileRef[y][x].setAsViable(on);
            } else if (tileRef[y][x].occupyingPiece != null &&
                    tileRef[y][x].occupyingPiece.team != piece.team) {
                tileRef[y][x].setAsViable(on);

                break;
            } else {
                break;
            }

            y--;
        }
    }
}
