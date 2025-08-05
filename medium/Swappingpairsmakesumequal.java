// User function Template for Java

class Solution {
         // Helper function to calculate the sum of an array
    private int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Helper function to calculate the target difference
    private int getTarget(int[] a, int[] b) {
        int sumA = getSum(a);
        int sumB = getSum(b);

        if ((sumA - sumB) % 2 != 0) {
            return Integer.MIN_VALUE; // If target isn't feasible
        }
        return (sumA - sumB) / 2;
    }

    boolean findSwapValues(int[] a, int[] b) {
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Calculate the target value
        int target = getTarget(a, b);

        // If target is not feasible, return false
        if (target == Integer.MIN_VALUE) {
            return false;
        }

        int i = 0, j = 0;

        // Use two-pointer technique to find if swap is possible
        while (i < a.length && j < b.length) {
            int diff = a[i] - b[j];

            if (diff == target) {
                return true; // Swap is possible
            } else if (diff < target) {
                i++;
            } else {
                j++;
            }
        }

        // If no valid swap is found
        return false;
    }
}
