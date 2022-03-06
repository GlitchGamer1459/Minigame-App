package Application.testing.swaptest;

import Application.testing.swaptest.screens.MenuPanel;

public class Main {

    public static MyFrame frame;

    public static void main(String[] args) {
        frame = new MyFrame();
        frame.setActiveScreen(new MenuPanel());
    }
}
