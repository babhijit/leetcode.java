package in.treyi.tree.binary_tree.odd_even_tree_1609;

import in.treyi.tree.binary_tree.BinaryTree;
import in.treyi.tree.binary_tree.TreeNode;

public class TestCase {
    Integer[] root;
    boolean expected;

    public TreeNode getRoot() {
        var tree = new BinaryTree(this.root, true);
        return tree.root;
    }

}
