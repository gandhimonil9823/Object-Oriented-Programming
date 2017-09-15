import java.util.*;

public class Encoding
{
	public static Set<String> morseCodes(int m, int n)
	{
		Set<String> result = new TreeSet<>();
		if (m==0 && n==0)
		{
			result.add("");
		}
		else if (m==0)
		{
			for (String string : morseCodes(m,n-1))
			{
				result.add(string +"-");
			}
		}
		else if (n==0)
		{
			for (String string : morseCodes(m-1,n))
			{
				result.add(string + ".");
		    }
		}
		else
		{
			for (String string : morseCodes(m-1,n))
			{ 
				result.add(string +".");
			}
			for (String string : morseCodes(m,n-1))
			{
				result.add(string +"-");
		    }
	     }
	   return result;
	}

	public static void main(String args[])
	{
		Encoding k = new Encoding();
		Set<String> morse = Encoding.morseCodes(2, 1);
		System.out.println(morse);
	}
}
