package application.chess.pieces;

import application.chess.Coordinate;
import application.chess.Piece;
import application.chess.Tile;
import application.chess.Movement;

public class Queen extends Piece {

    public Queen(Coordinate inCoords, Tile[][] tileRefIn, int team) {
        super(inCoords, tileRefIn, team, Piece.TYPE_QUEEN);
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveUpLeftFar(moveTo, origin) ||
                Movement.canMoveDownRightFar(moveTo, origin) ||
                Movement.canMoveUpRightFar(moveTo, origin) ||
                Movement.canMoveDownLeftFar(moveTo, origin) ||
                Movement.canMoveLeftStraightFar(moveTo, origin) ||
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
        Movement.highlightUpLeftFar(tileRef, on, this);
        Movement.highlightUpRightFar(tileRef, on, this);
        Movement.highlightDownLeftFar(tileRef, on, this);
        Movement.highlightDownRightFar(tileRef, on, this);
    }
}
