package org.example.easy;

public class PalindromeNumber {
    /*
    * An integer is a palindrome when it reads the same forward and backward.
    * Ex: 121, 11
    */
    public static void main(String[] args) {
        int x = 11; // 10, 121, 123, 11, -121
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int mid = number.length() / 2;
        int left = 0;
        int right = number.length() - 1;
        while (left <= mid && right >= mid) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }
}
