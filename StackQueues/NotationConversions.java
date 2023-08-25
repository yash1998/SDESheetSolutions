package StackQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class NotationConversions {
    public static String infixToPostfix(String exp) {
        if (exp.isEmpty()) return exp;
        
        int n = exp.length();

        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('-', 1);
        precedence.put('+', 1);
        precedence.put(')', 0);
        precedence.put('(', 0);

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++) {
            char x = exp.charAt(i);

            if (x == '(') {
                st.push(x);
            } else if (x == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                // if st is not empty, we need to remove the '('
                if (!st.isEmpty() && st.peek() == '(') st.pop();
            }
            else if (precedence.containsKey(x)) {
                // operator
                while(!st.isEmpty() && precedence.get(st.peek()) >= precedence.get(x)) {
                    sb.append(st.pop());
                }
                st.push(x);
            } else {
                // operand
                sb.append(x);
            }
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static String infixToPrefix(String exp) {
        if (exp.isEmpty()) return exp;
        int n = exp.length();

        // 1. reverse infix
        StringBuilder sb = new StringBuilder(exp);
        sb.reverse();

        // 2. replace '(' with ')' and vice versa
        for(int i=0; i<n; i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                sb.setCharAt(i, ')');
            } else if (c == ')') {
                sb.setCharAt(i, '(');
            }
        }

        // 3. postfix of the reversed string
        sb.replace(0, n, infixToPostfix(sb.toString()));

        // 4. reverse the postfix of reversed string
        sb.reverse();
        return sb.toString();

        // ** Infix -> postfix -> prefix
        // return postfixToPrefix(infixToPostfix(exp));
    }

    public static String prefixToPostfix(String s) {
        if(s.isEmpty()) return s;

        List<Character> operators = Arrays.asList('+','-','*','/');
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            char x = s.charAt(i);
            if (operators.contains(x)) {
                String s1 = "", s2 = "";
                if(!st.isEmpty()) {
                    s1 = st.pop();
                }
                if(!st.isEmpty()) {
                    s2 = st.pop();
                }
                st.push(s1+s2+String.valueOf(x));
            } else {
                st.push(String.valueOf(x));
            }
        }

        return st.peek();
    }

    public static String postfixToPrefix(String exp) {
        if(exp.isEmpty()) return exp;
        
        List<Character> operators = Arrays.asList('+','-','*','/');
        int n= exp.length();
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<n;i++) {
            char x = exp.charAt(i);

            if (operators.contains(x)) {
                String s1="", s2 = "";
                if(!st.isEmpty()) {
                    s1 = st.pop();
                }
                if(!st.isEmpty()) {
                    s2 = st.pop();
                }
                st.push(String.valueOf(x)+s2+s1);
            } else {
                st.push(String.valueOf(x));
            }
        }

        return st.peek();
    }

    public static String prefixToInfixConversion(String s) {
        if(s.isEmpty()) return s;

        List<Character> operators = Arrays.asList('+','-','*','/');
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            char x = s.charAt(i);
            if (operators.contains(x)) {
                String s1 = "", s2 = "";
                if(!st.isEmpty()) {
                    s1 = st.pop();
                }
                if(!st.isEmpty()) {
                    s2 = st.pop();
                }
                st.push("("+s1+String.valueOf(x)+s2+")");
            } else {
                st.push(String.valueOf(x));
            }
        }

        return st.peek();
    }

    public static String postToInfix(String s) {
        if(s.isEmpty()) return s;

        List<Character> operators = Arrays.asList('+','-','*','/');
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=0; i<n; i++) {
            Character x = s.charAt(i);
            if (operators.contains(x)) {
                String s1 = "", s2 = "";
                if(!st.isEmpty()) {
                    s1 = st.pop();
                }
                if(!st.isEmpty()) {
                    s2 = st.pop();
                }
                st.push("("+s2+Character.toString(x)+s1+")");
            } else {
                st.push(Character.toString(x));
            }
        }

        return st.peek();
    }
}
