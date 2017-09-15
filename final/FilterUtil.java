import java.util.ArrayList;
import java.util.List;

public class FilterUtil
{
   public static <T> int count(List<T> values, Filter<? super T> filter) // Because Object being the superclass of Country(Any class) we need to specify that the generic value T is the super class of the any class.
   //It is called the wildcard implementation and can be read as "Anything that is a T(generic) or is more specific(Subclass) 
   {
      int counter = 0;;
      for (int i = 0; i < values.size(); i++)
         if (filter.accept(values.get(i))) counter++;
      return counter;
   }
//   public static void main(String[] args)
//   {
//      
//      ArrayList<Country> countries = new ArrayList<>();
//      countries.add(new Country("Uruguay", 176220));
//      countries.add(new Country("Thailand", 514000));
//      countries.add(new Country("Belgium", 30510));
//      Filter<Country> bigCountry = c -> c.getArea() > 500000;
//      //int result = FilterUtil.count(countries, bigCountry);
//      Filter<Object> evenHashCode = obj -> obj.hashCode() % 2 == 0;
//      int result = FilterUtil.count(countries, evenHashCode);
//   }
}