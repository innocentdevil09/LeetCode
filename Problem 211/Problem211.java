/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 *
 * Example:
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * Constraints:
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search.
 */
public class Problem211 {

    /**
     * WordDictionary class based on Trie data structure
     */
    private static class WordDictionary {

        private final int R = 26;
        private class Node {
            Node[] next = new Node[R];
            boolean isWord = false;
        }

        Node root = null;
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (temp.next[c- 'a'] == null) {
                    temp.next[c - 'a'] = new Node();
                }
                temp = temp.next[c - 'a'];
            }
            temp.isWord = true;
        }

        public boolean search(String word) {
            return searchInTrie(root, word);
        }

        private boolean searchInTrie(Node x, String word) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (Node node : x.next) {
                        if (node == null) { continue; }
                        if (searchInTrie(node, word.substring(i + 1))) {
                            return true;
                        }
                    }
                    return false;
                }
                if (x.next[c- 'a'] == null) {
                    return false;
                }
                x = x.next[c - 'a'];
            }
            return x.isWord;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
