package application.testing.swaptest.screens;

import application.testing.swaptest.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageTwoPanel extends JPanel implements ActionListener {

    final JLabel title;
    final JButton menuButton;

    public PageTwoPanel() {

        this.setLayout(new GridLayout(8,1));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        title = new JLabel("Page Two");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);

        menuButton = new JButton("Main Menu");
        this.add(menuButton);

        menuButton.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.frame.setActiveScreen(new MenuPanel());
    }
}
