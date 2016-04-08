
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class will create a Car Shape
 * @author CPSC
 */
public class CarShape implements Movable
{
    /**
     * Constructs a car shape object
     * @param x the x coordinate
     * @param y the y coordinate
     * @param w the width of the car shape
     */
    public CarShape(int x, int y, int w)
    {
        xLeft = x;
        yTop = y;
        width = w;
    }


    /**
     * Check whether the mouse pointer is inside the shape
     * @param p point
     * @return boolean indicating whether the mouse pointer is inside the shape
     */
    public boolean contains (Point2D p)
    {
        return xLeft <= p.getX() && p.getX() <= xLeft+width && yTop <= p.getY() && p.getY() <= yTop + width/2;
    }

    /**
     * Translates the shape to a new location
     * @param dx the value to be added to the x-coordinate
     * @param dy the value to be added to the y-coordinate
     */
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
        Rectangle2D.Double body = new Rectangle2D.Double(xLeft, yTop + width / 6, width - 1, width / 6);
        
        Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + width / 6, yTop + width / 3, width / 6, width / 6);
        
        Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + width * 2 / 3, yTop + width / 3, width / 6, width / 6);
        
        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(xLeft + width / 6, yTop + width / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(xLeft + width / 3, yTop);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(xLeft + width * 2 / 3, yTop);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(xLeft + width * 5 / 6, yTop + width / 6);
        
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        
        g2.fill(frontTire);
        g2.fill(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);   
        
        g2.setColor(Color.red);
        g2.fill(body);
    }
    
    
    private int xLeft;
    private int yTop;
    private int width;
    
}
