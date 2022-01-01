package Application.control;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {

    public int id;

    public Piece occupyingPiece = null;

    Tile(Color background, Color text, int idIn) {
        this.setOpaque(true);
        this.setBackground(background);
        this.setForeground(text);
        this.setVisible(true);

        id = idIn;
    }
}
