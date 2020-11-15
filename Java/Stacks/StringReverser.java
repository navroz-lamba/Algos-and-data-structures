package com.Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        Stack<Character> stack = new Stack<>();

//        for (int i=0; i < input.length(); i++)
//            stack.push(input.charAt(i));

        // cleaner way
        for (char ch: input.toCharArray())
            stack.push(ch);

//        String reversed = "";
//        while (!stack.empty())
//            reversed += stack.pop();

        // Better way to efficiency
        // strings are immutable in java
        // and every new string will be new
        // memory allocated to it

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();


    }

    }


