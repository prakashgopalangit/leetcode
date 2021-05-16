package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;

public class FlippingAnImage {

    public static void main(String[] args) {
        //int[][] intArray = {{1,1,0,0}};
        int[][] intArray = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};

        FlippingAnImageSolution sol = new FlippingAnImageSolution();
        int[][] returnArray = sol.flipAndInvertImage(intArray);
        for(int i=0;i<returnArray.length;i++)
            System.out.println(Arrays.toString(returnArray[i]));
    }
}

class FlippingAnImageSolution{
    public int[][] flipAndInvertImage(int[][] image) {
        System.out.println(" entering inside");
        int n = image.length;
        int l = 4;
        System.out.println(" n " + n);
        for(int i=0;i<n;i++){
            if(n%2!=0)
                image[i][l/2] = image[i][l/2]==0?1:0;
            for(int j=0;j<l/2;j++){
                System.out.println(" i --> " + i);
                System.out.println(" j --> " + j);
                System.out.println(" current image[i][j] --> " + image[i][j]);
                System.out.println(" current image[i][l-j-1] --> " + image[i][l-j-1]);
                int temp = image[i][j];
                image[i][j] = image[i][l-j-1]==0?1:0;
                image[i][l-j-1] = temp==0?1:0;

                System.out.println(" modified image[i][j] --> " + image[i][j]);
                System.out.println(" modified image[i][l-j-1] --> " + image[i][l-j-1]);

            }
        }
        return image;
    }
}
