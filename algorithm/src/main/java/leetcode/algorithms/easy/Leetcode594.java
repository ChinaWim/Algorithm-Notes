package leetcode.algorithms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * [最长和谐子序列]
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 */
public class Leetcode594 {

    public static void main(String[] args) {
        Leetcode594 l = new Leetcode594();
        System.out.println(l.findLHS2(new int[]{1,2,1,3,0,0,2,2,1,3,3}));
    }

    public int findLHS(int[] nums) {
        int maxLength = 0;
        for(int i = 0 ; i < nums.length - 1; i ++){
            int maxCount = 0;
            int minCount = 0;
            int equalCount = 0;
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[j] - nums[i] == 1){
                    maxCount ++;
                }
                if(nums[i] - nums[j] == 1){
                    minCount ++;
                }
                if(nums[j] == nums[i]){
                    equalCount ++;
                }
            }
            if(maxCount != 0 || minCount != 0){
                maxLength = Math.max(Math.max(maxCount + equalCount,minCount + equalCount) + 1,maxLength);
            }
        }
        return maxLength;
    }

    public int findLHS2(int[] nums) {
        int maxLength = 0;
        HashMap<Integer,Integer> mapData = new HashMap<>();
        for (int i = 0 ; i < nums.length; i ++){
            Integer num = mapData.get(nums[i]);
            mapData.put(nums[i],num == null ? 1:num + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mapData.entrySet()) {
            Integer key = entry.getKey();
            Integer afterValue = mapData.get(key + 1);
            afterValue =  afterValue == null ? 0 : afterValue;
            if(afterValue != 0){
                maxLength = Math.max(afterValue + entry.getValue(), maxLength);
            }
        }
        return maxLength;
    }
}
