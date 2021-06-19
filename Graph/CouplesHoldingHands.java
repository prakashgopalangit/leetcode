package com.prakash.leetcode.NewStart.Graph;

import java.util.Arrays;

public class CouplesHoldingHands {

    public static void main(String[] args) {
        int[] couples = {0,2,1,3};
        System.out.println(" min swap ---> "+ new CouplesHoldingHandsSolution().minSwapsCouples(couples));
    }


}

class CouplesHoldingHandsSolution{
    public int minSwapsCouples(int[] row) {
        int[] currentPosition = new int[row.length];


        for(int i=0;i<row.length;i++)
            currentPosition[row[i]] = i;

        System.out.println("currentPosition begining --->  " + Arrays.toString(currentPosition));
        int noOfSwap = 0;
        for(int i=0;i<row.length;i+=2){
            if(row[i]%2==0){
                System.out.println(" going inside");
                if(row[i]+1 == row[i+1]) continue;
                int left = i+1;
                int right = currentPosition[row[i]+1];
                swap(row, left, right);
                swap(currentPosition, row[left], row[right]);
                noOfSwap++;
            }else{




            }

            System.out.println("currentPosition every i operation --->  " + Arrays.toString(currentPosition));
        }

        return noOfSwap;
    }

    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }
}
