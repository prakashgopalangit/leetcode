package com.prakash.leetcode.NewStart.Backtracking;

import java.util.Arrays;

public class CoinChangeII {


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println("no Of possible ways  ---> " + new CoinChangeIISolution().change(amount, coins));

    }


}

class CoinChangeIISolution {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return backtracking(coins, amount, 0, new int[amount+1][amount+1]);

    }

    public int backtracking(int[] coins, int amount, int index, int[][] memo){
        System.out.println(" amount ---> "+ amount);
        System.out.println(" =========== ");
        if(amount<0) return 0;
        if(memo[amount][index]!=0)
            return memo[amount][index];
        if(amount==0)
            return 1;
        int res = 0;
        for(int i=index;i<coins.length;i++) {
            System.out.println(" coins[i] --> "+ coins[i]);
            if(amount-coins[i]>=0) {
                res  += backtracking(coins, amount - coins[i], i, memo);

            }
        }
        memo[amount][index] = res;
        return memo[amount][index];
    }


}
