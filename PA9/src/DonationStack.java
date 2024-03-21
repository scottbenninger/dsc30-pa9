/*
 * Name: Scott Benninger
 * PID: A16991954
 */

import java.util.*;

/**
 * Parts E and F
 *
 * @author Scott Benninger
 * @since 03/19/2024
 */

public class DonationStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /**
     * Creates an instance of DonationStack
     */
    public DonationStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    /**
     * Pushes an element to the stack
     *
     * @param val valued being pushed
     */
    public void push(int val) {
        stack.push(val);
        if (maxStack.isEmpty() || val >= maxStack.peek()) {
            maxStack.push(val);
        }
    }

    /**
     * Finds the top element
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Pops the top element from the stack
     */
    public int pop() {
        if (stack.peek().equals(maxStack.peek())) {
            maxStack.pop();
        }
        return stack.pop();
    }

    /**
     * Gets the max element
     * @return the max element
     */
    public int max() {
        return maxStack.peek();
    }
}