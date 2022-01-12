// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- meden97

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Provides the methods for the linked stack.
 * 
 * 
 * @author meden97
 * @version 2018.07.10
 * 
 * @param <T>
 *            T object
 *
 */
public class LinkedStack<T> implements StackInterface<T> {

    /**
     * Creates a Node class inside the LinkedStack class.
     * 
     * @author meden97
     * @param <T>
     */
    public static class Node<T> {

        private Node<T> next;
        private T data;


        /**
         * Constructor for Node class. Sets both data and
         * nextNode fields upon creation.
         * 
         * @param d
         *            data
         */
        Node(T d) {
            data = d;
        }


        /**
         * Sets the next node in the list.
         * 
         * @param n
         *            next node
         */
        public void setNextNode(Node<T> n) {
            next = n;
        }


        /**
         * Gets the next node in the list.
         * 
         * @return Node<T> next
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * Gets the data value of the node.
         * 
         * @return T data
         */
        public T getData() {
            return data;
        }
    }

    private Node<T> topNode;
    private int size;


    /**
     * The constructor for the LinkedStack class.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Returns the size of the Linked Stack.
     * 
     * @return int size
     */
    public int size() {
        return size;
    }


    /**
     * Returns true when the size = 0, false if there
     * are elements in the Linked Stack.
     * 
     * @return boolean true/false
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Clears the Linked Stack.
     */
    public void clear() {
        if (topNode != null) {
            topNode.setNextNode(null);
            topNode = null;
            size = 0;
        }
    }


    /**
     * Returns a string representation of the stack.
     * 
     * @return String
     */
    public String toString() {
        String result = "[";

        Node<T> current = topNode;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }


    /**
     * This method shows the top of the existing stack.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return topNode.data;
    }


    /**
     * This method removes the top node in the stack
     * and returns its data.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> current;
        current = topNode;
        topNode = topNode.getNextNode();
        size--;
        return current.getData();
    }


    /**
     * This method will push a new entry on top of the stack.
     */
    @Override
    public void push(T anEntry) {
        Node<T> temp = new Node<T>(anEntry);
        temp.setNextNode(topNode);
        topNode = temp;
        size++;
    }
}
