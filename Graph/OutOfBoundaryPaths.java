package com.prakash.leetcode.NewStart.Graph;

public class OutOfBoundaryPaths {

    public static void main(String[] args) {

        System.out.println(" no of paths --> "+ new OutOfBoundaryPathsSolution().findPaths(8,7,16,1,5));

    }

}

class OutOfBoundaryPathsSolution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] memo = new Long[m][n][maxMove+1];
        return (int)dfs(m, n, startRow, startColumn, maxMove, memo);
    }

    public long dfs(int m, int n, int i, int j, int N, Long[][][] memo){

        System.out.println("***************** ");
        System.out.println("i " + i);
        System.out.println("j " + j);

        if(i>=m || j >=n || i<0 || j<0){
                return 1;
        }
        if(N<1)
            return 0;

        if(memo[i][j][N]!=null)
            return memo[i][j][N];

        long up = dfs(m, n, i, j-1, N-1, memo);
        long down = dfs(m, n, i, j+1, N-1, memo);
        long left = dfs(m, n, i-1, j, N-1, memo);
        long right = dfs(m, n, i+1, j, N-1, memo);

        memo[i][j][N] = (up + down + left + right) % (10*9+7);
        return memo[i][j][N];
    }
}
