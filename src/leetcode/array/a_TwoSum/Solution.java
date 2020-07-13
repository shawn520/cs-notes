package leetcode.array.a_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/7/13
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[]{map.get(complement),i};
            map.put(nums[i], i);
        }
        //return null;
        throw new IllegalArgumentException("No two sum solution");
    }
}
