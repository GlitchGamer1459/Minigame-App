package application.chess.pieces;

import application.chess.Coordinate;
import application.chess.Movement;
import application.chess.Piece;
import application.chess.Tile;

public class Horse extends Piece {

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveHorse(moveTo, origin);
    }

    public Horse(Coordinate inCoords, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, tileRefIn, teamIn, Piece.TYPE_HORSE);
    }
}
