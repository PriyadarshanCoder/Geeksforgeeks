class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
         int n = arr.length;
        int total = 0;

        // First, calculate total sum of array
        for (int num : arr) total += num;

        int leftSum = 0;
        // Now check for equilibrium in the same loop
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - arr[i];
            if (leftSum == rightSum) return i;
            leftSum += arr[i];
        }

        return -1;
    }
}
