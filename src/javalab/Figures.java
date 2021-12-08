package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Figures extends JComponent {

    private ArrayList<Shape> shapes;
    private ArrayList<Color> Color;
    private int sideLength = 30;

    public Figures() {
        shapes = new ArrayList<>();
        Color = new ArrayList<>();
    }

    public void addSquare(Point2D x, Color color)
    {
        shapes.add(new Rectangle2D.Double(x.getX() - sideLength , x.getY() - sideLength, sideLength, sideLength));
        Color.add(color);
    }

    public void addCircle(Point2D x, Color color)
    {
        shapes.add(new Ellipse2D.Double(x.getX() - sideLength, x.getY() - sideLength, sideLength, sideLength));
        Color.add(color);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < shapes.size(); i++) {
            g2.setColor(Color.get(i));
            g2.fill(shapes.get(i));
        }
    }
}