import java.util.Arrays;

public class ArraySet implements IntSet
{
   public boolean test(int n)
   {
      int p = Arrays.binarySearch(elements, 0, elementCount, n);
      return p >= 0;
   }
   
   public void clear(int n) 
   {
      int p = Arrays.binarySearch(elements, 0, elementCount, n);
      if (p >= 0)
      {
         System.arraycopy(elements, p + 1, elements, p, elementCount - p - 1);
         elementCount--;
      }
   }
   
   public void set(int n)
   {
      int p = elements == null ? -1 : Arrays.binarySearch(elements, 0, elementCount, n);
      if (p < 0)
      {
         p = -p - 1;
         if (elements == null)
         {
            elements = new int[10];
         }
         else if (elements.length == elementCount)
         {
            elements = Arrays.copyOf(elements, 2 * elements.length);
         }
         System.arraycopy(elements, p, elements, p + 1, elementCount - p);         
         elements[p] = n;
         elementCount++;
      }
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
   
   int[] elements;
   int elementCount;
}
