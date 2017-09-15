//import java.util.*;
//
//public class Prog1
//{
//   public static void main(String[] args)
//   {
//      Set<Point> set = new HashSet<>();
//      int n = 1000;
//      for (int i = 1; i <= n; i++)
//         for (int j = 1; j <= n; j++)
//            set.add(new Point(i % 2, j % 2));
//      System.out.println(set.size());
//   }
//}
//import java.util.*;
//
//public class Prog1
//{
//   public static void main(String[] args)
//   {
//      Set<Point> set = new HashSet<>();
//      int n = 1000;
//      for (int i = 1; i <= n; i++)
//         for (int j = 1; j <= n; j++)
//            set.add(new Point(i % 2, j % 2));
//      System.out.println(set.size());
//   }
//}

public class Prog1
{
   public static void main(String[] args)
   {
      LabeledPoint p1 = new LabeledPoint(3, 4, "Fred");
      LabeledPoint p2 = new LabeledPoint(3, 4, "Wilma");
//      p1 = p2;
//      
//      System.out.println(p1.equals(p2));
//      System.out.println(p1 == p2);
      Point p3 = new Point(3, 4);
      System.out.println(p1.equals(p3));
      System.out.println(p3.equals(p1));
   }
}