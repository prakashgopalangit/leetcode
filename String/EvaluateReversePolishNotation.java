package com.prakash.leetcode.NewStart.String;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] strArray = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(" output --> " + new EvaluateReversePolishNotationSolution().evalRPN(strArray));
    }
}

class EvaluateReversePolishNotationSolution{
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            System.out.println(" str --> "+ str);
            System.out.println(" !Character.isDigit(str.charAt(0)) --> "+ !Character.isDigit(str.charAt(0)));

            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int eval = 0 ;
                int element1 = stack.pop();
                int element2 = stack.pop();
                if(str.equalsIgnoreCase("*"))
                    eval = element2*element1;
                else if(str.equalsIgnoreCase("/"))
                    eval = Math.round(element2/element1);
                else if(str.equalsIgnoreCase("+"))
                    eval = element2+element1;
                else
                    eval = element2-element1;
                stack.push(eval);
            }else{
                stack.push(Integer.parseInt(str));
            }
            /*if (str.length() == 1 && !Character.isDigit(str.charAt(0))){
                int eval = 0 ;
                int element1 = stack.pop();
                int element2 = stack.pop();
                if(str.equalsIgnoreCase("*"))
                    eval = element2*element1;
                else if(str.equalsIgnoreCase("/"))
                    eval = Math.round(element2/element1);
                else if(str.equalsIgnoreCase("+"))
                    eval = element2+element1;
                else
                    eval = element2-element1;
                stack.push(eval);
            }else{
                stack.push(Integer.parseInt(str));
            }*/
        }
        return stack.pop();
    }
}
