package com.prakash.leetcode.NewStart.String;

import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(" output is --> "+ new RemoveAllAdjacentDuplicatesInStringSolution().removeDuplicates(str));
    }

}

//Solution 2 - using stack
/*class RemoveAllAdjacentDuplicatesInStringSolution{
    public String removeDuplicates(String S) {
       Stack<Character> stack = new Stack<>();
       for(char c : S.toCharArray()){
           if(!stack.isEmpty() && stack.peek()==c)
               stack.pop();
           else
               stack.push(c);
       }
       StringBuilder sb = new StringBuilder();
       while(!stack.isEmpty()){
           sb.append(stack.pop());
       }
       return sb.reverse().toString();


    }
}*/


//Solution 1 - not very efficient
class RemoveAllAdjacentDuplicatesInStringSolution{
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0;i<S.length();i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==S.charAt(i))
                sb.deleteCharAt(sb.length()-1);
            else
                sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}

