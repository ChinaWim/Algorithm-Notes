package leetcode.algorithms.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

/**
 * [只出现一次的数字]
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 */
public class Leetcode136 {


    public static void main(String[] args) {
        Leetcode136 l = new Leetcode136();
        System.out.println(l.singleNumber2(new int[]{1, 1, 2, 4, 4, 6,6}));
    }

    /**
     * 使用空间
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int num = nums[i];
            Integer numMapValue = numMap.get(num);
            Integer count = numMapValue == null ? 0 : numMapValue;
            numMap.put(num,count + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if(entry.getValue()  == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 不使用空间使用位运算或者交换
     */
    public int singleNumber2(int[] nums){
        for(int i = 1; i < nums.length; i ++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

}
