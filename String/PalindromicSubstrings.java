package com.prakash.leetcode.NewStart.String;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(" output---> "+ new PalindromicSubstringsSolution().countSubstrings(str));
    }
}

class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {
        int totalAns = 0;

        for(int i=0;i<s.length();i++){
            totalAns += expandRange(s, i, i);
            totalAns +=expandRange(s, i, i+1);
        }
        return totalAns;
    }

    public int expandRange(String s, int start, int end){
        int ans = 0;
        while(start>=0 && end <s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            ans++;
        }
        return ans;
    }
}

//Brute Force Solution - didnt give much performance
/*class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        dfs(0, resultList, new ArrayList<String>(), s);
        return resultList.size();
    }

    public void dfs(int startIndex, List<List<String>> resultList, List<String> currentList, String str){
        if(startIndex>=str.length())
            resultList.add(new ArrayList<String>(currentList));
        for(int endIndex=startIndex;endIndex<str.length();endIndex++){
            if(isPalindrome(startIndex, endIndex, str)){
                currentList.add(str.substring(startIndex, endIndex+1));
                dfs(endIndex+1,resultList, currentList, str);
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
}*/