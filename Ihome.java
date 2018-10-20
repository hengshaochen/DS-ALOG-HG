import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter yourcode here. Read input from STDIN. Print output to STDOUT */
        new Solution(args);
    }
    

class Trie {
    class TrieNode {
        TrieNode[] child;
        int counter;
        TrieNode() {
            child = new TrieNode[26];
            counter = 1;
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
            // 不存在該字母的Node就建立該字母的Node
            int index = (int)(word.charAt(i) - 'A');
            if (cur.child[index] == null) {
                cur.child[index] = new TrieNode();
            } else {
                // 已經存在, counter++
                cur.child[index].counter++;
            }
            cur = cur.child[index];
        }
    }


    public int traverse(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'A');
            // 找不到這個字母就return null
            if (cur.child[index] == null) {
                return 0;
            } 
            // 找到 繼續找下去 直到最後一個char才結束
            cur = cur.child[index];
        }
        return cur.counter;
    }
}

    public Solution(String args[]) {
        Scanner reader = new Scanner(System.in);
        int N = 0;
        Trie t = new Trie();
        int lines = 0;
        while(reader.hasNext()) {
            if (reader.hasNextInt()) {
                lines = reader.nextInt();
                reader.nextLine();  // move the reader pointer to nextLine (skip the int)
                N++;
            } else if (reader.hasNextLine()) {
                if (N == 1) {
                    // Belong to single user's chain
                    String cur = reader.nextLine().replaceAll("-", "");
                    t.insert(cur);
                } else if (N == 2) {
                    // Belong to query group chain
                    String cur = reader.nextLine().replaceAll("-", "");
                    System.out.println(t.traverse(cur));
                }
            }
        }

    }
    
    /*public Solution(String args[]) {
        Scanner reader = new Scanner(System.in);
        boolean N = true;
        Trie t = new Trie();
        while(reader.hasNextInt()) {
            int lines = reader.nextInt();
            //System.out.println(lines);
            if (N == true) {
                int i = 0;
                while (reader.hasNextLine() && i < lines) {
                    String cur = reader.nextLine();
                    t.insert(cur);
                    i++;
                    System.out.println(cur);
                }
                N = false;
            } else {
                for (int i = 0; i < lines; i++) {
                    System.out.println(t.traverse(reader.nextLine()));
                }
            }
        }

    }*/
    
    

    
    
}