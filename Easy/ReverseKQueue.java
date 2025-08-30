import java.util.*;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return q;

        Stack<Integer> stack = new Stack<>();

        // Step 1: Take first k elements from queue and push to stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Pop from stack and put back into queue (this reverses them)
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move the remaining elements (size - k) to back to preserve order
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }

        return q;
    }
}
