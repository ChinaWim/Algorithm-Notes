package leetcode.algorithms.medium;
import java.util.*;


/**
 * [组合总和]
 *
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 *输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 */
public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int [500];
        int[] box = new int [500];
        this.dfs(candidates,0,target,array,0,result);
        return result;
    }

    private void dfs(int [] candidates,int step,int target,int[] array,int sum, List<List<Integer>> result){
        if(sum >= target){
            if(sum == target){
                List<Integer> row = new ArrayList<>();
                for(int i = 0; i < step; i++){
                    row.add(array[i]);
                }
                for (List<Integer> resultRows : result) {
                    if(this.equalsList(resultRows,row)){
                        return;
                    }
                }
                result.add(row);
            }
            return;
        }
        for(int i = 0; i < candidates.length; i ++){
           array[step] = candidates[i];
           dfs(candidates, step + 1, target, array,  sum + candidates[i], result);
        }
    }
    private boolean equalsList(List<Integer> list1 ,List<Integer> list2){
        if(list1.size() != list2.size()){
            return false;
        }
        int[] box = new int [list1.size()];
        int count = 0;
        for (Integer list1Data : list1) {
            for (int j = 0; j < list2.size(); j++) {
                if (box[j] == 0 && list1Data.equals(list2.get(j))) {
                    box[j] = 1;
                    count++;
                    break;
                }
            }
        }

        return count == list2.size();
    }

    public static void main(String[] args) {
        Leetcode39 leetcode39 = new Leetcode39();


        List<List<Integer>> lists = leetcode39.combinationSum(new int[]{7,3,2}, 18);
        System.out.println(lists);


    }

}
