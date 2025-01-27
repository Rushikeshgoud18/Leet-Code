class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for placing non-val elements

        // Iterate through the array with pointer j
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not equal to val, move it to the front
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;  // Increment the pointer for the next valid element
            }
        }

        // Return the number of elements that are not equal to val
        return i;
    }
}
