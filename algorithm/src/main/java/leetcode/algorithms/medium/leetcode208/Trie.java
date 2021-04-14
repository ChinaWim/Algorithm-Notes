package leetcode.algorithms.medium.leetcode208;

import java.util.ArrayList;
import java.util.List;

/**
 * [实现 Trie (前缀树)]
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 提示：
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 *
 * 考点：前缀树
 *
 */
class Trie {
    private Tree root;

    private class Tree{
        private String val;
        private List<Tree> nodes;
        private boolean flag;
        Tree(){

        }
        Tree(String val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Tree();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Tree tempToot = root;
        for(int i = 0; i < word.length(); i ++){
            String wordIndex = String.valueOf(word.charAt(i));
            List<Tree> nodes = tempToot.nodes;
            if(nodes != null && nodes.size() > 0){
                boolean has = false;
                for(Tree n : nodes){
                    if(n.val.equals(wordIndex)){
                        tempToot = n;
                        has = true;
                        break;
                    }
                }
                if(!has){
                    Tree newNode = new Tree(wordIndex);
                    nodes.add(newNode);
                    tempToot.nodes = nodes;
                    tempToot = newNode;
                }
            }else {
                nodes = new ArrayList<>();
                Tree newNode = new Tree(wordIndex);
                nodes.add(newNode);
                tempToot.nodes = nodes;
                tempToot = newNode;
            }

            if(i == word.length() - 1){
                tempToot.flag = true;
            }

        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchAction(word,false);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchAction(prefix,true);

    }

    private boolean searchAction(String word,boolean like) {
        Tree tempToot = root;
        for(int i = 0 ; i < word.length(); i ++){
            String wordIndex = String.valueOf(word.charAt(i));
            boolean has = false;
            if(tempToot != null && tempToot.nodes!= null && tempToot.nodes.size() > 0){
                List<Tree> nodes = tempToot.nodes;
                for (int j = 0; j < nodes.size(); j ++) {
                    Tree nodeTree = nodes.get(j);
                    if(nodeTree != null && wordIndex.equals(nodeTree.val)){
                        if(!like && i == word.length() - 1 ){
                            return nodeTree.flag;
                        }
                        tempToot = nodeTree;
                        has = true;
                        break;
                    }
                }
            }
            if(!has){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("appl");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("apple"));
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("appl"));

    }



}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */