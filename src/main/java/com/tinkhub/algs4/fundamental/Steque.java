package com.tinkhub.algs4.fundamental;

import java.util.Iterator;

/**
 * 1.3.32 Steque. A stack-ended queue or steque is a data type that supports push, pop, and
 * enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Steque<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (last == null) last = first;
        N++;
    }

    public Item pop() {
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null) first = last;
        else oldlast.next = last;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
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
