package com.tinkhub.algs4.fundamental;

import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;

/**
 * Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced. For example,
 * your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class ParenthesesExercise {
    public static void main(String[] args)
    {
        String open = "[({";
        String close = "])}";
        Stack<Character> openParentheses = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            for (int i=0; i< item.length(); i++) {
                char c = item.charAt(i);
                if (open.indexOf(c) != -1) {
                    openParentheses.push(c);
                }
                else {
                    char saved = openParentheses.pop();
                    if (close.indexOf(c) != open.indexOf(saved)) {
                        StdOut.println("false");
                        return;
                    }
                }
            }
        }
        StdOut.println("true");
    }
}
