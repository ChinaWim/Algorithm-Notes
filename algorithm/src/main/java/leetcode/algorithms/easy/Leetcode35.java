package leetcode.algorithms.easy;

/**
 * [搜索插入位置]
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 *
 */
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            int data = nums[i];
            if(target == data){
                return i;
            }
            if(target < data){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Leetcode35 demo = new Leetcode35();
        int [] nums = new int []{1,3,5,6,101};
        System.out.println(demo.searchInsert(nums, 100));
    }


}
