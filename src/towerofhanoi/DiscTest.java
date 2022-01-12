// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who
// do.
// -- meden97

package towerofhanoi;

/**
 * This class tests the disc class.
 * 
 * @author meden97
 * @version 2018.07.10
 *
 */
public class DiscTest extends student.TestCase {

    private Disc disc;
    private Disc discSame;
    private Disc discHigher;
    private Disc discLower;


    /**
     * Set up method.
     */
    public void setUp() {
        disc = new Disc(3);
        discSame = new Disc(3);
        discHigher = new Disc(6);
        discLower = new Disc(1);
    }


    /**
     * Tests the constructor for the disc class to see if
     * it generates a random color.
     */
    public void testConstructor() {

        // tests that the color is set
        assertEquals(0, disc.getX());
        assertEquals(0, disc.getY());
        assertEquals(3, disc.getWidth());
    }


    /**
     * Tests that the compareTo() method returns the correct int value
     * (-1, 0, 1) depending on width size.
     */
    public void testCompareTo() {

        // illegal argument excepetion
        Exception exception = null;

        try {
            disc = null;
            discSame.compareTo(disc);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        disc = new Disc(3);
        // disc is smaller
        assertEquals(-1, discLower.compareTo(disc));

        // disc is same
        assertEquals(0, disc.compareTo(discSame));

        // disc is bigger
        assertEquals(1, discHigher.compareTo(disc));
    }


    /**
     * Tests that the toString method returns the width of the disc as a string.
     */
    public void testToString() {
        assertEquals("3", disc.toString());
        assertEquals("6", discHigher.toString());
        assertEquals("1", discLower.toString());
    }


    /**
     * Tests that the overidden equals method returns true or false depending
     * on the equality of the object compared.
     */
    public void testEquals() {

        // on a null object
        Object nullObject = null;
        assertFalse(disc.equals(nullObject));

        // on an object of a different class
        Object notDisc = new Object();
        assertFalse(disc.equals(notDisc));

        // with the same width
        assertTrue(disc.equals(discSame));
    }

}
