package com.prakash.leetcode.NewStart.String;

public class CountSortedVowelStrings {

    public static void main(String[] args) {

        System.out.println(" total ---> "+ new CountSortedVowelStringsSolution().countVowelStrings(33));


    }
}

class CountSortedVowelStringsSolution {
    int counter;
    public int countVowelStrings(int n) {
        if(n==1) return 5;
        char[] charArray = {'a','e','i','o','u'};
        StringBuilder sb = new StringBuilder();
        countVowels(charArray, sb, 0, n);
        return counter;
    }

    public void countVowels(char[] charArray, StringBuilder sb, int index, int length){

        if(sb.length()==length) {
            System.out.println(" sb ---> "+ sb.toString());
            counter++;
            return;
        }
        for(int stIndex=index;stIndex<charArray.length;stIndex++){
            sb.append(charArray[stIndex]);
            countVowels(charArray, sb, stIndex,length);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}