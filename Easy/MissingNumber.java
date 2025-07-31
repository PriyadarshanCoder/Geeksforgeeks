class Solution {
    int missingNum(int arr[]) {
        // code here
         int n = arr.length + 1; // Total numbers should be n
        long expectedSum = (long) n * (n + 1) / 2; // Use long to avoid integer overflow
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum); 
    }
}
