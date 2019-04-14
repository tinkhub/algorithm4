package com.tinkhub.algs4.fundamental;

import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;

/**
 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For
 * example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */
public class ParenthesesInfixExercise {
    public static void main(String[] args)
    {
        Stack<String> values = new Stack<>();
        Stack<String> ops = new Stack<>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("+") || str.equals("-") || str.equals("*")) {
                ops.push(str);
            }
            else if (str.equals(")")) {
                String val2 = values.pop();
                String op = ops.pop();
                String val1 = values.pop();
                String new_str = "( " + val1 + " " + op
                        + " " + val2+ " )";
                values.push(new_str);
            }
            else {
                values.push(str);
            }
        }
        StdOut.println(values.pop());
    }
}
