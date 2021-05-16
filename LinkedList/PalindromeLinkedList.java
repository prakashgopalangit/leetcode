package com.prakash.leetcode.NewStart.LinkedList;


public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, null);
        root.next = new ListNode(2, null);
        root.next.next = new ListNode(3,null);
        root.next.next.next = new ListNode(2,null);
        root.next.next.next.next = new ListNode(1, null);

        System.out.println(" result --> "+ new PalindromeLinkedListSolution().isPalindrome(root));
    }

}

class PalindromeLinkedListSolution {
    ListNode pointer1;
    public boolean isPalindrome(ListNode head) {
        pointer1 = head;
        ListNode pointer2 = head;
        return checkPalindrome(pointer2);
    }

    public boolean checkPalindrome(ListNode root){
       if(root==null) return true;
       boolean answer = checkPalindrome(root.next);
       ListNode pointer1Copy = pointer1;
       pointer1 = pointer1.next;
       return answer && pointer1Copy.value==root.value;
    }
}
