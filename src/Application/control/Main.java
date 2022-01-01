package Application.control;

import Application.chess.ChessPanel;

public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        ChessPanel game = new ChessPanel();

        frame.setActiveScreen(game);

        /*
         if I don't call these the program has a seizure.
         it refuses to print anything to the frame,
         and I don't know WHY
        */
        frame.revalidate();
        frame.repaint();
    }
}
