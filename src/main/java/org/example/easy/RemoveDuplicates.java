package org.example.easy;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i=1; i<nums.length-1; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return k;
    }
}
