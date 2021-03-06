package leetcode.algorithms.medium;

/**
 * [绝对差不超过限制的最长连续子数组]
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 考点：滑动窗口
 */
public class Leetcode1438 {

    public static void main(String[] args) {
        int[] nums = new int []{4,2,2,2,4,4,2,2};
        Leetcode1438 l = new Leetcode1438();
        System.out.println(l.longestSubarray(nums, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        int right = 0;
        int left = 0;
        int i = 0;
        int j = 0;
        int max = nums[0];
        int min = nums[0];
        int result = 0;
        while(right < nums.length){
            if(nums[right] >= max){
                max = nums[right];
                i = right;
            }
            if(nums[right] <= min){
                min = nums[right];
                j = right;
            }
            if(max - min <= limit){
                right ++;
            }else {
             result = Math.max(right - left,  result);
             if(i > j){
                 left = j+1;
             }else {
                 left = i+1;
             }
             i = left;
             j = left;
             max = nums[left];
             min = nums[left];
             right = left;
            }
        }
        result = Math.max(right - left,  result);
        return result;
    }




}
