package leetcode.algorithms.medium;

import java.util.Arrays;

/**
 * [比特位计数]
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 考点：移动最后一位
 * 方法一：i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
 *
 * 方法二：i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
 */
public class Leetcode338 {

    public static void main(String[] args) {
        Leetcode338 demo = new Leetcode338();
        System.out.println(Arrays.toString(demo.countBits(10)));
    }

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 0; i <= num; i ++){
            if(i > 1){
                result[i] = result[(i & (i - 1))] + 1;
            }else {
                result[i] = this.getCount(i);
            }

        }
        return result;
    }

    private int getCount(int num){
        int temp = num;
        int count = 0;
        while(temp > 0){
            int d = temp % 2;
            if(d == 1){
                count ++;
            }
            temp = temp / 2;
        }
       return count;
    }
}
