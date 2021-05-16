package com.prakash.leetcode.NewStart.String;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "DAOBECODBC";
        String t ="ABC";
        System.out.println(" output --> "+ new MinimumWindowSubstringSolution().minWindow(s,t));
    }
}


class MinimumWindowSubstringSolution{

    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            System.out.println(" c1 ---> "+ c1);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            System.out.println(" counter ---> "+ counter);
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                System.out.println("minLen--> " + minLen);
                System.out.println("minStart--> " + minStart);
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
                System.out.println("start---> "+ start);
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}