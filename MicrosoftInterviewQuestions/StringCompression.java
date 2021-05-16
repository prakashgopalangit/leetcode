package com.prakash.leetcode.NewStart.MicrosoftInterviewQuestions;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(" output --> "+ new StringCompressionSolution().compress(chars));
    }
}

class StringCompressionSolution{
    public int compress(char[] chars) {
        char prev = chars[0];
        int prevCounter = 1;
        int insertIndex = 0;
        for(int i=1;i<chars.length;i++){
            char currentChar = chars[i];
            if(currentChar!=prev){
                chars[insertIndex++] = prev;
                if(prevCounter>9)
                   insertIndex = splitCounter(chars, prevCounter, insertIndex);
                else if(prevCounter>1)
                    chars[insertIndex++] = (char) (prevCounter + '0');
                prev = currentChar;
                prevCounter = 1;
            }else{
                prevCounter++;
            }
        }
        chars[insertIndex++] = prev;

        if(prevCounter>9)
            insertIndex = splitCounter(chars, prevCounter, insertIndex);
        else if(prevCounter>1)
            chars[insertIndex++] = (char) (prevCounter + '0');
        System.out.println(" charArray --> "+ Arrays.toString(chars));
        return insertIndex;
    }

    public int splitCounter(char[] chars, int prevCounter, int insertIndex){
        String intString = ""+prevCounter;
        for(int i=0;i<intString.length();i++)
            chars[insertIndex++] = intString.charAt(i);
        return insertIndex++;
    }
}

/*class StringCompressionSolution{
    public int compress(char[] chars) {
        char prev = chars[0];
        int prevCounter = 1;
        int insertIndex = 0;
        for(int i=1;i<chars.length;i++){
            System.out.println("chars[i]--> "+ chars[i]);
            System.out.println("prev--> "+ prev);
            char currentChar = chars[i];
            if(currentChar!=prev){
                System.out.println("--- starting new char ------");
                System.out.println("prev--> "+ prev);
                System.out.println("prevCounter--> "+ prevCounter);
                System.out.println(" insertIndex --> "+ insertIndex);
                chars[insertIndex++] = prev;
                if(prevCounter>9){
                   insertIndex = splitCounter(chars, prevCounter, insertIndex);
                }else {
                    chars[insertIndex++] = (char) (prevCounter + '0');
                }
                prev = currentChar;
                prevCounter = 1;
            }else{
                prevCounter++;
            }
        }
        System.out.println("prev--> "+ prev);
        System.out.println("prevCounter--> "+ prevCounter);
        chars[insertIndex++] = prev;
        if(prevCounter>9){
            insertIndex = splitCounter(chars, prevCounter, insertIndex);
        }else {
            chars[insertIndex++] = (char) (prevCounter + '0');
        }
        System.out.println(" charArray --> "+ Arrays.toString(chars));
        return insertIndex;
    }

    public int splitCounter(char[] chars, int prevCounter, int insertIndex){
        String intString = ""+prevCounter;
        System.out.println(" intString---> "+ intString);
        for(int i=0;i<intString.length();i++){
            System.out.println(" intString.charAt(i) ---> "+ intString.charAt(i));
            chars[insertIndex++] = intString.charAt(i);
        }
        return insertIndex++;
    }
}
*/
