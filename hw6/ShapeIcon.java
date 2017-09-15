import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

/**
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
   /**
    * Constructor of the class
    * 
    * @param shapes
    *           the shapes
    * @param width
    *           the width
    * @param height
    *           the height
    */
   public ShapeIcon(ArrayList<MoveableShape> shapes, int width, int height)
   {
      this.shapes = shapes;
      this.width = width;
      this.height = height;
   }

   /**
    * gets the width
    * 
    * @return the width
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    * gets the height
    * 
    * @return the height
    */
   public int getIconHeight()
   {
      return height;
   }

   /**
    * Paints the icon
    * 
    * @param c
    *           the component
    * @param g
    *           the graphics
    * @param x
    *           the x coordinate
    * @param y
    *           the y coordinate
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (MoveableShape shape : shapes)
      {
         shape.draw(g2);
      }
   }

   private int width;
   private int height;
   private ArrayList<MoveableShape> shapes;
}
