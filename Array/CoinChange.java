package com.prakash.leetcode.NewStart.Array;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(" minimum coin change ---> "+ new CoinChangeSolution().coinChange(coins, amount, new int[amount]));

    }

}

class CoinChangeSolution{
    public int coinChange(int[] coins, int amount, int[] memo) {
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(memo[amount-1]!=0)
            return memo[amount-1];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = coinChange(coins, amount-coins[i], memo);
            if(res>=0 && res<min)
                min = Math.min(min, res+1);
        }
        memo[amount-1] = min==Integer.MAX_VALUE?-1:min;
        return memo[amount-1];
    }

}
