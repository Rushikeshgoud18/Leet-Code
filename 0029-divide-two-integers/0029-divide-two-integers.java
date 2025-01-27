class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case for Integer.MIN_VALUE
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with positive values to simplify logic
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        int quotient = 0;

        // Subtract divisorAbs from dividendAbs, doubling divisorAbs using bit shifts
        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs, multiple = 1;

            // Try to double the divisor until it is larger than dividendAbs
            while (dividendAbs >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the shifted divisor from the dividend
            dividendAbs -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign to the result
        return negative ? -quotient : quotient;
    }
}
