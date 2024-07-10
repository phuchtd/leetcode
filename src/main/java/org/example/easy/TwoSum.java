package org.example.easy;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        // Testcase 1
        int[] nums1 = new int[] {2,7,11,15};
        int target = 9;
        int[] twoSum = twoSum(nums1, target);
        System.out.println(twoSum);

        int[] twoSum_v2 = twoSum_v2(nums1, target);
        System.out.println(twoSum_v2);
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSum_v2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (map.containsValue(nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(i, target - nums[i]);
        }
        return new int[] {-1, -1};
    }
}
