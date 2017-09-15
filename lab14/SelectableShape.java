import java.awt.*;
import java.awt.geom.*;

/**
   A shape that manages its selection state.
*/
public abstract class SelectableShape implements SceneShape
{
   public void setSelected(boolean b)
   {
      selected = b;
   }

   public boolean isSelected()
   {
      return selected;
   }

   public void drawSelection(Graphics2D g2)
   {
      Rectangle r = getBounds();
      fillTinySquare(r.getX(),r.getY(), g2);
      fillTinySquare(r.getX(),r.getMaxY(), g2);
      fillTinySquare(r.getMaxX(),r.getY(), g2);
      fillTinySquare(r.getMaxX(),r.getMaxY(), g2);


   }

   private void fillTinySquare(double x, double y, Graphics2D g2)
   {
     final int SIDE = 4;
g2.fill(new Rectangle2D.Double(x-SIDE/2,y -SIDE/2,SIDE,SIDE));      
   }

   private boolean selected;
}
