package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
    private int shape;
    protected final Figures kanwa;

    Panel() {
        this.setBounds(65,10,350,270);
        this.kanwa = new Figures();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        kanwa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                kanwa.requestFocusInWindow();
                if(e.getButton() == MouseEvent.BUTTON1) {
                    if(shape == 1) {
                        kanwa.addSquare(e.getPoint(),Color.RED);
                    }
                    else if(shape == 2) {
                        kanwa.addCircle(e.getPoint(),Color.GREEN);
                    }
                }
                repaint();
            }
        });
        kanwa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_S)
                {
                    whichShape(1);
                }
                else if(e.getKeyCode() == KeyEvent.VK_C)
                {
                    whichShape(2);
                }
                else
                {
                    System.out.println("Wrong key try again !");
                }
            }

        });
        this.add(kanwa);

    }
    public void whichShape(int n) {
        if(n == 1) shape = 1;
        else if(n == 2) shape = 2;
    }
}
