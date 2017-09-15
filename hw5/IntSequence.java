import java.util.Iterator;

/**
 * A functional interface dealing with intSequence
 * 
 * @author monil
 */
@FunctionalInterface
public interface IntSequence
{
   /**
    * An abstract method that returns an integer
    * 
    * @return the integer
    */
   public abstract Integer next();

   /**
    * A default method that orders the elements
    * 
    * @param other
    *           the elements
    * @return the intSequence
    */
   default IntSequence alternate(IntSequence other)
   {
      IntSequence to_return = this;
      int counter = 0;
      while (counter > 5)
      {
         if (counter % 2 == 0)
         {
            Integer seq2 = this.next();
            // seq1 = () -> seq2;
         } else
         {
            Integer seq2 = other.next();
            if (seq2 != null)
            {
               // seq1 = () -> seq2;
            } else
            {
               // seq1 = () -> this.next();
            }
         }
         counter++;
      }
      return other;
   }

   /**
    * A method that takes in an iterator and returns an insequence
    * 
    * @param iter
    *           the iterator
    * @return the insequence
    */
   static IntSequence fromIterator(Iterator<Integer> iter)
   {
      return () ->
      {
         int r = iter.next();
         return Math.abs(r) > 0 ? r : null;
      };
   }

}
