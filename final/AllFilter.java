import java.util.ArrayList;

public class AllFilter<T> implements Filter<T>
{
   ArrayList<Filter> filter;
   
    public AllFilter()
   {
    filter = new ArrayList<>();  
      // TODO Auto-generated constructor stub
   }
    public  void add(Filter<? super T> fill)
    {
       if(accept((T) fill))
       {
          filter.add(fill);
       }
       else
       {
          return;
       }
       
       
    }
   @Override
   public boolean accept(T element)
   {
      String s = (String) element;
      if(s.length() == 3)
      {
         return true;
      }
      else if(s.charAt(0) == 'C')
      {
         return true;
      }
      else
      {
         return false;
      }
   }
  
}