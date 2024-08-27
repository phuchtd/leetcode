package org.example.easy;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("(){}}{"));
        System.out.println(isValid("[])"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else {
                if (stack.empty() || !isMatch((Character) stack.pop(), currentChar)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isMatch(char top, char currentChar) {
        if ((top == '(' && currentChar == ')')
            || (top == '[' && currentChar == ']')
            || (top == '{' && currentChar == '}')) {
            return true;
        }
        return false;
    }
}
