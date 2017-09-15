import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SquareNode implements Node
{
   public SquareNode()
   {
      size = DEFAULT_SIZE;
      x = 0;
      y = 0;
   }

   public Object clone()
   {
      try
      {
         return super.clone();
      }
      catch (CloneNotSupportedException exception)
      {
         return null;
      }
   }

   public void draw(Graphics2D g2)
   {
      g2.draw(new Line2D.Double(x, y, x + size, y));
      g2.draw(new Line2D.Double(x + size, y, x+ size, y + size));
      g2.draw(new Line2D.Double(x + size , y + size, x, y + size));
      g2.draw(new Line2D.Double(x , y + size, x, y));
   }

   public void translate(double dx, double dy)
   {
      x += dx;
      y += dy;
   }

   public Rectangle2D getBounds()
   {
      return new Rectangle2D.Double(
            x, y, size, size);
   }

//   public Point2D getConnectionPoint(Point2D other)
//   {
//      double centerX = x + size / 2;
//      double centerY = y + size / 2;
//      double dx = other.getX() - centerX;
//      double dy = other.getY() - centerY;
//      if (dx >= dy && dx >= -dy) return new Point2D.Double(x + size, centerY);
//      if (dx < dy && dx >= -dy) return new Point2D.Double(centerX, y + size);
//      if (dx >= dy && dx < -dy) return new Point2D.Double(centerX, y);
//      return new Point2D.Double(x, centerY);
//   }   
   public Point2D getConnectionPoint(Point2D other)
   {
      double centerX = x + size/2 ;
      double centerY = y + size/2;
      Line2D connectingLine = new Line2D.Double(centerX,centerY,other.getX(),other.getY());
      Point2D[] connectionPoints = {
         Lines.getIntersection(connectingLine,
            new Line2D.Double(x, y, x + size, y)),
         Lines.getIntersection(connectingLine,
            new Line2D.Double(x, y, x, y + size)),
         Lines.getIntersection(connectingLine,
           new Line2D.Double( x,y+size,x+size,y+size)),
         Lines.getIntersection(connectingLine,
            new Line2D.Double(x+size,y+size,x+size,y))
      };
         
      double closestDistance = Double.MAX_VALUE;
      Point2D closestPoint = new Point2D.Double(x, y);
      for (Point2D p : connectionPoints)
      {
         if (p != null)
         {
          p.distance(other);  
         }
      }
      return closestPoint;
   }   

   public boolean contains(Point2D aPoint)
   {
      return getBounds().contains(aPoint);
   }

   private double x;
   private double y;
   private double size;
   private Color color;  
   private static final int DEFAULT_SIZE = 20;
}
