class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;  // If target is found, return its index
            } else if (nums[mid] < target) {
                left = mid + 1;  // Target is to the right
            } else {
                right = mid - 1;  // Target is to the left
            }
        }

        // If the target is not found, left will be the insertion point
        return left;
    }
}
