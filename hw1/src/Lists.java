import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lists
{
	public static void swapLargestAndSecondSmallest(ArrayList<Integer> a)
	{
		int small = 0;
		int secondSmallest = 1;
		int numLarge = 0;
		Set<Integer> duplicate = new HashSet<Integer>(a);
	    if(duplicate.size() == 1)
	    {
	    	return;
	    }
		
		for (int i = 2; i < a.size(); i++)
		{ 
			if(a.get(i) > a.get(small) && a.get(i) < a.get(secondSmallest))
			{
				secondSmallest = i;
			}
			else if(a.get(i) < a.get(small) && a.get(i) < a.get(secondSmallest))
			{
				small = i;
			}
			if(a.get(i) > a.get(numLarge))
			{
				numLarge = i;
			}
		}
		Collections.swap(a, secondSmallest,numLarge);
	}
}
