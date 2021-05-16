package com.prakash.leetcode.NewStart.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aac";
        String t = "caa";
        System.out.println(" result--> " + new ValidAnagramSolution().isAnagram(s,t));
    }
}

class ValidAnagramSolution{

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0)
                    map.remove(c);
            }else{
                return false;
            }
        }
        return true;
    }

    //Solution 1
    /*public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        System.out.println("sCharArray-->" + Arrays.toString(sCharArray));
        System.out.println("tCharArray-->" + Arrays.toString(tCharArray));

        int i = 0;
        while(i<sCharArray.length) {
            if (sCharArray[i] == tCharArray[i])
                i++;
            else
                return false;
        }

        return true;
    }*/

}
