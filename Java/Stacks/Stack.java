package com.Stacks;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    // push
    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();
        items[count++] = item;
    }

    //pop
    public int pop() {
        // check if it's empty
        if (count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    // to print
    @Override // to override the object class
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    //peek
    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[count-1];
    }

    //isEmpty
    public boolean isEmpty() {
        return count == 0;
    }
}
