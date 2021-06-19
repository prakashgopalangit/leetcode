package com.prakash.leetcode.NewStart.LeetCodeTesting;

import java.util.LinkedList;
import java.util.List;

public class OpenLock {

    public static void main(String[] args) {
        String str = "1000";
        List<String> result = getSuccessors(str);

        for(String s : result)
            System.out.println(" next lock ---> "+ s);

    }
    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return res;
    }
}
