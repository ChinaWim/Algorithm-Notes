package leetcode.algorithms.easy;

/**
 *
 * [寻找数组的中心下标]
 *
 *给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 *
 * 注意：中心下标可能出现在数组的两端。
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 *
 */
public class Leetcode724 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int p = 0;
       for(int i = 0; i < nums.length; i++){
           if((sum - p - nums[i]) == p ){
                return i;
           }
           p+=nums[i];
       }
        return -1;
    }
}
