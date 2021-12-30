package Application.control;

import java.util.ArrayList;

public class Piece {

    public static ArrayList<Piece> pieceRef = new ArrayList<>();

    public Coordinate position;
    public Tile[] tileRef;
    public int ID;

    public void move(Coordinate moveTo) {
        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = null;

        position = moveTo;

        int o = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[o].occupyingPiece = this;
    }

    public Piece(Coordinate inCoords, int id, Tile[] tileRefIn) {
        position = new Coordinate(inCoords.x, inCoords.y);
        tileRef = tileRefIn;
        ID = id;

        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = this;

        pieceRef.add(this);
    }
}
