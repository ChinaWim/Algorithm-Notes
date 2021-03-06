package leetcode.algorithms.medium;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * [组合]
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Leetcode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int [k];
        this.dfs(n,k,0,1,result,array);
        return result;
    }

    private void dfs(int n,int k, int step,int pos,List<List<Integer>> result,int[] array){
        if(step >= k){
            List<Integer> data = new ArrayList<>();
            for(int i = 0 ; i < k; i++){
                data.add(array[i]);
            }
            result.add(data);
            return;
        }
        for(int i= pos;i <=n; i++){
            int temp = array[step];
            array[step] = i;
            dfs(n,k,step + 1,i + 1,result,array);
            array[step] = temp;
        }
    }

    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        System.out.println(leetcode77.combine(4, 2));
    }



}
