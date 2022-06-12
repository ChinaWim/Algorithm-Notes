package leetcode.algorithms.medium;

import java.util.*;

/**
 * @description: [查找和替换模式]
 *
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * 你可以按任何顺序返回答案。
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *
 *
 * TIP：
 * 1.双映射方法 单词ABC与单词QWE比较，A映射到集合1的Q，Q映射到集合2的A，依次映射后比较
 * 2.单映射方法 单词ABC与单词QWE比较，A映射到集合1的1，Q映射到集合1的1，依次映射后比较
 *
 *
 * @create: 2022-06-12 16:23
 **/
public class Leetcode890{

    public List<String> findAndReplacePattern(String[] words,String pattern) {
        List<String> result = new ArrayList<>();
        String patternParse = this.parseString(pattern);
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            String wordParse = this.parseString(word);
            if(wordParse.equals(patternParse)){
                result.add(word);
            }
        }
        return result;
    }


    //单映射
    private String parseString(String word){
        HashMap<Character,Integer> wordMap = new HashMap<>();
        wordMap.put(word.charAt(0),0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char w = word.charAt(i);
            wordMap.putIfAbsent(w,i);
            Integer index = wordMap.get(w);
            String appendWord = String.valueOf(index);
            sb.append(appendWord);
        }
        return sb.toString();
    }


}
