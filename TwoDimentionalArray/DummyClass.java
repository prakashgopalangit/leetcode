package com.prakash.leetcode.NewStart.TwoDimentionalArray;

import java.util.ArrayList;
import java.util.List;

class DummyClass {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colMin=0;
        int rowMin=0;
        int rowMax=matrix.length-1;
        int colMax=matrix[0].length-1;
        int count=0;
        int total=matrix.length*matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int i=0;
        while(count<total && colMin<=colMax && rowMin<=rowMax && rowMax>=0 && colMax>=0){
            i=colMin;
            while(i<=colMax && count<total){
                ans.add(matrix[rowMin][i]);
                count++;
                i++;
            }
            rowMin++;
            i=rowMin;
            while(i<=rowMax && count<total){
                ans.add(matrix[i][colMax]);
                count++;
                i++;
            }
            colMax--;
            i=colMax;
            while(i>=colMin && count<total){
                ans.add(matrix[rowMax][i]);
                count++;
                i--;
            }
            rowMax--;
            i=rowMax;
            while(i>=rowMin && count<total){
                ans.add(matrix[i][colMin]);
                count++;
                i--;
            }
            colMin++;
        }

        return ans;
    }
}
