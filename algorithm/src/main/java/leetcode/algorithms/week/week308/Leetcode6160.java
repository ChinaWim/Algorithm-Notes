package leetcode.algorithms.week.week308;

import java.util.Arrays;

/**
 *
 * [和有限的最长子序列]
 *
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 *
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 *
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 */
public class Leetcode6160 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int [] result = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            int sum = 0;
            int length = 0;
            for(int j = 0; j < nums.length; j ++){
                sum += nums[j];
                if(sum > queries[i]){
                    break;
                }
                length ++;
            }
            result[i] = length;
        }
        return result;
    }


    public static void main(String[] args) {
        Leetcode6160 l = new Leetcode6160();
        System.out.println(Arrays.toString(l.answerQueries(new int[]{2,3,4,5}, new int[]{1})));
    }



}
