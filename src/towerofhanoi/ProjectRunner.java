// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

public class ProjectRunner {

    /**
     * The main method that runs the entire project.
     */
    public static void main(String[] args) {
        int discs = 10;
        if (args.length == 1) {
            discs = Integer.parseInt(args[0]);
        }

        HanoiSolver solver = new HanoiSolver(discs);
        GameWindow gameW = new GameWindow(solver);

    }
}
