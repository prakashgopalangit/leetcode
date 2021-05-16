package com.prakash.leetcode.NewStart.Array;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(" return value --> " + new MaximumSwapSolution().maximumSwap(
                98368));
    }
}
class MaximumSwapSolution {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int low  = 0;
        int high = 0;
        for(int i=1;i<charArray.length;i++){
            if(charArray[i]>=charArray[high])
                high = i;
            if(charArray[i]<charArray[low])
                low = i;
        }
        if(high>low){
            char c = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = c;
        }
        return Integer.parseInt(String.valueOf(charArray));
    }
}
