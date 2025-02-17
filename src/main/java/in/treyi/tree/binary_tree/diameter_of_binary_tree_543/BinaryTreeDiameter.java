package in.treyi.tree.binary_tree.diameter_of_binary_tree_543;

import in.treyi.tree.binary_tree.TreeNode;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

/**
 * Time Complexity: O(N). Each node is processed exactly once.
 * Space Complexity: O(N) This is the worst case when the tree is completely skewed.
 *                  But for a balanced binary tree, this would be O(log N)
 */

public class BinaryTreeDiameter {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;

        longestPath(root);

        return this.diameter;
    }

    private int longestPath(TreeNode node) {
        if (isNull(node)) {
            return 0;
        }

        var leftLongestPath = longestPath(node.left);
        var rightLongestPath = longestPath(node.right);

        this.diameter = max(this.diameter, leftLongestPath + rightLongestPath);

        // return the longest path ... max of the left or right path and account for the current node (+1)
        return max(leftLongestPath, rightLongestPath) + 1;
    }
}
