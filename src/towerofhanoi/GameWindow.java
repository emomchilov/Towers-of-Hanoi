// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;

/**
 * Creates a GameWindow to graphically display
 * the Hanoi Tower solution.
 * 
 * 
 * @author meden97
 * @version 2018.07.10
 *
 */
public class GameWindow implements Observer {

    private Window window;
    private Shape left;
    private Shape middle;
    private Shape right;
    private HanoiSolver game;
    private final int DISC_GAP = 0;
    public static final int DISC_HEIGHT = 20;


    /**
     * Creates a pause in the animation.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * The clicked solve method.
     * 
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * This moves the disc from one position to the next.
     * 
     * @param position
     */
    private void moveDisc(Position position) {
        Disc currentDisc = game.getTower(position).peek();
        Shape currentPole = null;

        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }

        int newX = (currentPole.getX() + (currentPole.getWidth() / 2
            - currentDisc.getWidth() / 2));
        int newY = currentPole.getHeight() - (game.getTower(position).size()
            * DISC_HEIGHT);

        System.out.println(currentPole.getX());
        System.out.println(currentPole.getY());

        currentDisc.moveTo(newX, newY);
    }


    /**
     * The constructor for game window.
     */
    public GameWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);

        window = new Window("Tower of Hanoi");
        window.setSize(500, 500);
        int x = window.getWidth() / 4;
        left = new Shape(x, window.getHeight(), 2, window
            .getHeight() / 2, Color.BLACK);
        middle = new Shape(x * 2, window.getGraphPanelHeight(), 2,
            window.getHeight() / 2, Color.BLACK);
        right = new Shape(x * 3, game.getTower(Position.RIGHT).size(), 2, window
            .getHeight() / 2, Color.BLACK);
        for (int i = game.discs(); i > 0; i--) {
            Disc newDisc = new Disc(i * 15);
            window.addShape(newDisc);
            game.getTower(Position.LEFT).push(newDisc);
            moveDisc(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(right);
        window.addShape(middle);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * Method that updates after each move.
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisc((Position)arg);
            sleep();
        }
    }

}
