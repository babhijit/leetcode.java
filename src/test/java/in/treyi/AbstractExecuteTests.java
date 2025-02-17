package in.treyi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public abstract class AbstractExecuteTests<TestCase> {
    private final String fileName;
    private final Type testCaseType;

    public AbstractExecuteTests(String fileName, Type testCaseType) {
        this.fileName = fileName;
        this.testCaseType = testCaseType;
    }

    protected abstract void executeTest(TestCase testCase);

    @Test
    void runTests() throws IOException {
        String testsData = IOUtils.toString(
                Objects.requireNonNull(this.getClass().getResourceAsStream(fileName)),
                StandardCharsets.UTF_8
        );
        Gson gson = new Gson();
        JsonArray testCases = (JsonArray) JsonParser.parseString(testsData);
        testCases.forEach(testCase -> executeTest(gson.fromJson(testCase, testCaseType)));
    }
}
