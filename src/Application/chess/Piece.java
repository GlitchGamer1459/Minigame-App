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

    public static int TEAM_BLACK = 1;
    public static int TEAM_WHITE = 0;

    // instance properties and methods:

    public Coordinate position;
    public Tile[] tileRef;
    public int ID;
    public int team;

    protected String type = TYPE_GENERIC;

    public Piece(Coordinate inCoords, int id, Tile[] tileRefIn, int teamIn) {
        position = new Coordinate(inCoords.x, inCoords.y);
        tileRef = tileRefIn;
        ID = id;
        team = teamIn;

        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = this;

        pieceRef.add(this);
    }

    public Piece(Coordinate inCoords, int id, Tile[] tileRefIn, int teamIn, String typeIn) {
        position = new Coordinate(inCoords.x, inCoords.y);
        tileRef = tileRefIn;
        ID = id;
        team = teamIn;
        type = typeIn;

        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = this;

        pieceRef.add(this);
    }

    public void move(Coordinate moveTo) {
        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = null;

        if (constraints(moveTo, position)) {
            position = moveTo;
        }

        int o = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[o].occupyingPiece = this;
    }

    @Override
    public boolean constraints(Coordinate moveTo, Coordinate position) {
        return true;
    }
}
