package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * [打家劫舍 II]
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 考点：dp
 */
public class Leetcode213 {

    public static void main(String[] args) {
        Leetcode213 l = new Leetcode213();
        int[] nums = new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(l.rob(nums));
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(this.dfs(0,0,0,0,nums),this.dfs(1,0,0,1,nums));
        }
        return Math.max(Math.max(this.dfs(0,0,0,0,nums),this.dfs(1,0,0,1,nums)),this.dfs(2,0,0,2,nums));
    }
    //错误解法：dfs
    private int dfs(int start,int step,int sum,int index,int[] nums){
        if(step > (nums.length / 2) - 1 ){
            return sum;
        }
        int max1 = sum + nums[index];
        int max2 = sum + nums[index];
        if(Math.abs((index + 2) % nums.length - start) > 1 && !(start == 0 && (index + 2) % nums.length == nums.length - 1)
                && !(start == nums.length - 1 && (index + 2) % nums.length == 0)){
            max1 = dfs(start,step + 1,sum + nums[index],(index + 2) % nums.length,nums);

        }
        if(Math.abs((index + 3) % nums.length - start) > 1 && !(start == 0 && (index + 3) % nums.length == nums.length - 1)
                && !(start == nums.length - 1 && (index + 3) % nums.length == 0)){
            max2 = dfs(start,step + 1,sum + nums[index],(index + 3) % nums.length,nums);
        }
        return Math.max(max1,max2);
    }

    //dp
    public int rob2(int[] nums) {
        int res = 0;
        //小于等于3
        if(nums.length <= 3){
            for(int i : nums){
                res = Math.max(res,i);
            }
            return res;
        }
        //不偷第一个房屋
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        res = dp[dp.length - 1];
        //不偷最后一个房屋
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        res = Math.max(res, dp[dp.length - 2]);
        return res;
    }

}
