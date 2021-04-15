package leetcode.algorithms.medium;

/**
 * [打家劫舍]
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 考点：dp
 */
public class Leetcode198 {

    public int rob(int[] nums) {
        int max = 0;
        if(nums.length <= 2){
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(0 + nums[1],dp[0]);
        for(int i = 2; i < nums.length; i ++){
            dp[i] = Math.max(dp[i - 2]+nums[i],dp[i - 1]);
        }
        return  dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Leetcode198 l = new Leetcode198();
        System.out.println(l.rob(new int[]{2,1,1,2}));
    }

}
