// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

/**
 * This provides the class for the towers that
 * hold the disc objects.
 * 
 * @author meden97
 * @version 2018.19.10
 *
 */
public class Tower extends LinkedStack<Disc> {

    private Position position;


    /**
     * The constructor for the Tower class that
     * takes position as a parameter.
     * 
     * @param p position
     */
    public Tower(Position p) {
        super();
        position = p;
    }


    /**
     * Returns the tower's position.
     * 
     * @return Position returns position
     */
    public Position position() {
        return position;
    }


    /**
     * This method will push a new entry on top of the stack.
     */
    @Override
    public void push(Disc disc) {
        if (disc == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty() || disc.compareTo(this.peek()) == -1) {
            super.push(disc);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
