package leetcode.algorithms.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 存在重复元素 III
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * 考点：滑动窗口，桶思想
 *
 *
 */
public class Leetcode220 {
    public static void main(String[] args) {
        Leetcode220 l = new Leetcode220();
//        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
//        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
//        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0));
    }


    class Node implements Comparable{
        private int index;
        private long value;
        Node(int index,long value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Node onode = (Node)o;
            return Long.compare(this.value,onode.value);
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1){
            return false;
        }
        List<Node> arrayList = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i ++){
            arrayList.add(new Node(i,nums[i]));
        }
        Collections.sort(arrayList);
        for(int i = 0 ; i < arrayList.size() - 1; i ++){
            for(int j = i + 1; j < arrayList.size(); j++){
               long diffT = Math.abs(arrayList.get(i).value - arrayList.get(j).value);
                long diffK = Math.abs(arrayList.get(i).index - arrayList.get(j).index);
                if(diffK <= k && diffT <= t){
                    return true;
                }
                if(diffT > t){
                    break;
                }
            }
        }
        return false;
    }

}
