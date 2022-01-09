package Application.chess.pieces;

import Application.chess.Coordinate;
import Application.chess.Movement;
import Application.chess.Piece;
import Application.chess.Tile;

public class Rook extends Piece {

    public Rook(Coordinate inCoords, int id, Tile[] tileRefIn, int teamIn) {
        super(inCoords, id, tileRefIn, teamIn, Piece.TYPE_ROOK);
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate origin) {
        return Movement.canMoveLeftToRightStraightFar(moveTo, origin) ||
                Movement.canMoveUpStraightFar(moveTo, origin) ||
                Movement.canMoveDownStraightFar(moveTo, origin);
    }

    @Override
    public void highlightAllViableMoves(boolean on) {
        int scanIndex = Coordinate.getIndexFromCoordinate(this.position);
        boolean running = true;


        while (running) {
            scanIndex -= 8;

            if (scanIndex < 0) {
                running = false;
            } else if (tileRef[scanIndex].occupyingPiece == null) {
                tileRef[scanIndex].setAsViable(on);
            } else if (tileRef[scanIndex].occupyingPiece != null && tileRef[scanIndex].occupyingPiece.team != this.team) {
                tileRef[scanIndex].setAsViable(on);

                running = false;
            } else {
                running = false;
            }
        }

        running = true;

        while (running) {
            scanIndex += 8;

            if (scanIndex > 63) {
                running = false;
            } else if (tileRef[scanIndex].occupyingPiece == null) {
                tileRef[scanIndex].setAsViable(on);
            } else if (tileRef[scanIndex].occupyingPiece != null && tileRef[scanIndex].occupyingPiece.team != this.team) {
                tileRef[scanIndex].setAsViable(on);

                running = false;
            }
        }

        int posIndex = Coordinate.getIndexFromCoordinate(position);

        int limiter = position.x + (7 - position.x);

        for (int i = position.x; i < limiter; i++) {
            if (tileRef[posIndex + i].occupyingPiece == null) {
                tileRef[posIndex + i].setAsViable(on);
            } else if (tileRef[posIndex + i].occupyingPiece != null && tileRef[posIndex + i].occupyingPiece.team != team) {
                tileRef[posIndex + i].setAsViable(on);
                break;
            } else if (tileRef[posIndex + i].occupyingPiece != null && tileRef[posIndex + i].occupyingPiece.team == team) {
                break;
            }
        }
    }
}
