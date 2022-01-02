package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Movement;
import Application.chess.Piece;
import Application.chess.Tile;

public class Rook extends Piece {

    @Override
    protected boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveLeftToRightStraightFar(moveTo, origin) ||
                Movement.canMoveUpStraightFar(moveTo, origin) ||
                Movement.canMoveDownStraightFar(moveTo, origin);
    }

    public Rook(Coordinate inCoords, int id, Tile[] tileRefIn, int teamIn) {
        super(inCoords, id, tileRefIn, teamIn, Piece.TYPE_ROOK);
    }
}
