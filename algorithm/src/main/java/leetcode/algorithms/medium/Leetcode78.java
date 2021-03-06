package leetcode.algorithms.medium;
import java.util.ArrayList;
import java.util.List;

/**
 * [子集]
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int[nums.length];
        this.dfs(nums,0,0,array,result);
        return result;
    }


    private void dfs(int[] nums,int step,int pos,int [] array,List<List<Integer>> result){
        if(step > nums.length){
            return;
        }
        List<Integer> stepData = new ArrayList<>();
        for(int j = 0; j < step ; j++){
            stepData.add(array[j]);
        }
        result.add(stepData);
        for(int i = pos; i < nums.length; i ++){
           array[step] = nums[i];
           dfs(nums,step + 1,i + 1,array,result);
        }

    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        List<List<Integer>> subsets = leetcode78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

    }
}
