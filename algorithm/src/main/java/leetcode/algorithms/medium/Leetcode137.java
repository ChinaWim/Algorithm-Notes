package leetcode.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * [只出现一次的数字 II]
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 *
 */
public class Leetcode137 {

    public static void main(String[] args) {
        Leetcode137 l = new Leetcode137();
        System.out.println(l.singleNumber(new int[]{2, 2, 3, 2}));
    }

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

}
