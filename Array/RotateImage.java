package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImageSolution().rotate(image);
        for(int[] val : image){
            System.out.println(" rotate image --> " + Arrays.toString(val));
        }
    }
}


class RotateImageSolution {
    public void rotate(int[][] matrix) {
        int matrixLength = matrix.length;
        for(int row=0;row<matrixLength;row++){
            for(int col=row;col<matrixLength;col++){
                int temp = matrix[row][col];
                System.out.println("temp --> " + temp);
                matrix[row][col] = matrix[col][row];
                System.out.println("matrix[row][col] --> " + matrix[row][col]);
                matrix[col][row] = temp;
                System.out.println("matrix[col][row] --> " + matrix[col][row]);
            }
        }

        for(int i=0;i<matrixLength;i++){
            for(int j=0;j<matrixLength/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrixLength-j-1];
                matrix[i][matrixLength-j-1] = temp;
            }

        }

    }
}