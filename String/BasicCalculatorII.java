package com.prakash.leetcode.NewStart.String;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String str = " 22*6 ";
        System.out.println("output--> " + new BasicCalculatorIISolution().calculate(str));
    }

}

class BasicCalculatorIISolution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char prevSign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            System.out.println(" c value---> " + c);
            if(Character.isDigit(c)){
                 num = num * 10 + (c -'0');
            }
            System.out.println(" num " + num);
            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1){
                if(prevSign=='+'){
                    stack.push(num);
                }else if(prevSign=='-'){
                    stack.push(-num);
                }else if(prevSign=='*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop() / num);
                }
                prevSign = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
