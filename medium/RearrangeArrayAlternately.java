class Solution {
    public void rearrange(int arr[]) {
        // code here\
        // Step 1: Sort the array (IMPORTANT!)
        Arrays.sort(arr);

        int n = arr.length;
        int max_idx = n - 1;
        int min_idx = 0;
        int max_elem = arr[n - 1] + 1; // Choose a number greater than the max element

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            } else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        // Final step: divide all elements by max_elem to get the result
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max_elem;
        }
    }
}
