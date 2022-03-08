package Application.chess;

import Application.chess.pieces.PieceTemplate;

import java.util.ArrayList;

public class Piece implements PieceTemplate {

    // static properties and methods:

    public static ArrayList<Piece> pieceRef = new ArrayList<>();

    public static String TYPE_GENERIC = "piece";
    public static String TYPE_QUEEN = "queen";
    public static String TYPE_ROOK = "rook";
    public static String TYPE_BISHOP = "bishop";
    public static String TYPE_HORSE = "horse";
    public static String TYPE_PAWN = "pawn";

    public static int TEAM_BLACK = 1;
    public static int TEAM_WHITE = 0;

    // instance properties and methods:

    public Coordinate position;
    public Tile[][] tileRef;
    public int ID;
    public int team;

    protected String type = TYPE_GENERIC;

    public Piece(Coordinate inCoords, int id, Tile[][] tileRefIn, int teamIn) {
        position = new Coordinate(inCoords.x, inCoords.y);
        tileRef = tileRefIn;
        ID = id;
        team = teamIn;

        tileRef[position.y][position.x].occupyingPiece = this;

        pieceRef.add(this);
    }

    public Piece(Coordinate inCoords, int id, Tile[][] tileRefIn, int teamIn, String typeIn) {
        position = new Coordinate(inCoords.x, inCoords.y);
        tileRef = tileRefIn;
        ID = id;
        team = teamIn;
        type = typeIn;

        tileRef[position.y][position.x].occupyingPiece = this;
    }

    public void move(Coordinate moveTo) {
        tileRef[position.y][position.x].occupyingPiece = null;

        if (constraints(moveTo, position)) {
            if (tileRef[moveTo.y][moveTo.x].occupyingPiece != null) {
                if (tileRef[moveTo.y][moveTo.x].occupyingPiece.team != this.team) {
                    tileRef[moveTo.y][moveTo.x].occupyingPiece = null;

                    position = moveTo;
                }
            } else {
                position = moveTo;
            }
        }

        tileRef[position.y][position.x].occupyingPiece = this;
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate position) {
        return true;
    }

    @Override
    public void highlightAllViableMoves(boolean on) {
        for (Tile[] row : tileRef) {
            for (Tile tile : row) {
                if (tile.occupyingPiece != null && tile.occupyingPiece.team != this.team) {
                    tile.setAsViable(on);
                } else if (tile.occupyingPiece == null) {
                    tile.setAsViable(on);
                }
            }
        }
    }
}
