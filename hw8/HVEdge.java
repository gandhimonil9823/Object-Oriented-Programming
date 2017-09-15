import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Adds an horizontal Verticle edge
 * 
 * @author monil
 *
 */
public class HVEdge extends LineEdge
{
   private LineStyle lineStyle;

   /**
    * Constructor of the HVedge
    */
   public HVEdge()
   {
      lineStyle = LineStyle.SOLID;
   }

   /**
    * Draws the edge
    * 
    * @param g2
    *           the graphics object
    */

   public void draw(Graphics2D g2)
   {
      Stroke oldStroke = g2.getStroke();
      g2.setStroke(lineStyle.getStroke());
      Line2D d = getConnectionPoints();
      double x1 = d.getX1();
      double x2 = d.getX2();
      double y1 = d.getY1();
      double y2 = d.getY2();
      g2.draw(new Line2D.Double(x1, y1, x2, y1));
      g2.draw(new Line2D.Double(x2, y2, x2, y1));
      g2.setStroke(oldStroke);
   }

   /**
    * Contains method
    * 
    * @param aPoint
    *           the point
    * @return boolean
    */
   public boolean contains(Point2D aPoint)
   {
      final double MAX_DIST = 2;
      return getConnectionPoints().ptSegDist(aPoint) < MAX_DIST;
   }

   /**
    * Sets the line style property.
    * 
    * @param newValue
    *           the new value
    */
   public void setLineStyle(LineStyle newValue)
   {
      lineStyle = newValue;
   }

   /**
    * Gets the line style property.
    * 
    * @return the line style
    */
   public LineStyle getLineStyle()
   {
      return lineStyle;
   }
}
