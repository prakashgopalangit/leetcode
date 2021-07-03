package com.prakash.leetcode.NewStart.String;

public class WildcardMatching {
    public static void main(String[] args) {

        //String s = "m i s si ss i p pi";
        //String p = "m ? ? *  ss*?i*pi";
        String s = "adceb";
        String p = "a*b";


        System.out.println(" boolean ---> "+ new WildcardMatchingSolution().isMatch(s,p));

    }
}

class WildcardMatchingSolution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0 || p.equalsIgnoreCase("*"))
            return true;
        if(p.length()==1 && s.length()>1)
            return false;
        return backtracking(s, p, 0, 0, '+');

    }

    public boolean backtracking(String s, String p, int sIndex, int pIndex, char prevChar ){

        if(sIndex>=s.length() || (pIndex==p.length()-1 && p.charAt(pIndex)=='*'))
            return true;

        if(s.charAt(sIndex)!=p.charAt(pIndex)){
            if(p.charAt(pIndex)=='*'){
                return backtracking(s, p, sIndex+1, pIndex+1, '*');
            }else if(p.charAt(pIndex)=='?'){
                return backtracking(s, p, sIndex+1, pIndex+1, '?');
            }else if(prevChar=='*'){
                return backtracking(s, p, sIndex+1, pIndex, '*');
            }else{
                return false;
            }
        }else{
            return backtracking(s, p, sIndex+1, pIndex+1, prevChar);
        }

    }

}
