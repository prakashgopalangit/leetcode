package com.prakash.leetcode.NewStart.Array;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4};
        System.out.println(" countTeams--> "+ new CountNumberOfTeamsSolution().numTeams(inputArray));
    }
}

class CountNumberOfTeamsSolution {
    public int numTeams(int[] rating) {
        int numTeams=0;
        if(rating.length==0) return numTeams;
        for(int i=0;i<rating.length-2;i++){
            int increasingPointer1  = i+1;
            while(increasingPointer1<rating.length-1){
                while(increasingPointer1<rating.length-1 && rating[increasingPointer1]<rating[i])
                    increasingPointer1++;
                int secondValue = rating[increasingPointer1];
                increasingPointer1++;
                while(increasingPointer1<rating.length-1 && rating[increasingPointer1]<secondValue)
                    increasingPointer1++;
                int thirdValue = rating[increasingPointer1];
                increasingPointer1++;
                if(secondValue>rating[i] && thirdValue>secondValue)
                    numTeams++;
            }
        }


        /*for(int i=0;i<rating.length-2;i++){
            int pointer1 = i+1;
            while(pointer1<=rating.length-1) {
                int pointer2 = pointer1+1;
                if (rating[pointer1] > rating[i]) {
                    while(pointer2<=rating.length-1) {
                        if (rating[pointer2] > rating[pointer1]) {
                            numTeams++;
                        }
                        pointer2++;
                    }
                }
                pointer1++;
            }
        }
        for(int i=rating.length-1;i>=0;i--){
            int pointer1 = i-1;
            while(pointer1>=0) {
                int pointer2 = pointer1-1;
                if (rating[pointer1] > rating[i]) {
                    while(pointer2>=0) {
                        if (rating[pointer2] > rating[pointer1]) {
                            numTeams++;
                        }
                        pointer2--;
                    }
                }
                pointer1--;
            }
        }*/
        return numTeams;
    }
}
