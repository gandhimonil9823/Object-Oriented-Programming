public class LabeledPoint extends Point
{
   private String label;
   public LabeledPoint(int x, int y, String label) { super(x, y); this.label = label; }
   public String toString() { return super.toString() + "[label=" + label + "]"; }
   public boolean equals(Object obj)
   {
      if(obj == this)
      {
         return true;
      }
      if(obj == null)
      {
         return false;
      }

      if (!(obj.getClass() != this.getClass())) 
      {
         return false;
      }
      LabeledPoint point = (LabeledPoint) obj;
      return super.equals(point) && this.label.equals(point.label);      
   }
}