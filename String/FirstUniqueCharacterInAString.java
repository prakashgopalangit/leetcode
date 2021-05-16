package com.prakash.leetcode.NewStart.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String str = "aadadaad";
        System.out.println(" index value --> " + new FirstUniqueCharacterInAStringSolution().firstUniqChar(str));
    }

}

class FirstUniqueCharacterInAStringSolution {
    public int firstUniqChar(String s) {
        /*if(s.length()<=0) return -1;
        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){
            if(list.contains(c))
                list.remove(Character.valueOf(c));
            else
                list.add(c);
        }
        return list.size()>0?s.indexOf(list.get(0)):-1;*/

        if (s.length() <= 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
