package application.testing.swaptest;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        this.setSize(600,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Chess");
        this.setVisible(true);
    }

    public void setActiveScreen(JPanel panel) {
        this.setContentPane(panel);

        this.revalidate();
        this.repaint();
    }
}
