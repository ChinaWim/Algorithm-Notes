package leetcode.algorithms.week.week293;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 移除字母异位词后的结果数组
 *
 * 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
 *
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
 *
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 *
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
 *
 *
 * @author:
 * @create: 2022-05-15 10:35
 **/
public class Leetcode5234{

    public static void main(String[] args){
        Leetcode5234 data = new Leetcode5234();
        data.removeAnagrams(new String[]{"yjonq","yqnoj","oyqjn","nqoyj","onjqy","joqyn","qynjo","jynoq"});
    }



    public List<String> removeAnagrams(String[] words) {
        List<String> wordsList = Arrays.stream(words).collect(Collectors.toList());
        while(wordsList.size() > 1){
            boolean over = false;
            for(int i = 1;i < wordsList.size();i++){
                String before = wordsList.get(i - 1);
                String after = wordsList.get(i);
                if(this.compare(before,after)){
                    wordsList.remove(i);
                    break;
                }
                if(i == wordsList.size() - 1){
                    over = true;
                }
            }
            if(over){
                break;
            }
        }
       return wordsList;
    }

    private boolean compare(String before,String after){
        if(before.length() != after.length()){
            return false;
        }
        char[] beforeCharArray = before.toCharArray();
        char[] afterCharArray = after.toCharArray();
        Arrays.sort(beforeCharArray);
        Arrays.sort(afterCharArray);
        for(int i = 0; i < beforeCharArray.length; i++){
            if(beforeCharArray[i] != afterCharArray[i]){
                return false;
            }
        }
        return true;
    }




}
