package Application.control;

import javax.swing.*;
import java.util.ArrayList;

public class Piece {

    // static properties and methods:

    public static ArrayList<Piece> pieceRef = new ArrayList<>();

    // instance properties and methods:

    public Coordinate position;
    public Tile[] tileRef;
    public int ID;

    protected String descriptor = "piece";

    public void move(Coordinate moveTo) {
        int i = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[i].occupyingPiece = null;

        if (constraints()) {
            position = moveTo;
        }

        int o = Coordinate.getIndexFromCoordinate(this.position);
        tileRef[o].occupyingPiece = this;
    }

    // method to be overridden
    protected boolean constraints() {
        return true;
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
