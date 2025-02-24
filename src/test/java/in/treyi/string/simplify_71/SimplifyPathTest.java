package in.treyi.string.simplify_71;

import in.treyi.AbstractExecuteTests;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest extends AbstractExecuteTests<TestCase> {

    private static final String FILE_NAME = "SimplifyPathTests.json";

    public SimplifyPathTest() {
        super(FILE_NAME, TestCase.class);
    }


    @Override
    protected void executeTest(TestCase testCase) {
        var solution = new SimplifyPath();
        var actual = solution.simplifyPath(testCase.path);
        assertEquals(testCase.expected, actual);
    }
}