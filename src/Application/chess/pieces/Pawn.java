package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Piece;
import Application.chess.Tile;

public class Pawn extends Piece {

    private boolean didFirstMove = false;
    private final boolean isFacingNorth;

    public Pawn(Coordinate inCoords, int id, Tile[][] tileRefIn, int teamIn, boolean IsFacingNorth) {
        super(inCoords, id, tileRefIn, teamIn, Piece.TYPE_PAWN);
        isFacingNorth = IsFacingNorth;
    }

    private boolean canMovePawn(Coordinate moveTo, Coordinate origin) {
        int toIndex = Coordinate.getIndexFromCoordinate(moveTo);
        int origIndex = Coordinate.getIndexFromCoordinate(origin);

        if (isFacingNorth) {
            if (!didFirstMove) {
                didFirstMove = true;

                return toIndex == origIndex - 8 ||
                          toIndex == origIndex - 16;
            } else {
                return toIndex == origIndex - 8;
            }
        } else {
            if (!didFirstMove) {
                didFirstMove = true;

                return toIndex == origIndex + 8 ||
                        toIndex == origIndex + 16;
            } else {
                return toIndex == origIndex + 8;
            }
        }
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        boolean output = canMovePawn(moveTo, origin);

        if (!output) {
            didFirstMove = false;
        }

        return output;
    }
}
