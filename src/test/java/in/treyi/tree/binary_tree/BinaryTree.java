package in.treyi.tree.binary_tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    private final int N;
    public final TreeNode root;

    public BinaryTree(final int[] tree) {
        Objects.requireNonNull(tree, "tree must not be null");
        N = tree.length;
        if (tree.length > 0) {
            root = createTree(tree, 0);
        } else {
            root = null;
        }
    }

    public BinaryTree(final Integer[] tree, final boolean compact) {
        Objects.requireNonNull(tree, "tree must not be null");
        N = tree.length;

        if (N == 0) {
            root = null;
        } else {
            if (!compact) {
                root = createTree(tree, 0);
            } else {
                root = createTreeFromCompactArray(tree);
            }
        }
    }

    public BinaryTree(final Integer[] tree) {
        this(tree, false);
    }

    private TreeNode createTree(final Integer[] tree, int index) {
        if (N <= index) {
            return null;
        }

        var node = new TreeNode(tree[index++]);
        int left = 2 * index - 1;
        int right = 2 * index;
        if (left < N) {
            if (Objects.nonNull(tree[left])) {
                node.left = createTree(tree, 2 * index - 1);
            }
        }

        if ((right < N) && Objects.nonNull(tree[right])) {
            node.right = createTree(tree, 2 * index);
        }
        return node;
    }

    private TreeNode createTreeFromCompactArray(Integer[] tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(tree[0]);

        int index = 0;
        queue.offer(root);
        while (!queue.isEmpty() && (index < N)) {
            var node = queue.poll();
            int left = index + 1;
            if ((left < N) && Objects.nonNull(tree[left])) {
                node.left = new TreeNode(tree[left]);
                queue.offer(node.left);
            }
            int right = 2 + index;
            if ((right < N) && (Objects.nonNull(tree[right]))) {
                node.right = new TreeNode(tree[right]);
                queue.offer(node.right);
            }
            index = right;
        }

        return root;
    }


    private TreeNode createTree(final int[] tree, int index) {
        if (N <= index) {
            return null;
        }

        var node = new TreeNode(tree[index++]);
        node.left = createTree(tree, 2 * index - 1);
        node.right = createTree(tree, 2 * index);
        return node;
    }

    public static boolean equals(TreeNode a, TreeNode b) {
        if (Objects.isNull(a) && Objects.isNull(b)) {
            return true;
        }

        if (Objects.nonNull(a) && Objects.nonNull(b)) {
            if (Objects.equals(a.val, b.val)) {
                return equals(a.left, b.left) && equals(a.right, b.right);
            }
        }

        return false;
    }
}
