package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Movement;
import Application.chess.Piece;
import Application.chess.Tile;

public class Rook extends Piece {

    public Rook(Coordinate inCoords, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, tileRefIn, teamIn, Piece.TYPE_ROOK);
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveLeftStraightFar(moveTo, origin) ||
                Movement.canMoveRightStraightFar(moveTo, origin) ||
                Movement.canMoveUpStraightFar(moveTo, origin) ||
                Movement.canMoveDownStraightFar(moveTo, origin);
    }

    @Override
    public void highlightAllViableMoves(boolean on) {
        Movement.highlightUpFar(tileRef, on, this);
        Movement.highlightDownFar(tileRef, on, this);
        Movement.highlightStraightRightFar(tileRef, on, this);
        Movement.highlightStraightLeftFar(tileRef, on, this);
    }
}
