package dev.kaan.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingTool extends JPanel {

    private static final long serialVersionUID = 1L;
    /** So, what you are saying essentially is that if a user did not
     * understand all the above material, [about serialization] said
     * user aught not bother worrying about serialization?
     * -- Ziggy,
     * https://stackoverflow.com/a/285809/
     **/
    public ArrayList<Shape> items = new ArrayList<Shape>();

    // you can change these two however you like
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;

    public DrawingTool (ArrayList<Shape> allShapes) {
        super();
        JFrame board = new JFrame("CMPE211 - Let's Draw");    // set frame's title
        board.setSize(415, 440);                              // set frame size
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close button to exit
        board.setVisible(true);
        board.add(this);        // add this JPanel to JFrame
        this.items = allShapes;
        this.setSize(400, 400); // size of our canvas
        this.setVisible(true);  // make this frame visible
    }

    public void paint (Graphics g) {
        g.setColor(fillColor);
        g.fillRect(0, 0, 400, 400);

        for (Shape s : items){
            this.draw(g, s);
        }
    }

    public void draw (Graphics g, Shape item) {
        g.setColor(lineColor);
        Shape obj =  item;

        if (obj.leftTop != null) {
            if (!obj.isCircular) {
                Point startPoint   = obj.points.get(0);
                Point prevPoint    = obj.points.get(0);
                Point currentPoint = obj.points.get(0);

                for (int i = 1; i < obj.points.size(); ++i) {
                    currentPoint = obj.points.get(i);
                    g.drawLine(prevPoint.x, prevPoint.y, currentPoint.x ,currentPoint.y);
                    prevPoint = currentPoint;
                }
                g.drawLine(currentPoint.x, currentPoint.y, startPoint.x ,startPoint.y);
            } else {
                g.drawOval(obj.points.get(0).x, obj.points.get(0).y, (obj.points.get(1).x-obj.points.get(0).x), (obj.points.get(1).x-obj.points.get(0).x));
            }
        }
    }
}