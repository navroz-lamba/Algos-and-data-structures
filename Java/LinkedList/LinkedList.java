package com.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }


    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        // if it's empty
        if (isEmpty())
            first = last = node;
        // if node exists
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // deleteFirst
    public void removeFirst() {

        if (isEmpty())
            throw new NoSuchElementException();

        // if there is only 1
        if (first == last)
            first = last = null;

        else {
            var second = first.next;
            first.next = null;
            second = first;
        }
        size--;
    }

    // deleteLast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;

    }


    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    // indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            else {
                current = current.next;
                index++;
            }

        }
        return -1;
    }
    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current!=null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) return;
        // [ 10 -> 20 -> 30]
        // we will set pointers previous, current and next
        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        last = first;
        last.next = null;
        first = previous;

    }

    // Find the Kth node from the end of
    // the linked list in one pass
    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalArgumentException();

        var a  = first;
        var b = first;
        // now we move the b until a and b are k-1 apart
        for (int i = 0; i < k - 1 ;i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

}
