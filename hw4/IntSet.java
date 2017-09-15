/**
 * An interface class called intset
 * 
 * @author monil
 *
 */

public interface IntSet
{
   /**
    * Test for the bit in the array
    * 
    * @param n
    *           the bit value
    * @return an int
    */
   boolean test(int n);

   /**
    * Sets the bit in the array
    * 
    * @param n
    *           the bit value
    */
   void set(int n);

   /**
    * Clears the bit value
    * 
    * @param n
    *           he bit value
    */
   void clear(int n);

   /**
    * Returns the min value
    * 
    * @return the min value
    */
   int min();

   /**
    * Returns the max value
    * 
    * @return the max value
    */
   int max();

   /**
    * Returns the size of the array
    * 
    * @return the size
    */
   int size();
}
