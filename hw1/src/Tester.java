import java.util.ArrayList;
import java.util.Arrays;

public class Tester
{
   public static ArrayList<Integer> list(int... values)
   {
      ArrayList<Integer> result = new ArrayList<>();
      for (int v : values) result.add(v);
      return result;
   }
   

   public static void main(String[] args)
   {
      ArrayList<Integer> a = list(5, 4, 1, 9, 2, 6);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [5, 4, 1, 2, 9, 6]");
      a = list(1, 4, 1, 9, 2, 6);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [1, 4, 1, 2, 9, 6]");
      a = list(1, 4, 2, 9, 2, 6);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [1, 4, 9, 2, 2, 6]");
      a = list(9, 4, 2, 9, 4, 6);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [4, 9, 2, 9, 4, 6]");
      a = list(1, 4, 1, 4, 1, 4);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [1, 4, 1, 4, 1, 4]");
      a = list(1, 1, 1, 1, 1, 1);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [1, 1, 1, 1, 1, 1]");      
      a = list(1);
      Lists.swapLargestAndSecondSmallest(a);
      System.out.println(a);
      System.out.println("Expected: [1]");      
   }
}