import java.awt.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Path2D;

/**
 * A class which constructs a diamond and draws it
 * 
 * @author monil
 *
 */
public class DiamondNode implements Node
{
   private double x;
   private double y;
   private double size;
   private static final int DEFAULT_SIZE = 20;

   /**
    * Constructor for the diamond class
    */
   public DiamondNode()
   {
      size = DEFAULT_SIZE;
      x = 0;
      y = 0;
   }

   /**
    * Draws the shape
    * 
    * @param g2
    *           the graphics object
    */

   @Override
   public void draw(Graphics2D g2)
   {
      Line2D l1 = new Line2D.Double(x, y + size / 2, x + size / 2, y);
      Line2D l2 = new Line2D.Double(x + size / 2, y, x + size, y + size / 2);
      Line2D l3 = new Line2D.Double(x + size, y + size / 2, x + size / 2, y + size);
      Line2D l4 = new Line2D.Double(x + size / 2, y + size, x, y + size / 2);
      g2.draw(l1);
      g2.draw(l2);
      g2.draw(l3);
      g2.draw(l4);
   }

   /**
    * Clones the object
    * 
    * @return the object
    */
   public Object clone()
   {
      try
      {
         return super.clone();
      } catch (CloneNotSupportedException exception)
      {
         return null;
      }
   }

   /**
    * Translates the given object by dx and dy
    * 
    * @param dx
    *           translate it by x
    * @param dy
    *           translate it by y
    */

   @Override
   public void translate(double dx, double dy)
   {
      x += dx;
      y += dy;
   }

   /**
    * Checks whether the object is contained within the rectangle
    * 
    * @param aPoint
    *           the point
    * @return boolean
    */

   @Override
   public boolean contains(Point2D aPoint)
   {
      Path2D.Double h = new Path2D.Double();
      h.moveTo(x, y + size / 2);
      h.lineTo(x + size / 2, y);
      h.lineTo(x + size, y + size / 2);
      h.lineTo(x + size / 2, y + size);
      h.lineTo(x, y + size / 2);

      return h.contains(aPoint);
      // Polygon h = new Polygon();
      // h.addPoint((int) ((int) x + size / 2), (int) y);
      // h.addPoint((int) ((int) x + size), (int) ((int) y + size / 2));
      // h.addPoint((int) ((int) x + size / 2), (int) ((int) y + size));
      // h.addPoint((int) ((int) x), (int) ((int) y + size / 2));
      // return h.contains(aPoint);
      //
      // Rectangle2D rectangle = this.getBounds();
      // return rectangle.contains(aPoint);
      // double dx = Math.abs(aPoint.getX() - size/2);
      // double dy = Math.abs(aPoint.getY()-size/2);
      // return (dx/(size/2 * Math.sqrt(2)) + dy/(size/2 * Math.sqrt(2)) <= 1);
   }

   /**
    * Gets the connection
    * 
    * @return the point2d object
    * @param aPoint
    *           the point
    */

   @Override
   public Point2D getConnectionPoint(Point2D aPoint)
   {
      double centerX = x + size / 2;
      double centerY = y + size / 2;
      double dx = aPoint.getX() - centerX;
      double dy = aPoint.getY() - centerY;

      // if (dx >= dy && dx < -dy)
      // {
      // return new Point2D.Double(x + size / 2, y + size);
      // } else if (dx >= -dy && dx >= dy)
      // {
      // return new Point2D.Double(x + size, y + size / 2);
      // } else if (dx < dy && dx >= -dy)
      // {
      // return new Point2D.Double(x + size / 2, y);
      // } else
      // {
      // return new Point2D.Double(x, y + size / 2);
      // }
      if (dx >= dy && dx < -dy)
      {
         return new Point2D.Double(x + size / 2, y);
      } else if (dx >= -dy && dx >= dy)
      {
         return new Point2D.Double(x + size, y + size / 2);
      } else if (dx < dy && dx >= -dy)
      {
         return new Point2D.Double(x + size / 2, y + size);
      } else
      {
         return new Point2D.Double(x, y + size / 2);
      }
   }

   /**
    * checks the bounds
    * 
    * @return the rectangle
    */

   @Override
   public Rectangle2D getBounds()
   {
      return new Rectangle2D.Double(x, y, size, size);
   }

}
