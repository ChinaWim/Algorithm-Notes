package leetcode.algorithms.hard;

import java.util.HashSet;

/**
 * [缺失的第一个正数]
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 */
public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> values = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                values.add(nums[i]);
            }
        }
        if(values.size() > 0){
            int p = 1;
            while(p != 0){
                if(values.contains(p)){
                    p++;
                }else {
                    return p;
                }
            }
            return p;
        }else {
            return 1;
        }

    }


    public static void main(String[] args) {
        Leetcode41 demo = new Leetcode41();
        System.out.println(demo.firstMissingPositive(new int[]{7,8,9,11,12}));
    }


}
