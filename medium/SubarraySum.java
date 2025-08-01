class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        long totalSum = 0;  // Use long to avoid overflow during calculation
        
        for (int i = 0; i < n; i++) {
            // Contribution of arr[i] to total sum
            long contribution = (long) arr[i] * (i + 1) * (n - i);
            totalSum += contribution;
        }
        
        // Since it's guaranteed to fit in 32-bit, cast back to int
        return (int) totalSum;
    }
}
