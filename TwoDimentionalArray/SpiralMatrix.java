package com.prakash.leetcode.NewStart.TwoDimentionalArray;

//https://leetcode.com/problems/spiral-matrix

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,3},{4,5}};

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(" List of integers ---> " + new SpiralMatrixSolution().spiralOrder(matrix));
    }


}

class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        int rowMin = 0;
        int colMin = 0;
        int rowMax = matrix.length-1;
        int colMax = matrix[0].length-1;
        int total=matrix.length*matrix[0].length;
        while(rowMax>=0 && colMax>=0 && rowMin <= rowMax && colMin<=colMax){
            while(col<=colMax && total>0){
                System.out.println(" 1 --> "+ row +" "+ col);
                list.add(matrix[row][col]);
                col++;
                total--;
            }
            rowMin++;
            row = rowMin;
            col = colMax;

            while(row<=rowMax && total>0){
                System.out.println(" 2 --> "+ row +" "+ col);
                list.add(matrix[row][col]);
                row++;
                total--;
            }
            colMax--;
            col = colMax;
            row = rowMax;

            while(col>=colMin && total>0){
                System.out.println(" 3 --> "+ row +" "+ col);
                list.add(matrix[row][col]);
                col--;
                total--;
            }
            rowMax--;
            row = rowMax;
            col = colMin;

            while(row>=rowMin && total>0){
                System.out.println(" 4 --> "+ row +" "+ col);
                list.add(matrix[row][col]);
                row--;
                total--;
            }
            colMin++;
            col = colMin;
            row = rowMin;


            System.out.println(" rowMin --> " + rowMin);
            System.out.println(" colMin --> " + colMin);
            System.out.println(" rowMax --> " + rowMax);
            System.out.println(" colMax --> " + colMax);


            System.out.println(" col ---> " + col);
            System.out.println(" row ---> " + row);

        }
        return list;
    }
}
