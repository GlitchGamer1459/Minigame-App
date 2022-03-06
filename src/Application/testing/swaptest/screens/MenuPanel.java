package Application.testing.swaptest.screens;

import Application.testing.swaptest.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    JLabel title;
    JButton pg1Button;
    JButton pg2Button;

    public MenuPanel() {

        this.setLayout(new GridLayout(8,1));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        title = new JLabel("Menu-Swapping Test");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);

        pg1Button = new JButton("Page 1");
        pg1Button.setActionCommand("goto1");
        this.add(pg1Button);

        pg2Button = new JButton("Page 2");
        pg2Button.setActionCommand("goto2");
        this.add(pg2Button);

        pg1Button.addActionListener(this);
        pg2Button.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "goto1" -> Main.frame.setActiveScreen(new PageOnePanel());
            case "goto2" -> Main.frame.setActiveScreen(new PageTwoPanel());
        }
    }
}
