package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Movement;
import Application.chess.Piece;
import Application.chess.Tile;

public class Bishop extends Piece {

    public Bishop(Coordinate inCoords, int id, Tile[][] tileRefIn, int teamIn) {
        super(inCoords, id, tileRefIn, teamIn, Piece.TYPE_BISHOP);
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveUpLeftFar(moveTo, origin) ||
                Movement.canMoveDownRightFar(moveTo, origin) ||
                Movement.canMoveUpRightFar(moveTo, origin) ||
                Movement.canMoveDownLeftFar(moveTo, origin);
    }

    @Override
    public void highlightAllViableMoves(boolean on) {
        Movement.highlightUpLeftFar(tileRef, on, this);
        Movement.highlightUpRightFar(tileRef, on, this);
        Movement.highlightDownLeftFar(tileRef, on, this);
        Movement.highlightDownRightFar(tileRef, on, this);
    }
}
