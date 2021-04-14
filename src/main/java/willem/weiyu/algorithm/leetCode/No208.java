package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description Trie（发音类似 "try"）或者说前缀树,是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象
 * void insert(String word)向前缀树中插入字符串 word
 * boolean search(String word)如果字符串word在前缀树中，返回true（即，在检索之前已经插入）；否则，返回false
 * boolean startsWith(String prefix)如果之前已经插入的字符串word的前缀之一为prefix，返回true；否则，返回false
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * @Date 2021/4/14 14:20
 */
public class No208 {

    public static void main(String[] args) {

    }
}

/**
 * 时间复杂度：初始化为 O(1)，其余操作为 O(|S|)，其中 |S|是每次插入或查询的字符串的长度
 * 空间复杂度：O(∣T∣⋅Σ)，其中|T|为所有插入字符串的长度之和，Σ为字符集的大小，本题Σ=26
 */
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
