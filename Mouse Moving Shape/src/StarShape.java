import java.awt.*;
import java.awt.geom.*;

/**
 * This class will create a Star Shape
 * @author CPSC
 */
public class StarShape implements Movable
{
    /**
     * Constructs a car shape object
     * @param x the x coordinate
     * @param y the y coordinate
     * @param w the width of the car shape
     */
    public StarShape(int x, int y, int w)
    {
        xLeft = x;
        yTop = y;
        width = w;
    }


    public boolean contains (Point2D p)
    {
        return xLeft <= p.getX() && p.getX() <= xLeft+width && yTop <= p.getY() && p.getY() <= yTop + width;
    }

    public void translate(int dx, int dy)
    {
        xLeft += dx;
        yTop += dy;
    }

    /**
     * Draws the Shape
     * @param g2 the Graphics2D component
     */
    public void drawShape(Graphics2D g2)
    {
        GeneralPath path = new GeneralPath();

        Point2D.Double p1 = new Point2D.Double();
        Point2D.Double p2 = new Point2D.Double();

        for (int i = 0; i < points.length -2; i += 2)
        {
            p1.setLocation(xLeft + points[i], yTop + points[i+1]);

            p2.setLocation(xLeft + points[i+2], yTop + points[i+3]);

            path.append(new Line2D.Double(p1, p2), true);
        }

        g2.setColor(Color.GREEN);
        g2.fill(path);

    }


    private double points[] = {
            0, 85, 75, 75,
            100, 10, 125, 75,
            200, 85, 150, 125,
            160, 190, 100, 150,
            40, 190, 50, 125
    };

    private int xLeft;
    private int yTop;
    private int width;

}
