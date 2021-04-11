package leetcode.algorithms.medium;

import java.util.*;

/**
 * [丑数 II]
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 *
 * 暴力法,三指针，打表法
 */
public class Leetcode264 {
    HashSet<Integer> set = new HashSet();
    List<Integer> table = new ArrayList<>();
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        for(int i = 1; i <= 100000000; ++i){
            if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0){
                if(this.isNum(i)){
                    table.add(i);
                    set.add(i);
                }
            }
        }
        return table.get(n - 2);
    }

    private boolean isNum(int num){
        int numTemp = num;
        while(numTemp != 1){
            if(set.contains(numTemp)){
                return true;
            }
            boolean hasBreak = false;
            for(int i = 2; i <= 5; ++i){
                if(numTemp % i == 0){
                    if(i != 2 && i != 3 && i != 5){
                        return false;
                    }
                    numTemp = numTemp / i;
                    hasBreak = true;
                    break;
                }
            }
            if(!hasBreak){
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力法
     */

    public int nthUglyNumber3(int n) {
        List<Long> valueList = new ArrayList<>();
        for(long i = 1; i < Integer.MAX_VALUE; i = i * 2){
            for(long j = i; j < Integer.MAX_VALUE; j = j * 3){
                for(long k = j; k < Integer.MAX_VALUE; k = k * 5){
                    valueList.add(k);
                }
            }
        }
        Long[] array = new Long[valueList.size()];
        valueList.toArray(array);
        Arrays.sort(array);
        return array[n - 1].intValue();
    }


    /**
     * 三指针，正确解法，动态规划
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int x = 2 * dp[a];
            int y = 3 * dp[b];
            int z = 5 * dp[c];
            dp[i] = Math.min(Math.min(x,y), z);
            if(x == dp[i]){
                a ++;
            }
            if(y == dp[i]){
                b ++;
            }
            if(z == dp[i]) {
                c ++;
            }

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Leetcode264 l = new Leetcode264();
        System.out.println(l.nthUglyNumber3(10));
    }
}
