package com.prakash.leetcode.NewStart.Array;

public class MostProfitAssigningWork {

    public static void main(String[] args) {
        /*int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};*/
        int[] difficulty = {85,47,57};
        int[] profit = {24,66,99};
        int[] worker = {40,25,25};
        System.out.println(" maxProfit --> " + new MostProfitAssigningWorkSolution().maxProfitAssignment(difficulty, profit, worker));

    }

}

class MostProfitAssigningWorkSolution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        for(int i=0;i<worker.length;i++){
            int difficultyIndex = binarySearch(worker[i], difficulty);
            System.out.println("difficultyIndex ---> " + difficultyIndex);
            maxProfit += profit[difficultyIndex];
        }
        return maxProfit;
    }

    public int binarySearch(int workerDiffMax, int[] difficulty){
        System.out.println("workerDiffMax ---> " + workerDiffMax);
        int low = 0;
        int high = difficulty.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            System.out.println("low --> "+ low);
            System.out.println("high --> "+ high);
            System.out.println("mid --> "+ mid);
            if(workerDiffMax<difficulty[mid]){
                if(mid>0 && difficulty[mid-1]<workerDiffMax)
                    return mid-1;
                else
                    high = mid-1;
            }else if(workerDiffMax>difficulty[mid]){
                if(mid<difficulty.length-2 && difficulty[mid+1]>workerDiffMax)
                    return mid;
                else
                    low = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
