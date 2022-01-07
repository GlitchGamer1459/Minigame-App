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

        /*
        THIS IS DISGUSTING. NO. WHY DOES NOTHING ELSE WORK. WHAT THE F***.
        I COULD MAAAYBE USE FOR LOOPS BUT LIKE. WHY MAKE MY LIFE EASY.
        this is seriously bad, never do this again. 7 nested if else blocks. christ.
         */

        switch (position.x) {
            case 0 -> {
                if (tileRef[posIndex + 1].occupyingPiece == null) {
                    tileRef[posIndex + 1].setAsViable(on);

                    if (tileRef[posIndex + 2].occupyingPiece == null) {
                        tileRef[posIndex + 2].setAsViable(on);

                        if (tileRef[posIndex + 3].occupyingPiece == null) {
                            tileRef[posIndex + 3].setAsViable(on);

                            if (tileRef[posIndex + 4].occupyingPiece == null) {
                                tileRef[posIndex + 4].setAsViable(on);

                                if (tileRef[posIndex + 5].occupyingPiece == null) {
                                    tileRef[posIndex + 5].setAsViable(on);

                                    if (tileRef[posIndex + 6].occupyingPiece == null) {
                                        tileRef[posIndex + 6].setAsViable(on);

                                        if (tileRef[posIndex + 7].occupyingPiece == null) {
                                            tileRef[posIndex + 7].setAsViable(on);
                                        } else if (tileRef[posIndex + 7].occupyingPiece.team != team) {
                                            tileRef[posIndex + 7].setAsViable(on);
                                        }
                                    } else if (tileRef[posIndex + 6].occupyingPiece.team != team) {
                                        tileRef[posIndex + 6].setAsViable(on);
                                    }
                                } else if (tileRef[posIndex + 5].occupyingPiece.team != team) {
                                    tileRef[posIndex + 5].setAsViable(on);
                                }
                            } else if (tileRef[posIndex + 4].occupyingPiece.team != team) {
                                tileRef[posIndex + 4].setAsViable(on);
                            }
                        } else if (tileRef[posIndex + 3].occupyingPiece.team != team) {
                            tileRef[posIndex + 3].setAsViable(on);
                        }
                    } else if (tileRef[posIndex + 2].occupyingPiece.team != team) {
                        tileRef[posIndex + 2].setAsViable(on);
                    }
                } else if (tileRef[posIndex + 1].occupyingPiece.team != team) {
                    tileRef[posIndex + 1].setAsViable(on);
                }
            }
            case 1 -> {
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
                tileRef[posIndex + 2].setAsViable(on);
                tileRef[posIndex + 3].setAsViable(on);
                tileRef[posIndex + 4].setAsViable(on);
                tileRef[posIndex + 5].setAsViable(on);
                tileRef[posIndex + 6].setAsViable(on);
            }
            case 2 -> {
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
                tileRef[posIndex + 2].setAsViable(on);
                tileRef[posIndex + 3].setAsViable(on);
                tileRef[posIndex + 4].setAsViable(on);
                tileRef[posIndex + 5].setAsViable(on);
            }
            case 3 -> {
                tileRef[posIndex - 3].setAsViable(on);
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
                tileRef[posIndex + 2].setAsViable(on);
                tileRef[posIndex + 3].setAsViable(on);
                tileRef[posIndex + 4].setAsViable(on);
            }
            case 4 -> {
                tileRef[posIndex - 4].setAsViable(on);
                tileRef[posIndex - 3].setAsViable(on);
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
                tileRef[posIndex + 2].setAsViable(on);
                tileRef[posIndex + 3].setAsViable(on);
            }
            case 5 -> {
                tileRef[posIndex - 5].setAsViable(on);
                tileRef[posIndex - 4].setAsViable(on);
                tileRef[posIndex - 3].setAsViable(on);
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
                tileRef[posIndex + 2].setAsViable(on);
            }
            case 6 -> {
                tileRef[posIndex - 6].setAsViable(on);
                tileRef[posIndex - 5].setAsViable(on);
                tileRef[posIndex - 4].setAsViable(on);
                tileRef[posIndex - 3].setAsViable(on);
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
                tileRef[posIndex + 1].setAsViable(on);
            }
            case 7 -> {
                tileRef[posIndex - 7].setAsViable(on);
                tileRef[posIndex - 6].setAsViable(on);
                tileRef[posIndex - 5].setAsViable(on);
                tileRef[posIndex - 4].setAsViable(on);
                tileRef[posIndex - 3].setAsViable(on);
                tileRef[posIndex - 2].setAsViable(on);
                tileRef[posIndex - 1].setAsViable(on);
            }
        }
    }
}
