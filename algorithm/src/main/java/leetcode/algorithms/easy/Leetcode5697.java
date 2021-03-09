package leetcode.algorithms.easy;

/**
 * [检查二进制字符串字段]
 *
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 *
 */
public class Leetcode5697 {


    public boolean checkOnesSegment(String s) {
        boolean has = false;
        boolean hasBreak = false;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '1'){
                if(hasBreak){
                    return false;
                }
                has = true;
            }
            if(s.charAt(i) == '0' && has){
                hasBreak = true;
            }
        }
        return has;

    }
}
