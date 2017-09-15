import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * A class which deals with the overall configration of all the class
 * 
 * @author monil
 *
 */
public class Animation
{
   /**
    * A method which displays the shapes if various objects
    * 
    * @param shapes
    *           all the shapes
    * @param strategy
    *           the strategy class
    * @param width
    *           the shapeicon width
    * @param height
    *           the shapeicon height
    */
   public static void show(List<MoveableShape> shapes, MoveStrategy strategy, int width, int height)
   {
      // if (strategy.getClass().equals(BoundedMoveStrategy.class))
      // {
      // BoundedMoveStrategy stra = (BoundedMoveStrategy) strategy;
      // stra.setWidth(width);
      // stra.setHeight(height);
      // stra.process(shapes);
      // } else
      // {
      // SimpleMoveStrategy stra1 = new SimpleMoveStrategy(width, height);
      // stra1.process(shapes);
      // }
      JFrame frame = new JFrame();
      ShapeIcon icon = new ShapeIcon((ArrayList<MoveableShape>) shapes, width, height);

      final JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
      {
         strategy.process(shapes);
         label.repaint();
      });
      t.start();
   }
}
