package com.tinkhub.algs4.fundamental;

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;


    public FixedCapacityStackOfStrings(int cap)
    {
        a = new String[cap];
    }

    void push(String item)
    {
        a[N++] = item;
    }

    String pop()
    {
        return a[--N];
    }

    boolean isEmpty()
    {
        return N == 0;
    }

    boolean isFull()
    {
        return N == a.length;
    }

    int size()
    {
        return N;
    }


}
