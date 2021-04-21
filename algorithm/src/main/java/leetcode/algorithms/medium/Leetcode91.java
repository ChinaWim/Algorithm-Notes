package leetcode.algorithms.medium;

import java.util.Optional;

/**
 * [解码方法]
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 */
public class Leetcode91 {

    public static void main(String[] args) {
        Leetcode91 l = new Leetcode91();
        System.out.println(l.numDecodings2("301"));
    }

    /**
     * dfs超时算法
     */
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1 && s.charAt(0) == '0'){
            return 0;
        }
        for(int i = 1; i < s.length(); i ++){
            if(s.charAt(i) == '0' && (s.charAt(i - 1) != '1' &&  s.charAt(i - 1) != '2')){
                return 0;
            }
        }
        return this.dfs(s,0 );
    }
    public int dfs(String s,int step){
        if(step >= s.length() - 1){
            return 1;
        }
        int count = 0;
        if(step + 1 <= s.length() - 1 && '0' != s.charAt(step + 1)){
            count += dfs(s, step + 1);
        }
        if(!(s.charAt(step) > '2' || s.charAt(step) == '2'&& s.charAt(step + 1) >= '7')){
            if(step + 2 >= s.length() || '0' != s.charAt(step + 2)){
                count += dfs(s,step + 2);
            }
        }
        return count;
    }

    /**
     * dp
     */
    public int numDecodings2(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        if(s.charAt(1) == '0' && (s.charAt(0) != '1' &&  s.charAt(0) != '2')){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = (s.charAt(1) == '0' || s.charAt(1) >= '7' && s.charAt(0) == '2' || s.charAt(0) > '2') ? 1 : 2;
        for(int i = 2; i < s.length(); i ++){
            if(s.charAt(i) == '0' && (s.charAt(i - 1) != '1' &&  s.charAt(i - 1) != '2')){
                return 0;
            }
            if(s.charAt(i) == '0'){
                dp[i] = dp[i - 2];
            }else if(s.charAt(i) >= '7' && s.charAt(i - 1) == '2' || s.charAt(i - 1) > '2'){
                dp[i] = dp[i - 1];
            }else {
                if(s.charAt(i - 1) == '0'){
                    dp[i] = dp[i - 1];
                }else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

}
