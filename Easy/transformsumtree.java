/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public void toSumTree(Node root) {
        transform(root);
    }

    private int transform(Node node) {
        if (node == null) return 0;

        // 1. Recursively get sum of left subtree
        int leftSum = transform(node.left);

        // 2. Recursively get sum of right subtree
        int rightSum = transform(node.right);

        // 3. Store the original value
        int oldValue = node.data;

        // 4. Update node to sum of left and right subtree values
        node.data = leftSum + rightSum;

        // 5. Return sum of this subtree including original node's value
        return node.data + oldValue;
    }
}
