/*974. Subarray Sums Divisible by K
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 */

import java.util.HashMap;

public class program3 {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> f = new HashMap<>();
        f.put(0, 1); 

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) rem += k; 

            res += f.getOrDefault(rem, 0);
            f.put(rem, f.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
