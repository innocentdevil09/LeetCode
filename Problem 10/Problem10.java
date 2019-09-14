import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class Problem10 {

    /**
     * Digraph class which represents the graph formed by the pattern string
     */
    private static class Digraph {

        private List<Integer>[] bag;
        private int V;

        /**
         * Constructor
         *
         * @param V
         */
        Digraph(int V) {
            this.V = V;
            bag = (List<Integer>[]) new List[V];
            for (int i = 0; i < V; i++) {
                bag[i] = new ArrayList<>();
            }
        }

        /**
         * Method to add edges between two vertices
         *
         * @param v
         * @param w
         */
        void addEdge(int v, int w) {
            bag[v].add(w);
        }

        /**
         * Method to get all adjoining vertices connected to vertex v
         *
         * @param v
         */
        List<Integer> adj(int v) {
            return bag[v];
        }

        /**
         * Method to return size of graph
         */
        int V() { return V; }
    }

    /**
     * Class defined to do dfs over a given digraph
     */
    private static class DirectedDFS {

        private boolean[] marked;

        /**
         * Constructor for a single vertex
         *
         * @param G
         * @param vertex
         */
        DirectedDFS(Digraph G, int vertex) {
            marked = new boolean[G.V()];
            dfs(G, vertex);
        }

        /**
         * Constructor for a list of vertices
         *
         * @param G
         * @param vertices
         */
        DirectedDFS(Digraph G, List<Integer> vertices) {
            marked = new boolean[G.V()];
            for (int vertex : vertices) {
                if (!marked[vertex]) {
                    dfs(G, vertex);
                }
            }
        }

        /**
         * Method to do a dfs search over a given graph
         *
         * @param G
         * @param v
         */
        private void dfs(Digraph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }

        /**
         * Method to check if the given vertex is covered in the dfs search
         *
         * @param v
         */
        boolean marked(int v) { return marked[v]; }
    }

    /**
     * Method to build graph for the given pattern
     *
     * @param regex
     */
    private static Digraph buildGraph(char[] regex) {
        Digraph G = new Digraph(regex.length + 1);
        for (int i = 0; i < regex.length; i++) {
            if (i < regex.length - 1 && regex[i + 1] == '*') {
                G.addEdge(i, i + 1);
                G.addEdge(i + 1, i);
            }
            if (regex[i] == '*') {
                G.addEdge(i, i + 1);
            }
        }
        return G;
    }

    /**
     * Method to check if the given pattern p checks out the given string s
     * Algo :-
     * The algo used here is via creating non-deterministic finite state automata (NFA)
     * 1. Maintain set of all possible states that NFA could be in after reading in the first i characters
     *
     * How to get all the states that we could reach?
     * 2. Read input next character and find states reachable by that character
     * 3. When no more input characters, accept if any state reachable is an accept state; reject otherwise
     *
     * @param s
     * @param p
     */
    private static boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) { return true; }
        if (p.isEmpty()) { return false; }

        Digraph G = buildGraph(p.toCharArray());
        DirectedDFS dfs = new DirectedDFS(G, 0);
        List<Integer> pc = new ArrayList<>();
        for (int k = 0; k < G.V(); k++) {
            if (dfs.marked(k)) { pc.add(k); }
        }

        int i = 0;
        while (i < s.length()) {
            List<Integer> match = new ArrayList<>();
            for (int v : pc) {
                if (v == p.length()) { continue; }
                if (p.charAt(v) == s.charAt(i) || p.charAt(v) == '.') {
                    match.add(v + 1);
                }
            }
            if (match.isEmpty()) { break; }
            dfs = new DirectedDFS(G, match);
            pc = new ArrayList<>();
            for (int k = 0; k < G.V(); k++) {
                if (dfs.marked(k)) { pc.add(k); }
            }
            i++;
        }
        return i == s.length() && pc.contains(p.length());
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";

        String match = isMatch(s, p) ? "MATCH" : "NOT MATCHED";
        System.out.println(match);
    }
}
