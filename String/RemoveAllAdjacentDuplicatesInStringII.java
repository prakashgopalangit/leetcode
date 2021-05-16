package com.prakash.leetcode.NewStart.String;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        String str = "pbbcggttciiippooaais";
        System.out.println(" output --> "+ new RemoveAllAdjacentDuplicatesInStringIISolution().removeDuplicates(str, 2, 0));

    }

}

class RemoveAllAdjacentDuplicatesInStringIISolution{
    public String removeDuplicates(String s, int k, int stIndex) {
        while(stIndex<=s.length()-k){
            System.out.println(" s.charAt(stIndex) --> "+ s.charAt(stIndex));
            if(s.charAt(stIndex)== s.charAt(stIndex+k-1) && foundKMatchingElements(s.charAt(stIndex), s.substring(stIndex, stIndex+k))) {
                System.out.println(" stIndex --> "+ stIndex);
                String str = s.substring(0, stIndex) + s.substring(stIndex + k, s.length());
                System.out.println(" spilt string --> "+ str);
                s = removeDuplicates(str, k, 0);
            }else {
                stIndex++;
                System.out.println(" stIndex "+ stIndex);
            }
        }
        return s.length()>0?s:"";
    }

    public boolean foundKMatchingElements(char c, String str){
        System.out.println(" str inside --> "+ str);
        for(char charVal : str.toCharArray())
            if(c!=charVal)
                return false;
        return true;
    }
}
