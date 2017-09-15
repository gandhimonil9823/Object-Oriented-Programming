import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import junit.framework.TestCase;

public class SortedArrayTest 
{
   @Test public void testOneElement()
   {   
   ArraySet set = new ArraySet();
   set.set(40);
   set.set(110);
   set.set(90);
   set.clear(110);
   set.clear(90);
   assertTrue(set.test(40));
   assertFalse(set.test(110));
   assertTrue(set.test(200));
   

}
   @Test public void testOneElement1()
   {   
   ArraySet set = new ArraySet();
   set.set(40);
   set.set(110);
   set.set(90);
   set.set(70);
   set.clear(110);
   set.clear(90);
   assertEquals(40, set.elements[0]);
   assertEquals(70, set.elements[1]);
   

}
}
