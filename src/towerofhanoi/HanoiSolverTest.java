// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

/**
 * Tests the methods in the Hanoi
 * Solver class.
 *
 * @author meden97
 * @version 2018.07.10
 *
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver solver;


    /**
     * Sets up the test cases for HanoiSolver.
     */
    public void setUp() {
        solver = new HanoiSolver(5);

    }


    /**
     * Tests the constructor for the HanoiSolver class.
     */
    public void testHanoiSolver() {
        assertEquals(5, solver.discs());
    }


    /**
     * Tests the get discs method.
     */
    public void testDiscs() {
        assertEquals(5, solver.discs());
    }


    /**
     * Tests the getTower(pos) method to see if Hanoi
     * Tower returns the tower at a given position.
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
        assertEquals(Position.RIGHT, solver.getTower(Position.RIGHT)
            .position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.LEFT, solver.getTower(Position.OTHER).position());
    }


    /**
     * Tests the string builder for the Hanoi Solver.
     */
    public void testToString() {
        Disc disc = new Disc(3);
        Disc disc1 = new Disc(2);
        Disc disc2 = new Disc(1);

        solver.getTower(Position.LEFT).push(disc2);
        solver.getTower(Position.MIDDLE).push(disc1);
        solver.getTower(Position.RIGHT).push(disc);

        assertEquals("[1][2][3]", solver.toString());
    }


    /**
     * Tests the solve method for the Hanoi class.
     */
    public void testSolve() {

        Disc disc = new Disc(3);
        Disc disc1 = new Disc(2);
        Disc disc2 = new Disc(1);
        Disc disc3 = new Disc(4);
        Disc disc4 = new Disc(5);

        solver.getTower(Position.LEFT).push(disc4);
        solver.getTower(Position.LEFT).push(disc3);
        solver.getTower(Position.LEFT).push(disc);
        solver.getTower(Position.LEFT).push(disc1);
        solver.getTower(Position.LEFT).push(disc2);
        solver.solve();
        assertEquals(5, solver.getTower(Position.RIGHT).size());
    }
}
