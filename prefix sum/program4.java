/*
525. Contiguous Array
Medium
Topics
premium lock icon
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:
 */

import java.util.HashMap;

public class program4 {
     public int findMaxLength(int[] nums) {
        int n = nums.length, zero = 0, one = 0, res = 0;
        HashMap<Integer, Integer> f = new HashMap<>();
        f.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zero++;
            else one++;
            int diff = zero - one;
            if (diff == 0) {
                res = Math.max(res, i + 1);
                continue;
            }
            if (!f.containsKey(diff)) {
                f.put(diff, i);
            } else {
                int idx = f.get(diff);
                int len = i - idx;
                res = Math.max(res, len);
            }
        }
        return res;
      }
}
