package org.example.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs_1 = new String[] {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix_v2(strs_1));
    }

    public static String longestCommonPrefix_v2(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length -1];
        StringBuilder commonPrefix = new StringBuilder();
        int index = 0;
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                commonPrefix.append(first.charAt(index));
                index++;
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
    public static String longestCommonPrefix(String[] strs) {
        String maxPrefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            maxPrefix = compare(maxPrefix, strs[i]);
        }
        return maxPrefix;
    }

    public static String compare(String a, String b){
        if (a.equals(b)) {
            return a;
        }
        StringBuilder commonPrefix = new StringBuilder();
        int index = 0;
        while (index < a.length() && index < b.length()) {
            if (a.charAt(index) == b.charAt(index)) {
                commonPrefix.append(a.charAt(index));
                index++;
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
}
