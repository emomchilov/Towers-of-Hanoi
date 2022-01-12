// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

import CS2114.Shape;
import java.awt.Color;
import java.util.Random;

/**
 * Creates disk objects.
 * 
 * 
 * @author meden97
 * @version 2018.07.10
 *
 */
public class Disc extends Shape implements Comparable<Disc> {

    /**
     * The constructor for the disk object. Sets the location,
     * size, and color.
     * 
     * @param width
     *            int width
     */
    public Disc(int width) {
        super(0, 0, width, GameWindow.DISC_HEIGHT);
        Random gen = new Random();
        Color col = new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(
            255));
        setBackgroundColor(col);
    }


    /**
     * Overrides the compareTo method to determine the relative size of
     * the discs.
     */
    @Override
    public int compareTo(Disc otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        return 0;
    }


    /**
     * This method returns the width of the disk as a string.
     * 
     * @return String
     */
    public String toString() {
        int w = this.getWidth();
        return Integer.toString(w);
    }


    /**
     * This method overrides the equals method.
     * 
     * @param obj
     *            object
     * @return boolean
     */
    public boolean equals(Object obj) {
        // checks if null
        if (obj == null) {
            return false;
        }

        // checks if same class
        if (obj.getClass() != Disc.class) {
            return false;
        }

        // checks if same width
        return ((Shape)obj).getWidth() == this.getWidth();
    }
}
