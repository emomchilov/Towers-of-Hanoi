// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- meden97

package towerofhanoi;

import java.util.EmptyStackException;

/**
 * This class tests the methods in the Linked Stack
 * class.
 * 
 * @author meden97
 * @version 2018.18.10
 *
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<String> stack;


    /**
     * Sets up the test cases.
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }


    /**
     * Tests the LinkedStack constructor.
     */
    public void testLinkedStack() {
        assertEquals(0, stack.size());
    }


    /**
     * Tests the size method.
     */
    public void testSize() {
        // with size 0
        assertEquals(0, stack.size());

        // with size 3
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals(3, stack.size());

    }


    /**
     * Tests the isEmpty() method to see that it returns
     * true when empty and false when it contains objects.
     */
    public void testIsEmpty() {
        // when empty
        assertTrue(stack.isEmpty());

        // when not empty
        stack.push("one");
        assertFalse(stack.isEmpty());
    }


    /**
     * Tests that the clear() method clears the list when called.
     */
    public void testClear() {
        stack.clear();
        assertEquals(0, stack.size());

        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertEquals(3, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }


    /**
     * Tests the toString() method to see if it returns
     * a string representation of the stack.
     */
    public void testToString() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("[three, two, one]", stack.toString());
    }


    /**
     * Tests the peek method to see if it shows the top entry.
     */
    public void testPeek() {
        Exception exception = null;
        try {
            stack.peek();
            fail("stack() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("stack() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.peek());
    }


    /**
     * Tests the pop() method to see if it removes the top
     * item in the stack and returns its data.
     */
    public void testPop() {
        Exception exception = null;
        try {
            stack.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals(3, stack.size());
        assertEquals("three", stack.pop());
        assertEquals(2, stack.size());
    }


    /**
     * Tests the push(anEntry) method to see if it adds
     * an entry to the top of the stack.
     */
    public void testPush() {
        stack.push("one");
        assertEquals(1, stack.size());
    }
}
