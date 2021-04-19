package leetcode.algorithms.hard;

import java.util.*;

/**
 * [扰乱字符串]
 *
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法 ，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 *
 * todo
 *
 */
public class Leetcode87 {

    public static void main(String[] args) {
        Leetcode87 l = new Leetcode87();
        System.out.println(l.isScramble("abcd", "bdac"));
    }
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(!String.valueOf(chars1).equals(new String(chars2))){
            return false;
        }
        char firstChar = s1.charAt(0);
        char lastChar = s1.charAt(s1.length() - 1);
        int[] box = new int[s1.length()];

        for(int i = 0; i < s2.length() - 1; i ++){
            boolean has = false;
            char indexChar = s2.charAt(i);
            char afterIndexChar = s2.charAt(i + 1);
            if((afterIndexChar == firstChar || afterIndexChar == lastChar)){
                continue;
            }
            if(indexChar == firstChar || indexChar  == lastChar){
                if(i > 0 && i < s2.length() - 1){
                  char beforeIndexChar = s2.charAt(i - 1);
                  has = this.isHas(s1, box, indexChar, beforeIndexChar, has);
                  if(!has){
                   has = this.isHas(s1, box, indexChar, afterIndexChar, has);
                  }
                }else if(i == 0){
                    has = this.isHas(s1, box, indexChar, afterIndexChar, has);
                }else if(i == s2.length() - 1){
                    char beforeIndexChar = s2.charAt(i - 1);
                    has = this.isHas(s1, box, indexChar, beforeIndexChar, has);
                }

            }else {
                has = this.isHas(s1, box, indexChar, afterIndexChar, has);
            }
            if(!has){
                return false;
            }

        }
        return true;
    }

    private boolean isHas(String s1, int[] box, char indexChar, char afterIndexChar, boolean has) {
        for(int j = 0; j < s1.length(); j ++){
            if(s1.charAt(j) == indexChar){
                for(int k = 0; k < s1.length(); k++){
                    if(s1.charAt(k) == afterIndexChar && box[k] == 0){
                        if(Math.abs(j - k) <= 2){
                            box[k] = 1;
                            has = true;
                            break;
                        }
                    }
                }
            }
            if(has){
                break;
            }
        }
        return has;
    }

}
