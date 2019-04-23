package com.tinkhub.algs4.sorting;

import com.tinkhub.algs4.utils.In;
import com.tinkhub.algs4.utils.StdOut;

public class Example
{
    public static void sort(Comparable[] a)
    {

    }

    protected static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a)
    {
        for (int i=0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] a  = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
