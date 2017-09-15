import java.util.Arrays;

/**
 * Represents a set but with an array implementation
 * 
 * @author monil
 *
 */
public class ArraySet implements IntSet
{
   // These are left package visible so they can be accessed in a unit test
   int smallest = Integer.MAX_VALUE;
   int largest = Integer.MIN_VALUE;
   int[] elements;
   int elementCount;

   /**
    * Constructor for the class
    */
   public ArraySet()
   {
      elements = new int[10];
      elementCount = 0;
   }

   /**
    * Test whether the element is present in the array
    * 
    * @param n
    *           the input value
    * @return the boolean value
    */
   public boolean test(int n)
   {
      if (n < smallest || n > largest) return false;
      for (int i = 0; i < elementCount; i++)
      {
         if (elements[i] == n)
         {
            return true;
         }
      }
      return false;
   }

   /**
    * Clears the value i the array
    * 
    * @param n
    *           the input value
    */
   public void clear(int n)
   {
      int last_element = elements[elementCount - 1];
      for (int i = 0; i < elements.length; i++)
      {
         if (elements[i] == n)
         {

            elements[i] = last_element;
         }
      }
      elementCount--;

      if (n == largest)
      {
         if (n == elements[elementCount])
         {
            largest = elements[0];
            for (int i = 0; i < elementCount; i++)
            {
               if (elements[i] > largest)
               {
                  largest = elements[i];
               }
            }
         } else
         {
            // largest = smallest;
            largest = elements[0];
            for (int i = 0; i < elements.length; i++)
            {

               if (elements[i] > largest)
               {
                  largest = elements[i];
               }
            }
         }
      }

      else if (n == smallest)
      {
         smallest = elements[0];
         if (n == elements[elementCount])
         {
            for (int i = 0; i < elementCount; i++)
            {
               if (elements[i] < smallest)
               {
                  smallest = elements[i];
               }
            }
         } else
         {
            smallest = elements[0];
            for (int i = 0; i < elementCount; i++)
            {
               if (elements[i] < smallest)
               {
                  smallest = elements[i];
               }
            }
         }
      }

   }

   /**
    * Sets the value in the array
    * 
    * @param n
    *           the input value
    */

   public void set(int n)
   {
      if (test(n))
      {
         return;
      }

      if (elementCount == 0)
      {
         largest = n;
         smallest = n;
      }
      if (n > largest)
      {
         largest = n;
      }
      if (n < smallest)
      {
         smallest = n;
      }
      if (elements.length == elementCount)
      {
         extendArray();
      }
      elements[elementCount] = n;
      elementCount++;

   }

   /**
    * Method to extend the array when it is full
    */
   public void extendArray()
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
    * Return the min of the array
    * 
    * @return the min
    */
   public int min()
   {
      return smallest;
   }

   /**
    * Return the max of the array
    * 
    * @return the max
    */
   public int max()
   {
      return largest;
   }

   /**
    * Gives the size of the array
    * 
    * @return the size
    */
   public int size()
   {
      return elementCount;
   }

}
