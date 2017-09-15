import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * Dorator design pattern imlementation of the class
 * 
 * @author monil
 *
 */
public class BoxedShape implements MoveableShape
{
   private int gap;
   private MoveableShape shape;

   /**
    * Constructor of the class
    * 
    * @param shape the shape
    * @param gap the gap
    */
   public BoxedShape(MoveableShape shape, int gap)
   {
      this.gap = gap;
      this.shape = shape;
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
      this.shape.draw(g2);
      if (gap <= 0)
      {
         Rectangle rect = this.getBounds();
         g2.draw(rect);
      } else
      {
         Rectangle rect = this.getBounds();
         int x_value = rect.x;
         int y_value = rect.y;
         int width_value = rect.width;
         int height_value = rect.height;
         Rectangle rect_gap = new Rectangle(x_value - gap, y_value - gap, width_value + (gap * 2),
               height_value + (gap * 2));
         g2.draw(rect_gap);
      }
   }

   /**
    * Moves the shape
    */

   @Override
   public void move()
   {
      this.shape.move();
   }

   /**
    * Gets the bounds of the rectangle
    * 
    * @return the rectangle
    */
   @Override
   public Rectangle getBounds()
   {
      if (gap <= 0)
      {
         Rectangle rect = this.shape.getBounds();
         return rect;
      } else
      {
         Rectangle rect = this.shape.getBounds();
         int x_value = rect.x;
         int y_value = rect.y;
         int width_value = rect.width;
         int height_value = rect.height;
         Rectangle rect_gap = new Rectangle(x_value - gap, y_value - gap, width_value + (gap * 2),
               height_value + (gap * 2));
         return rect_gap;

      }
   }

}
