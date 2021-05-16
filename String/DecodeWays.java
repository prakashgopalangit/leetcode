package com.prakash.leetcode.NewStart.String;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "226";
        System.out.println(" total count -->" + new DecodeWaysSolution().numDecodings(str));
    }
}
class DecodeWaysSolution {
    int count;
    public int numDecodings(String s) {
        StringBuilder sb = new StringBuilder();
        backtracking(s, sb, 0);
        return count;
    }
    public void backtracking(String s,StringBuilder sb, int stIndex){
        if(sb.length()==s.length())
            count++;
        for(int i=stIndex; i<s.length();i++){
            int endIndex = i+1;
            while(endIndex> s.length() && endIndex<=stIndex+1){
                String subStr = s.substring(i, stIndex+1);
                if(subStr.charAt(0)!='0' && Integer.parseInt(subStr)>=1 && Integer.parseInt(subStr)<=26){
                    sb.append(subStr);
                    backtracking(s, sb, endIndex+1);
                    sb.delete(sb.length()-subStr.length(), sb.length());
                }
                endIndex++;
            }
        }
    }
}
