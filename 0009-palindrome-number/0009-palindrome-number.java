class Solution {
    public boolean isPalindrome(int x) {
        // Edge case: negative numbers and numbers that end with 0 but are not 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length, x should be equal to reversedHalf
        // For odd length, we can ignore the middle digit by reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
