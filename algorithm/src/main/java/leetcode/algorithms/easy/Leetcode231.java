package leetcode.algorithms.easy;

/**
 * @Description:
 * @Author
 * @Date create in 2021/5/30 13:08
 */

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 */
public class Leetcode231 {

    /**
     * 正确做法
     * @return
     */
    public boolean isPowerOfTwo2(int n){
        return n > 0 && (n & (n-1)) == 0;
    }


    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if (n <= 1) {
            return false;
        }
        int temp = n;
        while(temp != 1){
            if(temp % 2 != 0){
                return false;
            }
            temp = temp / 2;
        }
        return true;
    }



    public static void main(String[] args) {
        Leetcode231 l = new Leetcode231();
        System.out.println(l.isPowerOfTwo(1));

    }
}
