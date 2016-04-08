import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;

/**
 * This will convert the shape to a component and attach the mouse adaptors
 * Created by CPSC
 */
public class Componenet extends JComponent
{
    public Componenet(Movable shape)
    {

        this.shape = shape;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePoint = e.getPoint();

                if (! shape.contains(mousePoint))
                    mousePoint = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mousePoint == null)
                    return;

                Point2D lastMouseLocation = mousePoint;

                mousePoint = e.getPoint();

                double dx = mousePoint.getX() - lastMouseLocation.getX();
                double dy  = mousePoint.getY() - lastMouseLocation.getY();

                shape.translate((int)dx, (int)dy);
                repaint();

            }
        });

    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        shape.drawShape(g2);
    }

    private Movable shape;
    private Point2D mousePoint;
}
