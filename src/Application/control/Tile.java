package Application.control;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {

    public int id;

    public Piece occupyingPiece;

    Tile(Color color, int idIn) {
        this.setOpaque(true);
        this.setBackground(color);
        this.setVisible(true);

        id = idIn;
    }
}
