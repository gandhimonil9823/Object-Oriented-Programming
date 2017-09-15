import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Class that creates an arrayset
 * 
 * @author monil
 *
 */
public class ArraySet implements IntSet
{
   int smallest = Integer.MAX_VALUE;
   int largest = Integer.MIN_VALUE;
   int[] elements;
   int elementCount;
   int modCount;

   /**
    * Method that tests if the element exists
    * 
    * @param n
    *           the number
    * @return the booelan
    */
   public boolean test(int n)
   {
      if (n < smallest || n > largest)
         return false;
      for (int i = 0; i < elementCount; i++)
         if (elements[i] == n)
            return true;
      return false;
   }

   /**
    * Method that clears the element
    * 
    * @param n
    *           the element
    */
   public void clear(int n)
   {
      for (int i = 0; i < elementCount; i++)
         if (elements[i] == n)
         {
            elements[i] = elements[elementCount - 1];
            elementCount--;
            modCount++;
            if (n == smallest)
            {
               smallest = Integer.MAX_VALUE;
               for (int k = 0; k < elementCount; k++)
                  smallest = Math.min(elements[k], smallest);
            }
            if (n == largest)
            {
               largest = Integer.MIN_VALUE;
               for (int k = 0; k < elementCount; k++)
                  largest = Math.max(elements[k], largest);
            }
         }
   }

   /**
    * A method that sets the element
    * 
    * @param n
    *           the element
    */

   public void set(int n)
   {
      if (!test(n))
      {
         if (elements == null)
         {
            elements = new int[10];
         } else if (elements.length == elementCount)
         {
            elements = Arrays.copyOf(elements, 2 * elements.length);
         }
         elements[elementCount] = n;
         smallest = Math.min(smallest, n);
         largest = Math.max(largest, n);
         elementCount++;
         modCount++;
      }
   }

   /**
    * The min of the set
    * 
    * @return the min
    */
   public int min()
   {
      return smallest;
   }

   /**
    * the max of the set
    * 
    * @return the max
    */
   public int max()
   {
      return largest;
   }

   /**
    * returns the size
    * 
    * @return the size
    */
   public int size()
   {
      return elementCount;
   }

   /**
    * Class which deals with the itertor
    * 
    * @author monil
    */
   class ArraySetIterator implements Iterator<Integer>
   {
      int modCount;
      int nextIndex;
      boolean afterNext;

      /**
       * Constructor of the class
       */
      public ArraySetIterator()
      {
         modCount = ArraySet.this.modCount;
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
         if (afterNext == false)
         {
            throw new IllegalStateException();
         } else
         {
            elements[nextIndex - 1] = elements[elementCount - 1];
            nextIndex--;
            elementCount--;
         }
         modCount++;
         ArraySet.this.modCount++;
         afterNext = false;

      }

      /**
       * Iterates to the next element
       * 
       * @return the next element
       */

      public Integer next()
      {
         if (modCount != ArraySet.this.modCount)
         {
            throw new ConcurrentModificationException();
         }
         int num = 0;
         if (hasNext())
         {
            num = elements[nextIndex];
            nextIndex++;
         } 
         else
         {
            return null;
         }
         afterNext = true;
         return num;

      }

   }

   /**
    * Method that deals with the iterator
    * 
    * @return the iterator
    */
   public Iterator<Integer> iterator()
   {
      return new ArraySetIterator();
   }

}
