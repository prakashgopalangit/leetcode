package com.prakash.leetcode.NewStart.AmazonInterviewQuestions;

public class SlowestKey {
    public static void main(String[] args) {
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        System.out.println("longestPressedKey ---> "+ new SlowestKeySolution().slowestKey(releaseTimes,keysPressed));
    }
}

class SlowestKeySolution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pressTime = 0;
        int longestPress = 0;
        char longestPressKey = '*';
        for(int i=0;i<keysPressed.length();i++){
            int difference = releaseTimes[i]-pressTime;
            if(difference>longestPress){
                longestPress = difference;
                longestPressKey = keysPressed.charAt(i);
            }else if((difference)== longestPress && keysPressed.charAt(i)>longestPressKey){
                    longestPressKey = keysPressed.charAt(i);
            }
            pressTime = releaseTimes[i];
        }
        return longestPressKey;
    }
}

/*
class SlowestKeySolution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pressTime = 0;
        int longestPress = 0;
        char longestPressKey = '*';
        for(int i=0;i<keysPressed.length();i++){
            System.out.println("releaseTimes[i]-pressTime --> "+ (releaseTimes[i]-pressTime));
            System.out.println(" longestPress ---> "+ longestPress);
            if((releaseTimes[i]-pressTime)>longestPress){
                System.out.println(" going inside");
                longestPress = releaseTimes[i]-pressTime;
                System.out.println(" keysPressed.charAt(i) --> "+ keysPressed.charAt(i));
                System.out.println(" longestPressKey --> "+ longestPressKey);
                longestPressKey = keysPressed.charAt(i);
            }else if((releaseTimes[i]-pressTime)== longestPress){
                if(keysPressed.charAt(i)>longestPressKey)
                    longestPressKey = keysPressed.charAt(i);
            }
            pressTime = releaseTimes[i];
        }
        return longestPressKey;
    }
}*/
