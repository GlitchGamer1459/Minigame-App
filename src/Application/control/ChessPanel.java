package Application.control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessPanel extends JPanel implements MouseListener {

    public Tile[] tileRef = new Tile[64];

    private int saved = 0;
    private boolean didFirstClick = false;
    private Piece pieceToMove;

    public ChessPanel() {
        setLayout(new GridLayout(8,8));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setTileArray();

        for (Tile tile : tileRef) {
            add(tile);
        }

        addMouseListener(this);

        this.setVisible(true);

        testing();
    }

    private void testing() {
        Piece piece = new Piece(new Coordinate(2, 0), 0, tileRef);
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
        int cap = saved + 8;

        if (startBlack) {
            printBlack = true;
            colorToPrint = Color.BLACK;
        } else {
            printBlack = false;
            colorToPrint = Color.WHITE;
        }

        for (int i = saved; i < cap; i++) {
            tileRef[i] = new Tile(colorToPrint, i);

            if (printBlack) {
                colorToPrint = Color.WHITE;
                printBlack = false;
            } else {
                colorToPrint = Color.BLACK;
                printBlack = true;
            }

            saved++;
        }
    }

    public void drawPieces() {
        for (Tile tile : tileRef) {
            tile.setText("");
        }

        for (Piece piece : Piece.pieceRef) {
            int pos = Coordinate.getIndexFromCoordinate(piece.position);

            tileRef[pos].setText("test");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!didFirstClick) {
            int fromX = (int)(e.getX() / tileRef[0].getWidth()); // tileRef[0] is a stand in for an example tile
            int fromY = (int)(e.getY() / tileRef[0].getHeight());
            int fromIndex = Coordinate.getIndexFromCoordinate(new Coordinate(fromX, fromY));
            pieceToMove = tileRef[fromIndex].occupyingPiece;

            didFirstClick = true;
        } else {
            int toX = (int)(e.getX() / tileRef[0].getWidth());
            int toY = (int)(e.getY() / tileRef[0].getHeight());

            pieceToMove.move(new Coordinate(toX, toY));

            didFirstClick = false;
        }

        drawPieces();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
