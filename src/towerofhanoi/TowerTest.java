// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity
// at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- meden97

package towerofhanoi;

/**
 * Tests the methods in the Tower class.
 * 
 * 
 * @author meden97
 * @version 2018.07.10
 *
 */
public class TowerTest extends student.TestCase {

    private Tower left;
    private Tower right;
    private Tower middle;


    /**
     * Sets up the test methods.
     */
    public void setUp() {
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * Tests the position() method to see if
     * it returns the towers position.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, left.position());
        assertEquals(Position.RIGHT, right.position());
        assertEquals(Position.MIDDLE, middle.position());
    }


    /**
     * Tests that the push(disc) method pushes a disc
     * on top of the stack, including exceptions.
     */
    public void testPush() {
        Exception exception = null;
        try {
            left.push(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("stack() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        Disc disc = new Disc(3);
        Disc discLarge = new Disc(6);
        Disc discSmall = new Disc(1);

        left.push(disc);
        assertEquals(1, left.size());

        left.push(discSmall);
        assertEquals(2, left.size());

        Exception exception1 = null;
        try {
            left.push(discLarge);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception1 = e;
        }
        assertTrue("stack() is throwing the wrong type of exceptions",
            exception1 instanceof IllegalStateException);

    }
}
