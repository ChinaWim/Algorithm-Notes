package leetcode.algorithms.medium;

import java.util.*;

/**
 * [子集 II]
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 */
public class Leetcode90 {

    public static void main(String[] args) {
        Leetcode90 l = new Leetcode90();
        int[] nums = new int[]{4,4,4,1,4};
        Arrays.sort(nums);
        List<List<Integer>> lists = l.subsetsWithDup(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int[] array = new int[nums.length];
        Set<String> valueSet = new HashSet<>();
        this.dfs(0,0,nums,array,valueSet);
        for (String value : valueSet) {
            String[] valueArray = value.split("#");
            List<Integer> vList = new ArrayList<>();
            for (String v : valueArray) {
                vList.add(Integer.valueOf(v));
            }
            result.add(vList);
        }
        return result;
    }

    private void dfs(int step,int pos,int[] nums,int[] array,Set<String> valueSet){
        if(step > nums.length){
            return;
        }
        if(step > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < step; i ++){
                sb.append(array[i]).append("#");
            }
            valueSet.add(sb.toString());
        }
        for(int i = pos; i < nums.length; i ++){
            array[step] = nums[i];
            this.dfs(step + 1,i+1,nums,array,valueSet);
        }
    }

}
