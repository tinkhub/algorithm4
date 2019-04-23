package com.tinkhub.algs4.sorting;

import com.tinkhub.algs4.utils.In;

public class Insertion extends Example
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i=1; i<N; i++) {
            for (int j=i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args)
    {
        String[] a  = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
