package in.treyi.tree.binary_tree.diameter_of_binary_tree_543;

import in.treyi.tree.binary_tree.BinaryTree;
import in.treyi.tree.binary_tree.TreeNode;

public class TestCase {
    Integer [] root = null;
    int expected;

    public TreeNode getRoot() {
        var tree = new BinaryTree(this.root, false);
        return tree.root;
    }
}
