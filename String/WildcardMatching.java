package com.prakash.leetcode.NewStart.String;

public class WildcardMatching {
    public static void main(String[] args) {

        String s = "m i s si ss i p pi";
        String p = "m ? ? *  ss*?i*pi";
        System.out.println(" boolean ---> "+ new WildcardMatchingSolution().isMatch(s,p));

    }
}

class WildcardMatchingSolution {
    public boolean isMatch(String s, String p) {
        if(p.equalsIgnoreCase("*"))
            return true;
        if(p.length()==1 && s.length()>1)
            return false;
        int sPointer = 0;
        int pPointer = 0;
        char prevSpecialChar = '+';

        while(sPointer<s.length() && pPointer<p.length()){
            System.out.println(" sPointer " + sPointer);
            System.out.println(" pPointer " + pPointer);
            if(Character.isLetter(p.charAt(pPointer))){
                if(prevSpecialChar =='+' || prevSpecialChar =='?')
                    if(s.charAt(sPointer)!=p.charAt(pPointer))
                        return false;
                pPointer++;
                sPointer++;
            }else if(p.charAt(pPointer)=='?'){
                prevSpecialChar = '?';
                sPointer++;
                pPointer++;
            }else{
                System.out.println(" go to * condition");
                prevSpecialChar = '*';
                if(pPointer>=p.length())
                    continue;
                char nextPChar = p.charAt(++pPointer);
                System.out.println("nextPChar --> "+ nextPChar);
                System.out.println("s.charAt(sPointer) --> "+ s.charAt(sPointer));
                while(s.charAt(sPointer)!=nextPChar){
                   sPointer++;
                    System.out.println("nextPChar --> "+ nextPChar);
                    System.out.println("s.charAt(sPointer) --> "+ s.charAt(sPointer));
                }
                sPointer++;
                pPointer++;
            }

        }
        return sPointer==s.length() && pPointer==p.length();
    }
}
