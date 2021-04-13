package leetcode.algorithms.easy;

/**
 * [爬楼梯]
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 *
 */
public class Leetcode70 {

    public static void main(String[] args) {
        Leetcode70 l = new Leetcode70();
        System.out.println(l.climbStairs2(44));
        System.out.println(l.climbStairs(44));

    }

    public int climbStairs(int n) {
        return this.dfs(0,n);
    }

    /**
     * 错误解法
     */
    private int dfs(int step ,int n){
        if(step > n){
            return 0;
        }
        if(step == n){
            return 1;
        }
        return dfs(step +1,n) + dfs(step +2,n);
    }

    /**
     * 正确解法：斐波那契数列
     */

    public int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for(int i = 2; i < array.length; i ++){
            array[i] = array[i - 1]+array[i - 2];
        }
        return array[array.length - 1];
    }
}
