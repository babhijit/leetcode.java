package in.treyi.tree.binary_tree.odd_even_tree_1609;

import in.treyi.AbstractExecuteTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddEvenTreeTest extends AbstractExecuteTests<TestCase> {

    private static final String FILE_NAME = "OddEvenTreeTests.json";

    public OddEvenTreeTest() {
        super(FILE_NAME, TestCase.class);
    }

    @Override
    protected void executeTest(TestCase testCase) {
        var solution = new OddEvenTree();
        var actual = solution.isEvenOddTree(testCase.getRoot());
        assertEquals(testCase.expected, actual);
    }
}