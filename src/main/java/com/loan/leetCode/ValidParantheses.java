package com.loan.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {
    public boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c :s.toCharArray()){
            if(c == '(' ||c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(c==')' && top!='(')
                    return false;
                if(c==']' && top!='[')
                    return false;
                if(c=='}' && top!='{')
                    return false;
            }
        }return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses validParantheses=new ValidParantheses();
        System.out.println(validParantheses.isValid("{{{[[[[((()))]]]]}}}"));
    }
}
