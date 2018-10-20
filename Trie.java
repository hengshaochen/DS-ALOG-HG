// "static void main" must be defined in a public class.
public class Main {

class Trie {
    class TrieNode {
        TrieNode[] child;
        boolean is_word;
        TrieNode() {
            child = new TrieNode[26];
            is_word = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            // 不存在該字母的Node就建立該字母的Node
            if (cur.child[index] == null) {
                cur.child[index] = new TrieNode();
            }
            cur = cur.child[index];
        }
        // 最後一個字母的boolean設為true
        cur.is_word = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = traverse(word);
        if (cur != null && cur.is_word == true) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = traverse(prefix);
        if (cur != null) {
            return true;
        }
        return false;
    }

    public TrieNode traverse(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            // 找不到這個字母就return null
            if (cur.child[index] == null) {
                return null;
            }
            // 找到 繼續找下去 直到最後一個char才結束
            cur = cur.child[index];
        }
        return cur;
    }
    
    List<String> getAllPrefixString(String prefix) {
        TrieNode start = traverse(prefix);
        List<String> ans = new ArrayList<>();
        
        if (start == null) {
            return ans;
        }
        
        helper(new StringBuilder(prefix), ans, start);
        
        return ans;
    }
    
    void helper(StringBuilder cur, List<String> ans , TrieNode curNode) {
        if (curNode.is_word == true) {
            ans.add(new String(cur));
        }
        
        for (int i = 0; i < 26; i++) {
            if (curNode.child[i] == null) {
                continue;
            }
            cur.append((char)(i + 'a'));
            helper(cur, ans, curNode.child[i]);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abcd");
        t.insert("abcz");
        t.insert("az");
        t.insert("abbbbb");
        
        System.out.println(t.getAllPrefixString("abb"));
    }
}