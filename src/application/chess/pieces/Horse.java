package application.chess.pieces;

import application.chess.Coordinate;
import application.chess.Movement;
import application.chess.Piece;
import application.chess.Tile;

public class Horse extends Piece {

    public Horse(Coordinate inCoords, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, tileRefIn, teamIn, Piece.TYPE_HORSE);
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveHorse(moveTo, origin);
    }

    @Override
    public void highlightAllViableMoves(boolean on) {

    }
}
