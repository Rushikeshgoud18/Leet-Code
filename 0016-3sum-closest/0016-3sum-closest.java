import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        
        // Variable to keep track of the closest sum
        int closestSum = Integer.MAX_VALUE;
        
        // Iterate through the array, fixing one element at a time
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicate elements for 'i'
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Two pointers, one starting after 'i' and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            // Use the two-pointer technique to find the closest sum
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update the closest sum if needed
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                // Move the pointers based on the sum comparison to the target
                if (sum < target) {
                    left++;  // Need a larger sum, move the left pointer to the right
                } else if (sum > target) {
                    right--; // Need a smaller sum, move the right pointer to the left
                } else {
                    return sum; // If the sum equals the target, return it immediately
                }
            }
        }
        
        return closestSum; // Return the closest sum after iterating
    }
}
