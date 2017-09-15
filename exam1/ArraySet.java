import java.util.Arrays;

public class ArraySet implements IntSet
{
   public boolean test(int n)
   {
      if (n < smallest || n > largest) return false;
      for (int i = 0; i < elementCount; i++)
         if (elements[i] == n) return true;
      return false;
   }
   
   public void clear(int n) 
   {
      for (int i = 0; i < elementCount; i++)
      {
         if (elements[i] == n) 
         {
            elements[i] = elements[elementCount - 1];
            elementCount--;   
         }
        // System.arraycopy(elements, p + 1, elements, p, elements.length-1);
      }
      
   }
   
   public void set(int n)
   {
//      if (!test(n))
//      {
//         if (elements == null)
//         {
//            elements = new int[10];
//         }
//         else if (elements.length == elementCount)
//         {
//            elements = Arrays.copyOf(elements, 2 * elements.length);
//         }
//         elements[elementCount] = n;
//         smallest = Math.min(smallest, n);
//         largest = Math.max(largest, n);
//         elementCount++;
//      }
      int p = Arrays.binarySearch(elements, 0, elementCount, n);
      if (p >= 0)
      {
         elements[p] = n;
         // n is present in elements[p]
      }
      else
      {
         p = -p - 1;
         elements[p] = n;
         // n needs to be inserted before p
      }
      System.arraycopy(elements, p, elements, p + 1, elements.length + 1);
   }
   
      public int min()
      {
         return elementCount == 0 ? Integer.MAX_VALUE : elements[0];
      }
         
      public int max()
      {
         return elementCount == 0 ? Integer.MIN_VALUE : elements[elementCount - 1];
      }

   public int size()
   {
      return elementCount;
   }
   int smallest = Integer.MAX_VALUE;
   int largest = Integer.MIN_VALUE;
   
   int[] elements;
   int elementCount;
}
