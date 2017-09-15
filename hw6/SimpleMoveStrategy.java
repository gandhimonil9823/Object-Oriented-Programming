import java.awt.FlowLayout;
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
public class SimpleMoveStrategy implements MoveStrategy
{
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
         shape.move();
      }
   }
}
