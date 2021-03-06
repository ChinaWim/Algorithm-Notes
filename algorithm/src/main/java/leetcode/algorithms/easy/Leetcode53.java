package leetcode.algorithms.easy;

/**
 * [最大子序和]
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxNum = nums[0];
        int tempNum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            tempNum += nums[i];
            if(tempNum > maxNum){
                maxNum = tempNum;
            }
            if(nums[i] > tempNum){
                tempNum = nums[i];
                if(nums[i] > maxNum){
                    maxNum = nums[i];
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Leetcode53 demo = new Leetcode53();
        System.out.println(demo.maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
