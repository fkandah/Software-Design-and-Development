import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by CPSC
 */
public interface Movable
{
    /**
     * Check whether the mouse pointer is inside the shape
     * @param p point
     * @return boolean indicating whether the mouse pointer is inside the shape
     */
    public boolean contains(Point2D p);

    /**
     * Translates the shape to a new location
     * @param dx the value to be added to the x-coordinate
     * @param dy the value to be added to the y-coordinate
     */
    public void translate(int dx, int dy);

    /**
     * Draws the Shape
     * @param g2 the Graphics2D component
     */
    public void drawShape(Graphics2D g2);
}
