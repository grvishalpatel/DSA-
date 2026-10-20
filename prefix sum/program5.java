/*862. Shortest Subarray with Sum at Least K
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class program5 {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            while (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, j - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offerLast(j);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

    
