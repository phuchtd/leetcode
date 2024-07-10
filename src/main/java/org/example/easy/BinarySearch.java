package org.example.easy;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 7, 9, 11, 15};
        int numberToFind = 4;
        int index = binarySearch(numbers, numberToFind);
        System.out.println(index);

        System.out.println("--------------");
        int i = Arrays.binarySearch(numbers, numberToFind);
        System.out.println(i);
    }
    public static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int midIndex = (low + high) / 2;
            int midVal = numbers[midIndex];
            if (numberToFind == midVal) {
                return midIndex;
            } else if (numberToFind < midVal) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return -1;
    }
}
