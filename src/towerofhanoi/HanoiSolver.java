// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

import java.util.Observable;

/**
 * This class provides the solution to
 * solve the Hanoi Towers.
 * 
 * @author meden97
 * @version 2018.18.10
 *
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDiscs;


    /**
     * The constructor for the HanoiSolver class.
     * 
     * @param discs
     *            number of discs
     */
    public HanoiSolver(int discs) {
        numDiscs = discs;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * Returns the number of discs.
     * 
     * @return int number of discs
     */
    public int discs() {
        return numDiscs;
    }


    /**
     * Returns the tower position.
     * 
     * @param pos
     *            position
     * @return Tower tower at specified position
     */
    public Tower getTower(Position pos) {
        Tower currTower = null;
        switch (pos) {
            case LEFT:
                currTower = left;
                break;
            case MIDDLE:
                currTower = middle;
                break;
            case RIGHT:
                currTower = right;
                break;
            default:
                currTower = left;
                break;
        }
        return currTower;
    }


    /**
     * Returns a string representation of the towers and
     * their widths.
     * 
     * @return String string object
     */
    public String toString() {

        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Executes the specified move from the Tower
     * source to the Tower destination.
     */
    private void move(Tower source, Tower destination) {
        Disc moveDisc = source.pop();
        destination.push(moveDisc);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Solves towers using recursion.
     */
    private void solveTowers(
        int currentDiscs,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDiscs == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the Towers using recursion provided
     * the correct parameters.
     */
    public void solve() {
        solveTowers(this.discs(), left, middle, right);
    }

}
