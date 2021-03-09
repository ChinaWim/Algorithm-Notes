package leetcode.algorithms.medium;

/**
 * [构成特定和需要添加的最少元素]
 *
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 *
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 *
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 *
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 *
 */
public class Leetcode5698 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }
        long diff = Math.abs(goal - sum);
        int count = (int)(diff / limit + (diff % limit == 0 ? 0 : 1));
        return count;
    }
}
