package com.Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    private int front;
    private int rear;
    private int count;


    // enqueue
    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear+1) % items.length;
        count++;
        System.out.println(count);
    }

    // dequeue
    public int dequeue() {
//        if (count == 0)
//            throw new IllegalStateException();
//        return items[front++];
//         for better readability
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        System.out.println(count);
        return item;
    }

    // peek
    public int peek() {
        // look at the very first item
        if (count == 0)
            throw new IllegalStateException();
        return items[front];
    }
    // isEmpty
    public boolean isEmpty() {
        return front == 0;
    }
    // isFull
    public boolean isFull() {
        return rear == items.length;
    }
    // to print
    @Override // to override the object class
    public String toString() {
        return Arrays.toString(items);
    }

}

