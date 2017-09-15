
public class Arrays
{
   public static void swapLargestAndSmallest(int[] a)
   {
      int imax = 0 ;
      int imin = 0;
      
      
      for(int i = 1; i< a.length;i++)
      {
        if(a[imax] < a[i])
        {
          imax = i;
        }
        if(a[imin] > a[i])
        {
          imin = i;
        }
       
   }
   int l = a[imin];
  a[imin] = a[imax];
  a[imax] = l;
  
   }
   
}