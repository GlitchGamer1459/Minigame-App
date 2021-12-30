package Application.control;

public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        ChessPanel game = new ChessPanel();

        frame.setActiveScreen(game);
    }
}
