package in.treyi.string.simplify_71;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {

    private static final String CURRENT_DIR = ".";
    private static final String PARENT_DIR = "..";

    public String simplifyPath(String path) {
        path = removeExtraSlashes(path);

        var hierarcy = getDirectoryHierarchy(path);

        var simplifiedPath = new StringBuilder();
        hierarcy.stream().forEach(dir -> simplifiedPath.append("/").append(dir));

        return simplifiedPath.isEmpty() ? "/" : simplifiedPath.toString();
    }

    private Stack<String> getDirectoryHierarchy(String path) {
        var hierarchy = new Stack<String>();
        var directories = path.split("/");

        for (var dir: directories) {
            switch (dir) {
                case PARENT_DIR -> {
                    if (!hierarchy.isEmpty())  {
                        hierarchy.pop();
                    }
                }
                case CURRENT_DIR, "" -> {}
                default -> hierarchy.push(dir);
            }
        }

        return hierarchy;
    }

    private String removeExtraSlashes(String path) {
        path = path.replaceAll("/+", "/");
        path = path.replaceAll("/$", "");
        return path;
    }
}
