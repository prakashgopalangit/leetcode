package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {

        int low = 100;
        int high = 300;

        System.out.println("results ---> " + new SequentialDigitsSolution().sequentialDigits(low, high));



    }
}

class SequentialDigitsSolution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        String lowStr = String.valueOf(low);
        String hightStr = String.valueOf(high);
        findOutAdditiveNumber((int)lowStr.charAt(0), lowStr, hightStr, "", results);
        return results;
    }

    public void findOutAdditiveNumber(int index, String lowStr, String highStr, String str, List<Integer> results){
        if(Integer.parseInt(str) >= Integer.parseInt(lowStr)
                && Integer.parseInt(str) <= Integer.parseInt(highStr)
                && str.length()>= lowStr.length()
                && str.length() <= highStr.length()){
            results.add(Integer.parseInt(str));
        }
        for(int i=index;i<=9;i++){
            str = str+i;
            findOutAdditiveNumber(index+1, lowStr, str, str, results);
        }

    }
}
