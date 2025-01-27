class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If we find the target
            if (nums[mid] == target) {
                return mid;
            }

            // Left part is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // Target is in the left part
                } else {
                    left = mid + 1;   // Target is in the right part
                }
            }
            // Right part is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target is in the right part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }
        }
        
        return -1; // Target not found
    }
}
