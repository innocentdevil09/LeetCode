import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves
 * the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash
 * '/' between two directory names. The last directory name (if it exists) must not end with a trailing '/'. Also,
 * the canonical path must be the shortest string representing the absolute path.
 *
 * Example 1:
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can
 * go.
 *
 * Example 3:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 * Example 4:
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 *
 * Constraints:
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid Unix path.
 */
public class Problem71 {

    /**
     * Method to simplify unix path
     * 1. Split the path based on slash
     * 2. For every occurrence of double period ".." move up the directory by removing the current dir from list
     * 3. Handle edge cases
     *
     * @param path
     * @return
     */
    private static String simplifyPath(String path) {
        String[] directories = path.split("/");
        List<String> list = new ArrayList<>();

        for (String dir : directories) {
            if (dir.isEmpty() || dir.equals(".")) { continue; }
            if (dir.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
                continue;
            }
            list.add(dir);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append("/");
        }
        if (!list.isEmpty()) {
            sb.append(list.get(list.size() - 1));
        }

        return sb.toString();
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String path = "/a/b/./../../c/";

        System.out.println(simplifyPath(path));
    }
}
