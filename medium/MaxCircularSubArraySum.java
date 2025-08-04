class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
          int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;
        int minSum = Integer.MAX_VALUE;
        int curMin = 0;

        for (int num : arr) {
            // Standard Kadane’s for max subarray sum
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            // Modified Kadane’s for min subarray sum
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            // Total sum of the array
            totalSum += num;
        }

        // If all elements are negative, return maxSum (cannot wrap)
        if (maxSum < 0)
            return maxSum;

        // Otherwise, return the maximum of:
        // 1. Non-circular max subarray sum (maxSum)
        // 2. Circular max subarray sum = totalSum - minSum
        return Math.max(maxSum, totalSum - minSum);
    }
}
