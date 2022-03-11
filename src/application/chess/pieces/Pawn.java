package application.chess.pieces;

import application.chess.Coordinate;
import application.chess.Piece;
import application.chess.Tile;

public class Pawn extends Piece {

    public Pawn(Coordinate inCoords, Tile[][] tileRefIn, int teamIn, boolean IsFacingNorth) {
        super(inCoords, tileRefIn, teamIn, Piece.TYPE_PAWN);
    }

    @SuppressWarnings("unused")
    private boolean canMovePawn(Coordinate moveTo, Coordinate origin) {
        return true;
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return canMovePawn(moveTo, origin);
    }
}
