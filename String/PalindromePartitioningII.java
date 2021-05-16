package com.prakash.leetcode.NewStart.String;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println("output---> " + new PalindromePartitioningIISolution().minCut(str));
    }
}
class PalindromePartitioningIISolution {
    int minCut = Integer.MAX_VALUE;
    public int minCut(String s) {
        dfs(0, new ArrayList<String>(), s);
        return minCut;
    }

    public void dfs(int startIndex, List<String> currentList, String str){
        System.out.println("currentList.size()---> "+ currentList.size());
        if(startIndex>=str.length() && currentList.size()-1 < minCut)
            minCut = currentList.size()-1;
        for(int endIndex=startIndex;endIndex<str.length();endIndex++){
            if(isPalindrome(startIndex, endIndex, str)){
                currentList.add(str.substring(startIndex, endIndex+1));
                dfs(endIndex+1,currentList, str);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public boolean isPalindrome(int startIndex, int endIndex, String str){
        while(startIndex<endIndex){
            if(str.charAt(startIndex)!=str.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
