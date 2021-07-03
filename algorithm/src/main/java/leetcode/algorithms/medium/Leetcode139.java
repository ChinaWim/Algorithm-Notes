package leetcode.algorithms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * [单词拆分]
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 *
 */
public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return this.dfs(false,s,0,"",wordDict);
    }

    //todo tle
    private boolean dfs(boolean result,String s,int step,String data,List<String> wordDict){
        if (data.length() > s.length() || result) {
            return result;
        }
        if (data.equals(s)) {
            result = true;
            return result;
        }
        for (int i = 0; i < wordDict.size() * 2; i++) {
            if(result){
                break;
            }
            result = dfs(result,s, step + 1, data + wordDict.get(i % wordDict.size()), wordDict);
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode139 leetcode139 = new Leetcode139();
        System.out.println(leetcode139.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}
