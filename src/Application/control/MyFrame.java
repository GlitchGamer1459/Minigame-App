package Application.control;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Chess");
        this.setVisible(true);
    }

    public void setActiveScreen(JPanel panel) {
        this.setContentPane(panel);
    }
}
