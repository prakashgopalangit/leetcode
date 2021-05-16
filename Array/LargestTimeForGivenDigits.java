package com.prakash.leetcode.NewStart.Array;

public class LargestTimeForGivenDigits {

    public static void main(String[] args) {
        int[] input = {1,0,0,4};
        System.out.println(" output string ---> " + new LargestTimeForGivenDigitsSolution().largestTimeFromDigits(input));
    }
}


class LargestTimeForGivenDigitsSolution {
    public String largestTimeFromDigits(int[] A) {
            int hrDigit1 = 0;
            int hrDigit2 = 0;
            int minDigit1 = 0;
            int minDigit2 = 0;
            for(int digit : A){
                int inputDigit = digit;
                boolean updated = false;
                if(inputDigit>=0 && inputDigit<=2){
                    if(inputDigit>hrDigit1){
                        int temp = hrDigit1;
                        hrDigit1 = inputDigit;
                        inputDigit = temp;
                    }
                }
                System.out.println(" hrDigit1 --> " + hrDigit1);
                if(inputDigit<=4){
                    if((inputDigit==4 && hrDigit1!=2 && inputDigit>hrDigit2) || (inputDigit<=3 && inputDigit>hrDigit2)){
                        int temp = hrDigit2;
                        hrDigit2 = inputDigit;
                        inputDigit = temp;
                    }
                }
                System.out.println(" hrDigit2 --> " + hrDigit2);
                if(inputDigit<=5){
                    if(inputDigit>minDigit1){
                        int temp = minDigit1;
                        minDigit1 = inputDigit;
                        inputDigit = temp;
                    }
                }
                System.out.println(" minDigit1 --> " + minDigit1);
                if(inputDigit<=9){
                    if(inputDigit>minDigit2){
                        int temp = minDigit2;
                        minDigit2 = inputDigit;
                        inputDigit = temp;
                    }
                }
                System.out.println(" minDigit2 --> " + minDigit2);
                if(inputDigit>0)
                    return "";
            }
            return new StringBuilder().append(hrDigit1).append(hrDigit2).append(":").append(minDigit1).append(minDigit2).toString();
    }
}