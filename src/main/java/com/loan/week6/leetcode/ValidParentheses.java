package com.loan.week6.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if(c==')'&& top!='(')
                    return false;
                if(c==']'&& top!='[')
                    return false;
                if(c=='}'&&top!='{')
                    return false;
            }

        }return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("[[({})]]"));
    }
}
