package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MyFrame extends JFrame
{
    private JButton drawButton;
    private JButton moveButton;
    private JLabel label;
    private Panel panel;
    private int FRAME_WIDTH = 500;
    private int FRAME_HEIGHT = 450;

    MyFrame()
    {
        this.setTitle("Lab4");

        panel = new Panel();

        label = new JLabel();
        label.setBounds(60,320,400,35);
        label.setText("Type s - squere or c -circle on keyboard");
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.LEFT);

        drawButton = new JButton("Draw");
        drawButton.setBounds(50,170,150,50);
        drawButton.setFocusable(false);
        drawButton.addActionListener(e -> drawButtonPressed());
        this.add(drawButton);

        moveButton = new JButton("Move");
        moveButton.setBounds(285,170,150,50);
        moveButton.setFocusable(false);
        moveButton.addActionListener(e -> moveButtonPressed());
        Random r = new Random();
        moveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                final boolean isCursorInRightBound = e.getX()>4;
                if (isCursorInRightBound)
                    switchLocation();
            }
        });
        this.add(moveButton);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void drawButtonPressed() {
        this.getContentPane().removeAll();
        this.add(panel);
        this.add(label);
        this.validate();
        this.repaint();
    }

    private void moveButtonPressed()
    {
        moveButton.setBounds(285,170,150,50);
    }

    private void switchLocation()
    {
        Random  r = new Random();
        moveButton.setBounds(r.nextInt(115)+200, r.nextInt(340)+20, 150,50);
    }

}