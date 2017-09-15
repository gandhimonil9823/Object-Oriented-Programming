import java.util.Arrays;

/**
 * Represents a set but with an array implementation
 * 
 * @author monil
 */
public class BitSet implements IntSet
{
   // These are left package visible so they can be accessed in a unit test
   int[] elements;
   int start;
   int elementCount;
   int maximum = Integer.MAX_VALUE;
   int minimum = Integer.MIN_VALUE;

   /**
    * Constructor for the class
    */
   public BitSet()
   {
      elements = new int[10];
      elementCount = 0;
      start = 0;
   }

   /**
    * test whether the bit is present in the array
    * 
    * @param n
    *           the input value
    * @return the boolean value
    */
   public boolean test(int n)
   {
      int value = n - start;
      int index = value / 32;
      if (value < 0)
      {
         return false;
      }
      int position = value % 32;
      boolean know = test(elements[index], position);
      return know;
   }

   /**
    * Sets the value i the array
    * 
    * @param n the
    *           input value
    */
   public void set(int n)
   {
      if (test(n))
      {
         return;
      }
      if (start == 0)
      {
         start = n;
         maximum = n;
         minimum = n;
         int value = n - start;
         int index = value / 32;
         int position = value % 32;
         int k = set(index, position);
         elements[index] = k;
         elementCount++;
      } else
      {
         int value = n - start;
         int index = value / 32;
         int position = value % 32;
         int k = set(index, position);
         if (index >= elements.length)
         {
            extendBitSet();
         }
         elements[index] = k;
         elementCount++;
      }
      if (n > maximum)
      {
         maximum = n;
      }
      if (n < minimum)
      {
         minimum = n;
      }
   }

   /**
    * Clears the element from the array
    * 
    * @param n
    *           the input value
    */
   public void clear(int n)
   {

      int value = n - start;
      int index = value / 32;
      int position = value % 32;

      int clearNum = clear(index, position);
      elementCount--;
   }

   /**
    * Return the min of the array
    * 
    * @return the min
    */
   public int min()
   {
      return minimum;
   }

   /**
    * Return the max of the array
    * 
    * @return the max
    */
   public int max()
   {
      return maximum;
   }

   /**
    * Method to extend the array when it is full
    */
   public void extendBitSet()
   {
      int[] old = elements;
      elements = new int[old.length * 2];
      for (int i = 0; i < old.length; i++)
      {
         elements[i] = old[i];
      }
   }
   // Don't change any of these (but add javadoc)

   /**
    * Gives the size of the array
    * 
    * @return the size
    */
   public int size()
   {
      return elementCount;
   }

   /**
    * Tests for the kth bit in the array
    * 
    * @param n
    *           the index in array
    * @param i
    *           the bit value
    * @return the boolean value
    */
   private static boolean test(int n, int i)
   {
      assert 0 <= i && i < 32;
      return (n & (1 << i)) != 0;
   }

   /**
    * Set the kth bit in the array
    * 
    * @param n
    *           the index in array
    * @param i
    *           the bit value
    * @return an int
    */
   private static int set(int n, int i)
   {
      assert 0 <= i && i < 32;
      return n | (1 << i);
   }

   /**
    * clears the kth bit in the array
    * 
    * @param n
    *           the index in array
    * @param i
    *           the bit value
    * @return an int
    */
   private static int clear(int n, int i)
   {
      assert 0 <= i && i < 32;
      return n & ~(1 << i);
   }

}