package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Piece;
import Application.chess.Tile;
import Application.chess.Movement;

public class Queen extends Piece {

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveUpLeftFar(moveTo, origin) ||
                Movement.canMoveDownRightFar(moveTo, origin) ||
                Movement.canMoveUpRightFar(moveTo, origin) ||
                Movement.canMoveDownLeftFar(moveTo, origin) ||
                Movement.canMoveLeftToRightStraightFar(moveTo, origin) ||
                Movement.canMoveUpStraightFar(moveTo, origin) ||
                Movement.canMoveDownStraightFar(moveTo, origin);
    }

    public Queen(Coordinate inCoords, int id, Tile[] tileRefIn, int team) {
        super(inCoords, id, tileRefIn, team, Piece.TYPE_QUEEN);
    }
}
