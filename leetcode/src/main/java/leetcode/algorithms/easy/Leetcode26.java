package leetcode.algorithms.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * [删除排序数组中的重复项]
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 */
public class Leetcode26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Leetcode26 l = new Leetcode26();
        System.out.println(l.removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::print);
    }


    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
              continue;
            } else {
                nums[set.size()] = num;
            }
            set.add(num);
        }
        return set.size();
    }
}
