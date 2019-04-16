package com.tinkhub.algs4.fundamental;

import org.omg.CORBA.Object;

import java.util.Iterator;

/**
 * Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends. A deque stores a collection
 * of items and supports the following API:
 * Write a class ResizingArrayDeque that uses a resizing array.
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a;
    private int left;
    private int right;
    private int N;

    public ResizingArrayDeque() {
        a = (Item [])new Object[2];
    }

    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[left--] = item;
        if (left < 0 ) left = a.length - 1;
        N++;
    }
    public Item popLeft() {
        left++;
        left = left % a.length;
        Item item = a[left];
        N--;
        return item;
    }
    public void pushRight(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[right++] = item;
        right = right % a.length;
        N++;
    }
    public Item popRight() {
        right--;
        if (right < 0) right = a.length - 1;
        Item item = a[right];
        N--;
        return item;
    }
    private void resize(int max) {
        Item[] temp = (Item[])new Object[max];
        for (int i=0; i<N; i++) {
            temp[i] = a[i%a.length];
        }
        a = temp;
        left = a.length - 1;
        right = N;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class DequeIterator implements Iterator<Item>
    {
        private int current = (left + 1) % a.length;
        private int rightIndex = right;

        @Override
        public boolean hasNext() {
            return left != rightIndex;
        }

        @Override
        public Item next() {
            Item item = a[current];
            current++;
            current = current % a.length;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
