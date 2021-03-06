package leetcode.algorithms.easy;


import java.util.Arrays;
import java.util.HashMap;

/**
 * [有效的字母异位词]
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 *
 */
public class Leetcode242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        for(int i = 0; i < sCharArray.length; i ++){
            if(sCharArray[i] != tCharArray[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            Integer sCount = sMap.get(s.charAt(i));
            Integer sAddCount = sCount == null ? 1 : sCount+1 ;
            sMap.put(s.charAt(i),sAddCount);

            Integer tCount = tMap.get(t.charAt(i));
            Integer tAddCount = tCount == null ? 1 : tCount+1 ;
            tMap.put(t.charAt(i),tAddCount);
        }
        if(tMap.size() != sMap.size()){
            return false;
        }
        for (Character tKey : tMap.keySet()) {
            Integer sV = sMap.get(tKey);
            if(sV == null){
                return false;
            }
            if(!tMap.get(tKey).equals(sV)){
                return false;
            }
        }
        return true;
    }

}
