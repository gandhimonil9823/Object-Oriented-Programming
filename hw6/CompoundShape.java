import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The composite design pattern implementation
 * 
 * @author monil
 *
 */
public class CompoundShape implements MoveableShape
{
   private ArrayList<MoveableShape> collection;

   /**
    * Constructor of the class
    * 
    * @param shapes
    *           the multiple shapes
    */
   public CompoundShape(MoveableShape... shapes)
   {
      collection = new ArrayList<>();
      for (MoveableShape shape : shapes)
      {
         collection.add(shape);
      }
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
      for (MoveableShape shape : collection)
      {
         shape.draw(g2);
      }

   }

   /**
    * Moves the shape
    */

   @Override
   public void move()
   {
      for (MoveableShape shape : collection)
      {
         shape.move();
      }
   }

   /**
    * Gets the bounds of the rectangle
    * 
    * @return the rectangle
    */
   @Override
   public Rectangle getBounds()
   {
      MoveableShape first = collection.get(0);
      Rectangle first_bound = first.getBounds();
      for (int i = 1; i < collection.size(); i++)
      {
         MoveableShape item = collection.get(i);
         Rectangle boundRectangle = item.getBounds();
         first_bound = (Rectangle) first_bound.createUnion(boundRectangle);

      }
      return first_bound;
   }

}
