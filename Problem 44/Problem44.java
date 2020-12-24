import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'
 */
public class Problem44 {

    private static class Digraph {
        private int v;
        private List<Integer>[] bag;

        Digraph(int v) {
            this.v = v;
            bag = (List<Integer>[]) new List[v];
            for (int i = 0; i < v; i++) {
                bag[i] = new ArrayList<>();
            }
        }

        void addEdge(int v, int w) {
            bag[v].add(w);
        }

        int V() { return v; }

        List<Integer> adj(int v) { return bag[v]; }
    }

    private static class DirectedDFS {
        private boolean[] marked;

        DirectedDFS(Digraph G, int vertex) {
            marked = new boolean[G.V()];
            dfs(G, vertex);
        }

        DirectedDFS(Digraph G, List<Integer> vertices) {
            marked = new boolean[G.V()];
            for (int vertex : vertices) {
                if (!marked[vertex]) {
                    dfs(G, vertex);
                }
            }
        }

        private void dfs(Digraph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }

        boolean marked(int v) { return marked[v]; }
    }

    /**
     * Approach is called NFA. Non-deterministic finite automata
     * Highly inefficient, and memory consuming approach. Theoretically will work for all cases.
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch(String s, String p) {
        if (p.isEmpty()) { return s.isEmpty(); }

        Digraph G = buildGraph(p.toCharArray());
        DirectedDFS dfs = new DirectedDFS(G, 0);

        List<Integer> pc = new ArrayList<>();
        for (int k = 0; k < G.V(); k++) {
            if (dfs.marked(k)) { pc.add(k); }
        }

        int i = 0;
        for (i = 0; i < s.length(); i++) {
            List<Integer> match = new ArrayList<>();
            for (int v : pc) {
                if (v == p.length()) { continue; }
                if (p.charAt(v) == s.charAt(i) || p.charAt(v) == '?') {
                    match.add(v + 1);
                }
                if (p.charAt(v) == '*') {
                    match.add(v);
                    match.add(v + 1);
                }
            }
            if (match.isEmpty()) { break; }
            dfs = new DirectedDFS(G, match);
            pc = new ArrayList<>();
            for (int j = 0; j < G.V(); j++) {
                if (dfs.marked(j)) { pc.add(j); }
            }
        }

        return i == s.length() && pc.contains(p.length());
    }

    private static Digraph buildGraph(char[] regexp) {
        Digraph G = new Digraph(regexp.length + 1);

        for (int i = 0; i < regexp.length; i++) {
            if (regexp[i] == '*') {
                G.addEdge(i, i + 1);
            }
        }
        return G;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";

        System.out.println(isMatch(s, p));
    }
}
