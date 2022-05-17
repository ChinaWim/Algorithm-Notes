package leetcode.algorithms.week.week293;

/**
 * @description: 按位与结果大于零的最长组合 TODO
 *
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 *
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
 *
 * 返回按位与结果大于 0 的 最长 组合的长度。
 *
 *
 * @author:
 * @create: 2022-05-15 11:45
 **/
public class Leetcode6065{

    public static void main(String[] args){
        Leetcode6065 l = new Leetcode6065();
        int[] ints = {16,16,48,71,62,12,24,14,14};
        System.out.println(l.largestCombination(ints));

    }


    public int largestCombination(int[] candidates) {
        int max = candidates.length;
        while(max > 0){
            int [] array = new int[candidates.length];
            int [] box = new int[candidates.length];
            int result = this.dfs(0,max,array,box,candidates);
            if(result > 0){
                return max;
            }
            max --;
        }
        return max;
    }


    private int dfs(int step ,int max,int [] array,int [] box,int [] candidates){
        int result = 0;
        if(step == max){
            for(int i = 0; i < step; i ++){
                System.out.print(array[i] +" ");
            }
            int sum = array[0];
            for(int i = 0; i < step; i ++){
                sum &= array[i];
            }
            System.out.println("sum="+sum);
            return sum;
        }

        for(int i = 0; i < candidates.length; i ++){
            if(box[i] == 0){
                box[i] = 1;
                array[step] = candidates[i];
                result = this.dfs(step + 1,max,array,box,candidates);
                box[i] = 0;
                if(result > 0){
                    break;
                }
            }

        }
        return result;
    }
}
