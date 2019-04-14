package com.tinkhub.algs4.fundamental;


import com.tinkhub.algs4.utils.StdIn;
import com.tinkhub.algs4.utils.StdOut;


/**
 * 1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix
 * to postfix.
 *     Infix String : a+b*c-d
 *     Postfix String : abc*+d-
 *     Infix String : 3+4*5/6
 *     Postfix String : 3 4 5 * 6 / +
 *     Infix String : (300+23)*(43-21)/(84+7)
 *     Postfix String : 300 23 + 43 21 - * 84 7 + /
 *     Infix String : (4+8)*(6-5)/((3-2)*(2+2))
 *     Postfix String : 4 8 + 6 5 - * 3 2 – 2 2 + * /
 */
public class InfixToPostfixExercise {

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            input.append(str).append(" ");
        }
        InfixToPostfixExercise infixToPostfix = new InfixToPostfixExercise();
        String postfix = infixToPostfix.infixToPostfix(input.toString());
        StdOut.println(postfix);
    }

    public String infixToPostfix(String infix) {
        Parenthesizer parenthesizer = new Parenthesizer(infix);
        String parenthesized = parenthesizer.toParenthesized();
        Stack<String> stack = new Stack<>();
        StringBuilder pfBuilder = new StringBuilder();
        for (String str: parenthesized.split("\\s+")) {
            if      (str.equals("+") || str.equals("-")) stack.push(str);
            else if (str.equals("*") || str.equals("/")) stack.push(str);
            else if (str.equals(")")) pfBuilder.append(stack.pop()).append(" ");
            else if (!str.equals("(")) pfBuilder.append(str).append(" ");
        }
        return pfBuilder.toString();
    }

    private class Parenthesizer
    {
        private String infix;
        private int length;
        private int pos;

        private Parenthesizer(String infix)
        {
            this.infix = infix;
            this.length = infix.length();
        }

        public String toParenthesized() {
            return this.parethesizeOnce();
        }
        private String oneFromStack(Stack<String> onceStack) {
            if (onceStack.size() == 1) return onceStack.pop();
            if (onceStack.size() > 2) {
                String right = onceStack.pop();
                String op = onceStack.pop();
                String left = onceStack.pop();
                return String.format("( %s %s %s )", left, op, right);
            }

            return "";
        }
        private String parethesizeOnce() {
            StringBuilder digitBuilder = new StringBuilder();
            Stack<String> onceStack = new Stack<>();
            while (this.pos < this.length) {
                char c = infix.charAt(this.pos++);
                String right, op, new_str;
                if (Character.isDigit(c)) {
                    digitBuilder.append(c);
                    continue;
                }
                if (digitBuilder.length() > 0) {
                    right = digitBuilder.toString();
                    if (!onceStack.isEmpty())
                        op = onceStack.peek();
                    else op = "";
                    onceStack.push(right);
                    if (op.equals("*") || op.equals("/")) {
                        new_str = this.oneFromStack(onceStack);
                        onceStack.push(new_str);
                    }
                    digitBuilder.setLength(0);
                }
                if (c == '+' || c == '-') {
                    if (onceStack.size() > 2) {
                        new_str = this.oneFromStack(onceStack);
                        onceStack.push(new_str);
                    }
                    onceStack.push(String.valueOf(c));
                }
                else if (c == '*' || c == '/') {
                    onceStack.push(String.valueOf(c));
                }
                else if (c == '(') {
                    right = this.parethesizeOnce();
                    if (!onceStack.isEmpty())
                        op = onceStack.peek();
                    else op = "";
                    onceStack.push(right);
                    if (op.equals("*") || op.equals("/")) {
                        new_str = this.oneFromStack(onceStack);
                        onceStack.push(new_str);
                    }
                }
                else if (c == ')') {
                    break;
                }
            }
            if (digitBuilder.length() > 0) {
                onceStack.push(digitBuilder.toString());
            }
            return this.oneFromStack(onceStack);
        }
    }

}
