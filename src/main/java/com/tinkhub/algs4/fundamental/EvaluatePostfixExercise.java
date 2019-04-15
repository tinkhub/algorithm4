package com.tinkhub.algs4.fundamental;

import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;

/**
 * 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard
 * input, evaluates it, and prints the value. (Piping the output of your program from
 * the previous exercise to this program gives equivalent behavior to Evaluate.
 */
public class EvaluatePostfixExercise {
    public static void main(String[] args)
    {
        Stack<Float> stack = new Stack<>();
        float left, right;
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("+")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left + right);
            }
            else if (str.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left - right);
            }
            else if (str.equals("*")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left * right);
            }
            else if (str.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left / right);
            }
            else {
                stack.push(Float.valueOf(str));
            }
        }
        StdOut.println(stack.pop());
    }
}
