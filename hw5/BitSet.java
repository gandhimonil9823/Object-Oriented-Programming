import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * class Which deals with the bits
 * 
 * @author monil
 *
 */
public class BitSet implements IntSet
{
   int[] elements;
   int start;
   int elementCount;
   int modCount;

   /**
    * test whether the element is present
    * 
    * @param n
    *           the number
    * @return the boolean
    */
   public boolean test(int n)
   {
      if (elements == null || n < start || n >= start + 32 * elements.length)
         return false;
      int p = (n - start) / 32;
      int i = (n - start) % 32;
      return test(elements[p], i);
   }

   /**
    * sets the element
    * 
    * @param n the
    *           element
    */
   public void set(int n)
   {
      if (elements == null)
      {
         elements = new int[10];
         start = n;
      } else if (n < start)
      {
         int intsNeeded = (start + 32 * elements.length - n) / 32 + 1;
         int[] newElements = new int[Math.max(intsNeeded, 2 * elements.length)];
         System.arraycopy(elements, 0, newElements, newElements.length - elements.length, elements.length);
         start -= 32 * (newElements.length - elements.length);
         elements = newElements;

      } else if (n >= start + 32 * elements.length)
      {
         int intsNeeded = (n - start) / 32 + 1;
         elements = Arrays.copyOf(elements, Math.max(intsNeeded, 2 * elements.length));
      }
      int p = (n - start) / 32;
      int i = (n - start) % 32;
      if (!test(elements[p], i))
      {
         elementCount++;
         elements[p] = set(elements[p], i);
         modCount++;
      }
   }

   /**
    * Clears the element
    * 
    * @param n
    *           the element
    */
   public void clear(int n)
   {
      if (elements != null && n >= start || n < start + 32 * elements.length)
      {
         int p = (n - start) / 32;
         int i = (n - start) % 32;
         if (test(elements[p], i))
         {
            
            elementCount--;
            modCount++;
            elements[p] = clear(elements[p], i);
            
         }
      }
   }

   /**
    * Returns the min element in the set
    * 
    * @return the element
    */
   public int min()
   {
      if (elements != null)
         for (int p = 0; p < elements.length; p++)
            for (int i = 0; i < 32; i++)
               if (test(elements[p], i))
                  return 32 * p + i + start;
      return Integer.MAX_VALUE;
   }

   /**
    * Returns the max element in the set
    * 
    * @return the element
    */
   public int max()
   {
      if (elements != null)
         for (int p = elements.length - 1; p >= 0; p--)
            for (int i = 31; i >= 0; i--)
               if (test(elements[p], i))
                  return 32 * p + i + start;
      return Integer.MIN_VALUE;
   }

   /**
    * Returs the size
    * 
    * @return the size
    */
   public int size()
   {
      return elementCount;
   }

   /**
    * Test whether the element is present
    * 
    * @param n
    *           the element
    * @param i
    *           the bit
    * @return boolean value
    */
   private static boolean test(int n, int i)
   {
      assert 0 <= i && i < 32;
      return (n & (1 << i)) != 0;
   }

   /**
    * Sets the required bit
    * 
    * @param n
    *           the element
    * @param i
    *           the bit
    * @return int
    */

   private static int set(int n, int i)
   {
      assert 0 <= i && i < 32;
      return n | (1 << i);
   }

   /**
    * Clears the element
    * 
    * @param n
    *           the element
    * @param i
    *           the bit
    * @return int
    */

   private static int clear(int n, int i)
   {
      assert 0 <= i && i < 32;
      return n & ~(1 << i);
   }

   /**
    * A bitSet iterator
    * 
    * @author monil
    */

   class BitSetIterator implements Iterator<Integer>
   {
      int modCount;
      int nextIndex;
      boolean afterNext;

      /**
       * Class Constructor
       */
      public BitSetIterator()
      {
         modCount = BitSet.this.modCount;
         afterNext = false;
      }

      /**
       * Checks whether the set has a next element
       * 
       * @return boolean value
       */
      public boolean hasNext()
      {
         boolean after;
         if (nextIndex >= elementCount)
         {
            after = false;
         } else
         {
            after = true;
         }
         return after;
      }

      /**
       * Removes the element
       */

      public void remove()
      {

         if (this.modCount != BitSet.this.modCount)
            throw new ConcurrentModificationException();      
         if (afterNext == false)
         {
            throw new IllegalStateException();
         } else
         {
            int to_return = 0;
            for (int i = 0; i < 32; i++)
            {
               if (test(elements[nextIndex - 1], i))
               {
                  to_return = 32 * (nextIndex - 1) + i + start;
                  break;
               }
            }
            clear(to_return);
            this.modCount++;
            nextIndex--;
            afterNext = false;
         }
      }

      /**
       * Iterates to the next element
       * 
       * @return the next element
       */

      @Override
      public Integer next()
      {
         if (modCount != BitSet.this.modCount)
         {
            throw new ConcurrentModificationException();
         }
         int to_return = 0;
         for (int i = 0; i < 32; i++)
         {
            if (test(elements[nextIndex], i))
            {
               to_return = 32 * nextIndex + i + start;
            }
         }
         nextIndex++;
         afterNext = true;
         return to_return;

      }
   }

   /**
    * Method that deals with the iterator
    * 
    * @return the iterator
    */

   public Iterator<Integer> iterator()
   {
      return new BitSetIterator();
   }

}
