package in.treyi.tree.binary_tree.odd_even_tree_1609;

import in.treyi.tree.binary_tree.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;


public class OddEvenTree {

    private static final BiPredicate<TreeNode, TreeNode> DECR_COMP = (prev, cur) -> cur.val < prev.val;

    private static final BiPredicate<TreeNode, TreeNode> INCR_COMP = (prev, cur) -> cur.val > prev.val;

    private static boolean isEven(int n) {
        return !isOdd(n);
    }

    private static boolean isOdd(int n) {
        return (n & 1) > 0;
    }

    private boolean addToBranch(List<TreeNode> branch, TreeNode node, int level) {
        boolean nodesWithEvenValues = isOdd(level);
        Predicate<TreeNode> valueTest = nodesWithEvenValues ? (n) -> isEven(n.val) : (n) -> isOdd(n.val);
        BiPredicate<TreeNode, TreeNode> orderTest = nodesWithEvenValues ? DECR_COMP : INCR_COMP;
        if (!valueTest.test(node)) {
            return false;
        }

        if (!branch.isEmpty()) {
            int lastIndex = branch.size() - 1;
            var lastNode = branch.get(lastIndex);
            if (!orderTest.test(lastNode, node)) {
                return false;
            }
        }

        branch.add(node);

        return true;
    }

    public boolean isEvenOddTree(@NotNull TreeNode root) {
        List<TreeNode> currentBranch = new LinkedList<>();

        int level = 0;

        if (!addToBranch(currentBranch, root, level++)) {
            return false;
        }

        while (!currentBranch.isEmpty()) {
            if (!getAllChildren(currentBranch, level++)) {
                return false;
            }
        }

        return true;
    }

    private boolean getAllChildren(List<TreeNode> currentBranch, int level) {
        List<TreeNode> nextBranch = new LinkedList<>();

        for (var node : currentBranch) {
            if (!addChildrenToBranch(nextBranch, node, level)) {
                return false;
            }
        }

        currentBranch.clear();
        currentBranch.addAll(nextBranch);

        return true;
    }

    private boolean addChildrenToBranch(List<TreeNode> branch, TreeNode node, int level) {
        if (nonNull(node.left) && !addToBranch(branch, node.left, level)) {
            return false;
        }

        return !nonNull(node.right) || addToBranch(branch, node.right, level);
    }
}
