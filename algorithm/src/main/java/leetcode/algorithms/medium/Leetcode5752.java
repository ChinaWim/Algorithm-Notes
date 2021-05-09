package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * [子数组最小乘积的最大值]
 *
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的 连续 部分。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 *
 * 考点：单调栈+前缀和
 */
public class Leetcode5752 {

    /**
     * 超时法
     */
    public int maxSumMinProduct(int[] nums) {
        long maxData = 0;
        for (int i = 0; i < nums.length; i ++) {
            int l = i - 1;
            int r = i + 1;
            long sum = nums[i];
            while(true){
                int lOld = l;
                int rOld = r;
                if(l >= 0 && nums[l] >= nums[i]){
                    sum += nums[l];
                    l--;
                }
                if(r <= nums.length - 1 && nums[r]  >= nums[i]){
                    sum += nums[r];
                    r++;
                }
                if(lOld == l && rOld == r){
                    break;
                }
            }
            long curData = sum * nums[i];

            maxData = Math.max(maxData,curData);
        }
        return (int) (maxData % (1000000000 + 7));
    }
    public static void main(String[] args) {
        Leetcode5752 l = new Leetcode5752();
        System.out.println(l.maxSumMinProduct2(new int[]{1,2,3,2}));
        System.out.println(l.maxSumMinProduct2(new int[]{3,1,5,6,4,2}));
        System.out.println(l.maxSumMinProduct2(new int[]{2,3,3,1,2}));
    }

    /**
     * 正确解法
     * 前缀和+单调栈，思路：先组装好前缀和，再对每一个数处理好其左边第一个小于它的坐标，右边第一个小于它的坐标，
     * 最后for一次计算所有数的左右最大距离*当前数（这个值使用前缀和替换掉速度会快）
     *
     */
    public int maxSumMinProduct2(int[] nums) {
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[] right = new int[nums.length];
        Arrays.fill(right,-1);
        Stack<Integer> rightStack = new Stack<>();
        for(int i = 0; i < nums.length; i ++){
            while(!rightStack.isEmpty() && nums[i] < nums[rightStack.peek()]){
                right[rightStack.pop()] = i;
            }
            rightStack.push(i);
        }

        int[] left = new int[nums.length];
        Arrays.fill(left,-1);
        Stack<Integer> leftStack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i --){
            while(!leftStack.isEmpty() && nums[i] < nums[leftStack.peek()]){
                left[leftStack.pop()] = i;
            }
            leftStack.push(i);
        }
        long maxSum = 0;
        for(int i = 0; i < nums.length; i ++){
            int r = right[i];
            int l = left[i];
            long lastData = r < 0 ? preSum[nums.length - 1] : preSum[r - 1];
            long preData = l < 0 ? 0 : preSum[l];
            maxSum = Math.max(maxSum,(lastData-preData)*nums[i]);
        }
        return (int) (maxSum % 1000000007);
    }


}
