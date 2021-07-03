package com.prakash.leetcode.NewStart.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(" total unique combinations ---> "+ new CountNumbersWithUniqueDigitsSolution().countNumbersWithUniqueDigits(n));
    }

}


class CountNumbersWithUniqueDigitsSolution {
    int counter;
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int[] used = new int[10];
        for(int i=1;i<=9;i++) {
            used[i] = 1;
            dfs(String.valueOf(i), n, used);
            used[i] = 0;
        }
        System.out.println(" counter ---> "+ counter);
        return counter;
    }

    public void dfs(String i, int n, int[] used){
        if(Integer.parseInt(i)<n) {
            System.out.println("Integer.parseInt(i) ---> " + Integer.parseInt(i));
            counter++;
            return;
        }
        for(int j=1;j<=9;j++) {
            if (used[j] == 0) {
                used[j] = 1;
                dfs(i+j, n, used);
                used[j] = 0;
            }
        }

    }
}