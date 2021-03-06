package leetcode.algorithms.easy;

/**
 * [整数反转]
 *
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 输入：x = 123
 * 输出：321
 *
 */
public class Leetcode7 {

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder("");
        int number = Math.abs(x);
        while(number > 0){
            int value = number%10;
            if (sb.length() < 1 && value ==0) {
                number = number/10;
                continue;
            }
            sb.append(value);
            number = number/10;
        }
        if (x < 0) sb.insert(0,"-");
        int value = 0;
        try{
            value = Integer.valueOf(sb.toString());
        }catch(Exception e){
            value = 0;
        }
        return value;
    }
}
