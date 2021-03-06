package leetcode.algorithms.medium;
import java.util.HashSet;

/**
 * [无重复字符的最长子串]
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (size(s) == s.length()) return s.length();
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder wordBuf = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                char currCh = s.charAt(j);
                if (j != s.length() - 1) {
                    char ich = s.charAt(i);
                    char jch = s.charAt(j + 1);
                    if (ich == jch) {
                        break;
                    }
                }
                if(wordBuf.toString().indexOf(currCh) != -1){
                    break;
                }
                wordBuf.append(currCh);
                String str = s.substring(i, j + 1);
                max = Math.max(max, str.length());
            }
        }
        return max;
    }

    private int size(String str) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hashSet.add(str.charAt(i) + "");
        }
        return hashSet.size();
    }
}
