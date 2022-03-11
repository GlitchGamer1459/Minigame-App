package application.chess.pieces;

import application.chess.Coordinate;

@SuppressWarnings("unused")
public interface PieceTemplate {

    boolean constraints(Coordinate moveTo, Coordinate position);

    void highlightAllViableMoves(boolean on);
}
