package Application.chess;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {

    public int id;
    public Piece occupyingPiece = null;
    private final Color background;

    public Tile(Color backgroundIn, Color text, int idIn) {
        this.setOpaque(true);

        background = backgroundIn;
        this.setBackground(background);

        this.setForeground(text);
        this.setVisible(true);

        id = idIn;
    }

    public void setAsSelected(boolean isActive) {
        if (isActive) {
            if (background == Color.BLACK) {
                setBackground(new Color(50, 190, 50));
            } else {
                setBackground(new Color(120, 255, 90));
            }
        } else {
            setBackground(background);
        }
    }

    public void setAsViable(boolean isActive) {
        if (isActive) {
            if (background == Color.BLACK) {
                setBackground(new Color(50, 120, 50));
            } else {
                setBackground(new Color(170, 255, 140));
            }
        } else {
            setBackground(background);
        }
    }
}
