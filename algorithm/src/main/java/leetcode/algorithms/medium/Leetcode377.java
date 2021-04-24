package leetcode.algorithms.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [组合总和 Ⅳ]
 *
 *  给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 *  题目数据保证答案符合 32 位整数范围。
 *
 *  示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 */
public class Leetcode377 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Leetcode377 l = new Leetcode377();
        System.out.println(l.combinationSum43(nums, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        return this.dfs(0,0,nums,target);
    }

    public int dfs(int step,int sum,int[] nums,int target){
        int count = 0;
        if(sum > target){
            return 0;
        }
        if(sum == target){
            return 1;
        }
        for(int i = 0; i < nums.length; i ++){
            count += dfs(step + 1,sum + nums[i],nums,target);
        }
        return count;
    }


    /**
     * dp方式
     */
//    public int combinationSum42(int[] nums, int target) {
//        if(nums.length == 1){
//            return nums[0] == target ? 1 : 0;
//        }
//        int[] dp = new int[nums.length];
//        for(int i = 2; i < nums.length; i++){
//
//        }
//        return 0;
//    }

    /**
     * 记忆化搜索
     */
    /**
     * key target
     * value total of target
     */
    private HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int combinationSum43(int[] nums, int target) {
        return this.memoDfs(nums,target);
    }
    private int memoDfs(int[] nums,int target){
        if(target == 0){
            return 1;
        }
        if(hashMap.containsKey(target)){
            return hashMap.get(target);
        }
        int res = 0;
        for(int i = 0 ; i < nums.length; i ++){
            if (target >= nums[i]) {
                res += this.memoDfs(nums,target - nums[i]);
            }
        }
        hashMap.put(target, res);
        return res;
    }

}
