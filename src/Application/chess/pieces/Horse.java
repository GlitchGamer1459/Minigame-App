package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Movement;
import Application.chess.Piece;
import Application.chess.Tile;

public class Horse extends Piece {

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveHorse(moveTo, origin);
    }

    public Horse(Coordinate inCoords, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, tileRefIn, teamIn, Piece.TYPE_HORSE);
    }
}
