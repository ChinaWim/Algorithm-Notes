package leetcode.algorithms.easy;


import java.util.HashSet;

/**
 * [亲密字符串]
 *
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 *
 *
 * 两个字符串长度不相等，直接false
 * 两个字符串能亲密至少需要两个字符串的字母出现次数相同
 * 在上面条件下，true只有两种情况：①只有两处不同②两个字符串完全相同，但此时需要有一个字符出现至少两次，这样交换的时候交换重复的字符即可。
 *
 */
public class Leetcode859 {


    public boolean buddyStrings(String s, String goal) {
        if(s.length() <= 1 || s.length() != goal.length()){
            return false;
        }
        int[] dictS = new int[26];
        int[] dictG = new int[26];
        int diffCount = 0;
        HashSet<Integer> sCount = new HashSet<>();
        for(int i = 0; i < s.length(); i ++){
            int sIndex = s.charAt(i);
            int gIndex = goal.charAt(i);
            dictS[sIndex - 97]++;
            sCount.add(sIndex);
            diffCount = sIndex != gIndex ? diffCount + 1 : diffCount;
        }
        for(int i = 0; i < goal.length(); i++){
            int index = goal.charAt(i);
            dictG[index - 97]++;
        }
        for(int i = 0; i < 26; i++){
            if(dictS[i] != dictG[i]){
                return false;
            }
        }

        if(diffCount > 2){
            return false;
        }else {
            if(sCount.size() == s.length() && s.equals(goal)){
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Leetcode859 le = new Leetcode859();
        System.out.println(le.buddyStrings("aaabbbbbaaaaaaaaaaaya", "aaaaaaabbbbbaaaaayaaa"));
        System.out.println(le.buddyStrings("aa", "aa"));
        System.out.println(le.buddyStrings("ab", "ab"));
        System.out.println(le.buddyStrings("aaaaaaabc", "aaaaaaacb"));

    }

}
