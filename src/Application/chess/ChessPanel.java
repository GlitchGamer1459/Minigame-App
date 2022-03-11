package Application.chess;

import Application.chess.pieces.Bishop;
import Application.chess.pieces.Horse;
import Application.chess.pieces.Queen;
import Application.chess.pieces.Rook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessPanel extends JPanel implements MouseListener {

    public Tile[][] tileRef = new Tile[8][8];

    private int buildingRow = 0;
    private boolean didFirstClick = false;
    private Piece pieceToMove;
    private Coordinate fromCoord;

    public ChessPanel() {
        setLayout(new GridLayout(8,8));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setTileReference();

        for (Tile[] row : tileRef) {
            for (Tile tile : row) {
                add(tile);
            }
        }

        addMouseListener(this);

        this.setVisible(true);

        init();
    }

    private void init() {
        new Piece(new Coordinate(3,3), tileRef, Piece.TEAM_BLACK);
        new Queen(new Coordinate(5,5), tileRef, Piece.TEAM_WHITE);
        new Horse(new Coordinate(2,7), tileRef, Piece.TEAM_BLACK);
        new Queen(new Coordinate(1,2), tileRef, Piece.TEAM_WHITE);
        new Rook(new Coordinate(3,6), tileRef, Piece.TEAM_WHITE);
        new Bishop(new Coordinate(5,6), tileRef, Piece.TEAM_BLACK);

        drawPieces();
    }

    private void setTileReference() {
        setTileRow(false);
        setTileRow(true);
        setTileRow(false);
        setTileRow(true);
        setTileRow(false);
        setTileRow(true);
        setTileRow(false);
        setTileRow(true);
    }

    private void setTileRow(boolean startBlack) {
        boolean printBlack;
        Color colorToPrint;
        Color textColor;

        if (startBlack) {
            printBlack = true;
            colorToPrint = Color.BLACK;
            textColor = Color.WHITE;
        } else {
            printBlack = false;
            colorToPrint = Color.WHITE;
            textColor = Color.BLACK;
        }

        for (int i = 0; i < 8; i++) {
            tileRef[buildingRow][i] = new Tile(colorToPrint, textColor);

            if (printBlack) {
                colorToPrint = Color.WHITE;
                textColor = Color.BLACK;
                printBlack = false;
            } else {
                colorToPrint = Color.BLACK;
                textColor = Color.WHITE;
                printBlack = true;
            }
        }

        buildingRow++;
    }

    public void drawPieces() {
        for (Tile[] row : tileRef) {
            for (Tile tile : row) {
                tile.setText("");
            }
        }

        for (Tile[] row : tileRef) {
            for (Tile tile : row) {
                if (tile.occupyingPiece != null) {
                    tile.setText(tile.occupyingPiece.type + tile.occupyingPiece.team);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!didFirstClick) {
            fromCoord = new Coordinate((int)(e.getX() / tileRef[0][0].getWidth()), (int)(e.getY() / tileRef[0][0].getHeight()));

            if (tileRef[fromCoord.y][fromCoord.x].occupyingPiece != null) {
                pieceToMove = tileRef[fromCoord.y][fromCoord.x].occupyingPiece;
                didFirstClick = true;

                tileRef[fromCoord.y][fromCoord.x].setAsSelected(true);
                tileRef[fromCoord.y][fromCoord.x].occupyingPiece.highlightAllViableMoves(true);
            }
        } else {
            tileRef[fromCoord.y][fromCoord.x].occupyingPiece.highlightAllViableMoves(false);

            pieceToMove.move(new Coordinate((int)(e.getX() / tileRef[0][0].getWidth()), (int)(e.getY() / tileRef[0][0].getHeight())));

            didFirstClick = false;

            tileRef[fromCoord.y][fromCoord.x].setAsSelected(false);
        }

        drawPieces();
    }

    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
}
