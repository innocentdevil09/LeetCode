/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
 * in a dataset of strings. There are various applications of this data structure, such as autocomplete and
 * spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false
 * otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
 * prefix, and false otherwise.
 *
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */
public class Problem208 {

    /**
     * Trie data structure
     */
    private static class Trie {

        private final int R = 26;
        private class Node {
            Node[] next = new Node[R];
            boolean isWord = false;
        }

        Node root = null;
        /** Initialize your data structure here. */
        public Trie() { root = new Node(); }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (temp.next[c - 'a'] == null) {
                    temp.next[c - 'a'] = new Node();
                }
                temp = temp.next[c - 'a'];
            }
            temp.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (temp.next[c - 'a'] == null) { return false; }
                temp = temp.next[c - 'a'];
            }
            return temp.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node temp = root;
            for (char c : prefix.toCharArray()) {
                if (temp.next[c - 'a'] == null) { return false; }
                temp = temp.next[c - 'a'];
            }
            return true;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
