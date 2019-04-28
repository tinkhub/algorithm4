package com.tinkhub.algs4.sorting;

import com.tinkhub.algs4.utils.In;

public class Shell extends Example
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3)
            h = 3*h + 1;
        while (h >= 1)
        {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
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
