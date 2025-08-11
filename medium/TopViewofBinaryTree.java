class Solution {
    // Helper class to store node and its horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node temp = curr.node;
            int hd = curr.hd;

            // Store first node for each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            // Move left
            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            // Move right
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        // Add values in order of horizontal distance
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }
}
