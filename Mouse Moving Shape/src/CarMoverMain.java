
import javax.swing.JFrame;


/**
 * This class will take a responsibility to create a shape component
 * and allow the user to interact with using the mouse
 * @author CPSC
 */
public class CarMoverMain
{
    public static void main (String [] args)
    {
        JFrame frame = new JFrame("Move the component");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Movable shape = new CarShape(20, 20, 150);

        //Movable shape = new StarShape(20, 20, 200);

        Componenet component = new Componenet(shape);
        frame.add(component);

        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
}
