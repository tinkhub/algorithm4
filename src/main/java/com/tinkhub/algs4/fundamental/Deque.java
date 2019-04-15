package com.tinkhub.algs4.fundamental;

import java.util.Iterator;

/**
 * Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends. A deque stores a collection
 * of items and supports the following API:
 * Write a class Deque that uses a doubly-linked list to implement this API
 */
public class Deque<Item> implements Iterable<Item>{
    private Node left;
    private Node right;
    private int N;

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    public boolean isEmpty() {
        return left == null;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        Node oldleft = left;
        left = new Node();
        left.item = item;
        left.next = oldleft;
        left.prev = null;
        oldleft.prev = left;
        if (right == null) right = left;
        N++;
    }

    public void pushRight(Item item) {
        Node oldright = right;
        right = new Node();
        right.item = item;
        right.next = null;
        right.prev = oldright;
        oldright.next = right;
        if (left == null) left = right;
        N++;
    }

    public Item popLeft() {
        Item item = left.item;
        left = left.next;
        if (left == null) right = null;
        else left.prev = null;
        N--;
        return item;
    }

    public Item popRight() {
        Item item = right.item;
        right = right.prev;
        if (right == null) left = null;
        else right.next = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<Item>
    {
        private Node current = left;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }


}
