package com.prakash.leetcode.NewStart.Array;

public class CountOfMatchesInTournament {
    public static void main(String[] args) {
        System.out.println("output---> " + new CountOfMatchesInTournamentSolution().numberOfMatches(7));
    }
}


class CountOfMatchesInTournamentSolution{
    public int numberOfMatches(int n) {
        return numberOfMatchesRecursive(n);
    }

    public int numberOfMatchesRecursive(int n){
        if(n<=1)
            return 0;

        return n/2 + numberOfMatchesRecursive(n%2==0?n/2:n/2+1);
    }
}