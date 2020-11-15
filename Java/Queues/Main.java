package com.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        var remove = queue.remove();
////        reverse(queue);
//        System.out.println(remove);

        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();
        var remove = queue.dequeue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);

        var peek = queue.peek();

        System.out.println(remove);
        System.out.println(queue);
        System.out.println(peek);
    }

    public static void reverse(Queue<Integer> queue) {
        // only use add, remove and isEmpty
        // make an empty stack
        Stack<Integer> stack = new Stack<>();
        // fill it up with int using while loop
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.empty())
            queue.add(stack.pop());


    }
}
