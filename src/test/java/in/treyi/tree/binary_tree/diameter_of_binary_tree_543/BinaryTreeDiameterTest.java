package in.treyi.tree.binary_tree.diameter_of_binary_tree_543;

import in.treyi.AbstractExecuteTests;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeDiameterTest extends AbstractExecuteTests<TestCase> {

    private static final String FILE_NAME = "BinaryTreeDiameterTests.json";

    public BinaryTreeDiameterTest() {
        super(FILE_NAME, TestCase.class);
    }

    @Override
    protected void executeTest(TestCase testCase) {
        var solution = new BinaryTreeDiameter();
        int actual = solution.diameterOfBinaryTree(testCase.getRoot());
        assertEquals(testCase.expected, actual);
    }
}