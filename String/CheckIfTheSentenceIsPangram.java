package com.prakash.leetcode.NewStart.String;

public class CheckIfTheSentenceIsPangram {

    public static void main(String[] args) {
        String str =
                "uwqohxamknblecdtzpisgvyfjr";
        System.out.println(" result ---> "+ new CheckIfTheSentenceIsPangramSolution().checkIfPangram(str));
    }
}

class CheckIfTheSentenceIsPangramSolution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<27) return false;
        for(int i=1;i<=26;i++) {
            System.out.println("(char) i + 96) -->  "+ ((char) i + 96));
            System.out.println(" sentence.indexOf((char) i + 96) ---> "+ sentence.indexOf((char) i + 96));
            if (sentence.indexOf((char) i + 96) < 0) {
                return false;
            }
        }
        return true;
    }
}
