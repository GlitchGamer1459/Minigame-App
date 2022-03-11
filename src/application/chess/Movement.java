package application.chess;

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

    public static boolean canMoveHorse(Coordinate moveTo, Coordinate origin) {
        int x = origin.x;
        int y = origin.y;

        // check high top left
        x--;
        y -= 2;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check high top right
        x += 2;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check low top right
        x++;
        y++;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check high bottom right
        y += 2;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check low bottom right
        x--;
        y++;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check low bottom left
        x -= 2;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check high bottom left
        x--;
        y--;
        if (moveTo.x == x && moveTo.y == y) {
            return true;
        }

        // check low top left
        y -= 2;
        return moveTo.x == x && moveTo.y == y;
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

        for (int x = piece.position.x - 1; x >= 0; x--) {
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

    public static void highlightUpRightFar(Tile[][] tileRef, boolean on, Piece piece) {
        int y = piece.position.y - 1;

        for (int x = piece.position.x + 1; x < 8; x++) {
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

    public static void highlightDownLeftFar(Tile[][] tileRef, boolean on, Piece piece) {
        int y = piece.position.y + 1;

        for (int x = piece.position.x - 1; x >= 0; x--) {
            if (y == 8) {
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

            y++;
        }
    }

    public static void highlightDownRightFar(Tile[][] tileRef, boolean on, Piece piece) {
        int y = piece.position.y + 1;

        for (int x = piece.position.x + 1; x < 8; x++) {
            if (y == 8) {
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

            y++;
        }
    }

    public static void highlightHorse(Tile[][] tileRef, boolean on, Piece piece) {

    }
}
