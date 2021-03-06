package leetcode.algorithms.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * [独一无二的出现次数]
 *
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 *
 *
 */
public class Leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        HashSet<Integer> countSet = new HashSet<>();
        for(int i = 0 ; i < arr.length; i ++){
            Integer showCount = countMap.get(arr[i]);
            countMap.put(arr[i],showCount == null ? 1:showCount+1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            countSet.add(entry.getValue());
        }
        return countSet.size() == countMap.size();
    }
}
