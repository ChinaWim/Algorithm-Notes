package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 */
public class Leetcode229 {


    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        int times = nums.length / 3;
        HashMap<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numTimes = timesMap.getOrDefault(nums[i], 0);
            int curNumTimes = numTimes + 1;
            timesMap.put(nums[i], curNumTimes);
            if (curNumTimes > times) {
                result.add(nums[i]);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Leetcode229 l = new Leetcode229();

        System.out.println(l.majorityElement(new int[]{3, 2, 3}));
        System.out.println(l.majorityElement(new int[]{1}));
        System.out.println(l.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));

    }


}
