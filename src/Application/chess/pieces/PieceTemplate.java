package Application.chess.pieces;

import Application.chess.Coordinate;

public interface PieceTemplate {

    boolean constraints(Coordinate moveTo, Coordinate position);
}
