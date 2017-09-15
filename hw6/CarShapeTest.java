import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/** 
 * A junit class
 * @author monil
 *
 */
public class CarShapeTest
{
   /**
    * test the class
    */
   @Test public void testBoxedBounds()
   {
      MoveableShape shape = new CarShape(10, 10, 50);
      assertEquals(new Rectangle(10, 10, 50, 25), shape.getBounds());
      
      shape = new BoxedShape(shape, 10);    
      assertEquals(new Rectangle(0, 0, 70, 45), shape.getBounds());         
   }
   @Test public void testCarBounds()
   {
      MoveableShape car = new CarShape(10, 10, 50);
      assertEquals(new Rectangle(10, 10, 50, 25), car.getBounds());
   }
}
