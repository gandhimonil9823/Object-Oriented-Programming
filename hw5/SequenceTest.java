import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Class to test the IntSequence
 * 
 * @author monil
 */
public class SequenceTest
{
   /**
    * Tests setting a value.
    */
   @Test
   public void testSequence()
   {
      ArraySet set = new ArraySet();
      set.set(100);
      set.set(102);
      set.set(104);
      set.set(105);
      set.set(106);
      set.set(107);
      set.set(108);
      set.set(109);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      Integer r = 100;

      assertEquals((int) IntSequence.fromIterator(iter).next(), (int) r);
      Integer e = 102;
      assertEquals((int) IntSequence.fromIterator(iter).next(), (int) e);
      // assertEquals(IntSequence.alternate()).)
      Integer w = null;
      // assertEquals((int)IntSequence.fromIterator(iter).next(),(int)w);

   }

   /**
    * Tests setting a value.
    */
   @Test
   public void testSequence4()
   {

      ArraySet set = new ArraySet();
      set.set(90);
      set.set(10);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      Integer r = 90;
      assertEquals((int) IntSequence.fromIterator(iter).next(), (int) r);
      Integer e = 10;
      assertEquals((int) IntSequence.fromIterator(iter).next(), (int) e);

   }
}
