package com.tinkhub.algs4.searching;

import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;

import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> {
    private TreeMap<Key, Value> st;

    public ST() {
        st = new TreeMap<>();
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");

        return st.get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");

        if (val == null)    st.remove(key);
        else                st.put(key, val);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");

        st.remove(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");

        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return st.lastKey();
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("calls ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("calls floor() with null key");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public static void main(String[] args)
    {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
