package com.tinkhub.algs4.fundamental;

import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;

public class FixedCapacityStackOfStringsClient {
    public static void main(String[] args)
    {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);

        StdOut.println("*** FixedCapacityStackOfStringsClient 01 ");
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals(("-")))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
