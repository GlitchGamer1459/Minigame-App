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

    public Horse(Coordinate inCoords, int id, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, id, tileRefIn, teamIn, Piece.TYPE_HORSE);
    }
}
