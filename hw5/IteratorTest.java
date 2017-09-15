import static org.junit.Assert.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.junit.Test;

/**
 * Tests the Iterator implementation.
 */
public class IteratorTest
{
   /**
    * Tests setting a value.
    */
   @Test
   public void testOneElement()
   {
      BitSet set = new BitSet();
      set.set(100);
      set.set(102);
      set.set(150);
      set.set(200);
      set.set(250);
      BitSet.BitSetIterator iter = (BitSet.BitSetIterator) set.iterator();
      assertEquals(5, set.modCount);
      iter.next();
      iter.remove();
      iter.next();
      iter.remove();
      assertEquals(7, iter.modCount);
   }

   /**
    * Tests that the bits are set in the elements array
    */
   @Test(expected = ConcurrentModificationException.class)
   public void testBits()
   {
      BitSet set = new BitSet();
      set.set(100);
      set.set(102);
      set.set(150);
      set.set(200);
      set.set(250);
      set.set(300);
      Iterator<Integer> iter = set.iterator();
      assertTrue(iter.hasNext());
      iter.next();
      Iterator<Integer> iter2 = set.iterator();
      iter.remove();
      iter2.next();

   }

   /**
    * JUnit test for testing the solution
    */
   @Test(expected = IllegalStateException.class)
   public void arrayTset()
   {
      ArraySet set = new ArraySet();
      set.set(100);
      set.set(89);
      set.set(40);
      set.set(150);
      Iterator<Integer> iter = set.iterator();
      assertTrue(iter.hasNext());
      assertEquals((Integer) 100, iter.next());
      assertTrue(iter.hasNext());
      assertEquals((Integer) 89, iter.next());
      assertTrue(iter.hasNext());
      assertEquals((Integer) 40, iter.next());
      assertTrue(iter.hasNext());
      assertEquals((Integer) 150, iter.next());
      assertFalse(iter.hasNext());
      assertNull(iter.next());
      iter.next();
      iter.remove();
      iter.remove();
      assertNull(iter.next());

   }

   /**
    * JUnit test for testing the solution
    */

   @Test(expected = ConcurrentModificationException.class)
   public void modCountTest()
   {
      ArraySet set = new ArraySet();
      assertEquals(0, set.modCount);
      set.set(100);
      assertEquals(1, set.modCount);
      set.set(110);
      assertEquals(2, set.modCount);
      set.clear(100);
      assertEquals(3, set.modCount);
      set.clear(100);
      assertEquals(3, set.modCount);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      assertEquals(3, iter.modCount);
      iter.next();
      ArraySet.ArraySetIterator iter2 = (ArraySet.ArraySetIterator) set.iterator();
      assertEquals(3, iter2.modCount);
      iter.remove();
      assertEquals(4, set.modCount);
      assertEquals(4, iter.modCount);
      iter2.next();
   }

   /**
    * JUnit test for testing the solution
    */
   @Test
   public void removeTest2()
   {
      IntSet set = new ArraySet();
      set.set(100);
      set.set(99);
      set.set(1001);
      set.set(2000);
      Iterator<Integer> iter = set.iterator();
      iter.next();
      iter.next();
      iter.remove();
      iter.next();
      iter.next();
      iter.remove();
      iter = set.iterator();
      assertTrue(iter.hasNext());
      assertEquals((Integer) 100, iter.next());
      assertTrue(iter.hasNext());
      assertEquals((Integer) 2000, iter.next());
      assertFalse(iter.hasNext());
   }

   /**
    * JUnit test for testing the solution
    */
   @Test(expected = IllegalStateException.class)
   public void removeTestBit()
   {
      IntSet set = new BitSet();
      set.set(100);
      set.set(150);
      Iterator<Integer> iter = set.iterator();
      iter.next();
      iter.remove();
      iter.remove();

   }

   /**
    * JUnit test for testing the solution
    */
   @Test
   public void someOneElse()
   {
      ArraySet set = new ArraySet();
      set.set(100);
      set.set(102);
      set.set(200);
      set.set(500);
      set.set(1000);
      set.set(50);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      while (iter.hasNext())
      {
         int ele = iter.next();
         iter.remove();
      }
   }

   /**
    * JUnit test for testing the solution
    */
   @Test
   public void someOneElse1()
   {
      ArraySet set = new ArraySet();
      set.set(100);
      set.set(102);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      iter.next();
      iter.remove();
      iter.next();
      iter.remove();

   }
   @Test(expected = ConcurrentModificationException.class) public void modCountTest4()
   {
      ArraySet set = new ArraySet();
      assertEquals(0, set.modCount);
      set.set(100);
      assertEquals(1, set.modCount);
      set.set(110);
      assertEquals(2, set.modCount);
      set.clear(100);
      assertEquals(3, set.modCount);
      set.clear(100);
      assertEquals(3, set.modCount);
      ArraySet.ArraySetIterator iter = (ArraySet.ArraySetIterator) set.iterator();
      assertEquals(3, iter.modCount);
      iter.next();
      ArraySet.ArraySetIterator iter2 = (ArraySet.ArraySetIterator) set.iterator();
      assertEquals(3, iter2.modCount);
      iter.remove();
      assertEquals(4, set.modCount);
      assertEquals(4, iter.modCount);
      iter2.next();
   }
   @Test(expected = ConcurrentModificationException.class) public void concurrentMod3()
   {
      IntSet set = new BitSet();
      set.set(100);
      set.set(99);
      Iterator<Integer> iter = set.iterator();
      iter.next();
      Iterator<Integer> iter2 = set.iterator();
      iter2.next();
      iter.remove();
      iter2.next();
   }
}
