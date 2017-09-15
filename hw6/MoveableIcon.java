import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Class that moves a icon and implements the ImageIcon
 * 
 * @author monil
 *
 */
public class MoveableIcon extends ImageIcon implements MoveableShape
{

   private int x;
   private int y;

   /**
    * Constructor of the class
    * 
    * @param filename
    *           the file
    * @param x
    *           the x co-ordinate
    * @param y
    *           the y co-ordinate
    */
   public MoveableIcon(String filename, int x, int y)
   {
      super(filename);
      this.x = x;
      this.y = y;
   }

   /**
    * Draws the shape
    * 
    * @param g2
    *           the graphics input
    */
   @Override
   public void draw(Graphics2D g2)
   {
      paintIcon(null, g2, x, y);
   }

   /**
    * Moves the shape
    */
   @Override
   public void move()
   {
      if (Math.random() < 0.5)
      {
         x++;
      } else
      {
         y++;
      }
   }

   /**
    * Gets the bounds of the rectangle
    * 
    * @return the rectangle
    */
   public Rectangle getBounds()
   {
      Rectangle to_return = new Rectangle(x, y, getIconWidth(), getIconHeight());
      return to_return;

   }
}