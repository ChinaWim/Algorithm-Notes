package leetcode.algorithms.medium;

/**
 * [平方数之和]
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 */
public class Leetcode633 {
    public static void main(String[] args) {
        Leetcode633 l = new Leetcode633();
        System.out.println(l.judgeSquareSum(100000));
    }

    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.ceil(Math.sqrt(c));
        while(l <= r){
            long v1 =l*l;
            long v2 =r*r;
            long v =  v1 + v2 ;
            if(v == c){
                return true;
            }
            if(v > c){
                r--;
            }
            if(v < c){
                l++;
            }

        }
        return false;
    }
}
