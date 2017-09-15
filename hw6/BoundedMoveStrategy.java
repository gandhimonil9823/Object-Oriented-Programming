import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class which has a stragegy design and implements MoveStrategy
 * 
 * @author monil
 *
 */
public class BoundedMoveStrategy implements MoveStrategy
{
   private Rectangle rectangle;

   /**
    * Constructor of the class
    * 
    * @param r
    *           the rectangle
    */
   public BoundedMoveStrategy(Rectangle r)
   {
      rectangle = r;
   }

   /**
    * Method that processes all the shapes
    * 
    * @param shapes
    *           total shapes
    */
   @Override
   public void process(List<MoveableShape> shapes)
   {
      for (MoveableShape shape : shapes)
      {
         Rectangle in_bounds = shape.getBounds();
         if (rectangle.contains(in_bounds))
         {
            shape.move();
         }
      }
   }
}
