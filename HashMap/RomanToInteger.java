package com.prakash.leetcode.NewStart.HashMap;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {

        //"IV"
        //"IX"
        //"LVIII"
        //"MCMXCIV"
       System.out.println(" output ---> " + new RomanToIntegerSolution().romanToInt("LVIII"));

        String s = "abc";
        System.out.println(s.substring(0,1));
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(2,3));


    }

}

class RomanToIntegerSolution {
    public int romanToInt(String s) {
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1 );
        map.put("V",5 );
        map.put("X",10 );
        map.put("L",50);
        map.put("C",100);
        map.put("D",500 );
        map.put("M",1000);
        map.put("IV", 4 );
        map.put("IX", 9 );
        map.put("XL", 40 );
        map.put("XC", 90 );
        map.put("CD", 400 );
        map.put("CM", 900 );
        int i = s.length();
        System.out.println(" s length --> " + s.length());
        while(i>0){
            System.out.println(" i --> " + i);
            if(i>=2 && map.get(s.substring(i-2,i))!=null){
                total += map.get(s.substring(i-2,i));
                i = i-2;
            }else{
                total += map.get(s.substring(i-1,i));
                i--;
            }
        }
        return total;
    }
}
