package Application.chess;

import Application.chess.pieces.Bishop;
import Application.chess.pieces.Queen;
import Application.chess.pieces.Rook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessPanel extends JPanel implements MouseListener {

    public Tile[] tileRef = new Tile[64];

    private int saved = 0;
    private boolean didFirstClick = false;
    private Piece pieceToMove;
    private int fromIndex;


    public ChessPanel() {
        setLayout(new GridLayout(8,8));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setTileArray();

        for (Tile tile : tileRef) {
            add(tile);
        }

        addMouseListener(this);

        this.setVisible(true);

        init();
    }

    private void init() {
        Piece piece = new Piece(new Coordinate(2, 0), 0, tileRef, Piece.TEAM_BLACK);
        Queen queen = new Queen(new Coordinate(3, 4), 1, tileRef, Piece.TEAM_WHITE);
        Rook rook = new Rook(new Coordinate(0, 2), 2, tileRef, Piece.TEAM_WHITE);
        Bishop bishop = new Bishop(new Coordinate(4,4), 3, tileRef, Piece.TEAM_BLACK);

        drawPieces();
    }

    private void setTileArray() {
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
        int cap = saved + 8;

        if (startBlack) {
            printBlack = true;
            colorToPrint = Color.BLACK;
            textColor = Color.WHITE;
        } else {
            printBlack = false;
            colorToPrint = Color.WHITE;
            textColor = Color.BLACK;
        }

        for (int i = saved; i < cap; i++) {
            tileRef[i] = new Tile(colorToPrint, textColor, i);

            if (printBlack) {
                colorToPrint = Color.WHITE;
                textColor = Color.BLACK;
                printBlack = false;
            } else {
                colorToPrint = Color.BLACK;
                textColor = Color.WHITE;
                printBlack = true;
            }

            saved++;
        }
    }

    public void drawPieces() {
        for (Tile tile : tileRef) {
            tile.setText("");
        }

        for (Tile tile : tileRef) {
            if (tile.occupyingPiece != null) {
                tile.setText(tile.occupyingPiece.type + tile.occupyingPiece.team);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!didFirstClick) {
            int fromX = (int)(e.getX() / tileRef[0].getWidth()); // tileRef[0] is a stand in for an example tile
            int fromY = (int)(e.getY() / tileRef[0].getHeight());
            fromIndex = Coordinate.getIndexFromCoordinate(new Coordinate(fromX, fromY));

            if (tileRef[fromIndex].occupyingPiece != null) {
                pieceToMove = tileRef[fromIndex].occupyingPiece;
                didFirstClick = true;

                tileRef[fromIndex].setAsSelected(true);
            }
        } else {
            int toX = (int)(e.getX() / tileRef[0].getWidth());
            int toY = (int)(e.getY() / tileRef[0].getHeight());
            int toIndex = Coordinate.getIndexFromCoordinate(new Coordinate(toX, toY));

            if (tileRef[toIndex].occupyingPiece != null) {
                if (tileRef[toIndex].occupyingPiece.team != pieceToMove.team) {
                    tileRef[toIndex].occupyingPiece = null;
                    pieceToMove.move(new Coordinate(toX, toY));
                }
            } else {
                pieceToMove.move(new Coordinate(toX, toY));
            }

            didFirstClick = false;

            tileRef[fromIndex].setAsSelected(false);
        }

        drawPieces();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
