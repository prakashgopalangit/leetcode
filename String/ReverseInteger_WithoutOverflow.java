package com.prakash.leetcode.NewStart.String;

public class ReverseInteger_WithoutOverflow{
    public static void main(String[] args){
        int intValue = 123;
        System.out.println("intValue--->" + new ReverseInteger_WithoutOverflowSolution().reverse(intValue));

        int intValue2 = -123;
        System.out.println("intValue2--->" + new ReverseInteger_WithoutOverflowSolution().reverse(intValue2));

        int intValue3 = 1239999999;
        System.out.println("intValue3--->" + new ReverseInteger_WithoutOverflowSolution().reverse(intValue3));





    }
}

class ReverseInteger_WithoutOverflowSolution{
    public int reverse(int x) {
        int rev  = 0;
        while(x!=0){
            int pop = x%10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop >7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop <-8)) return 0;
            rev = rev*10 + pop;
            x /= 10;
        }
        return rev;
    }

}