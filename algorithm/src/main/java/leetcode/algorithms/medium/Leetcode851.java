package leetcode.algorithms.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自洽（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 *
 *
 * 邻接表+记忆化搜索
 */
public class Leetcode851 {


    public static void main(String[] args) {
        Leetcode851 node = new Leetcode851();
        System.out.println(Arrays.toString(node.loudAndRich(new int[][]{
                {1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}
        }, new int[]{3,2,5,4,6,1,7,0})));
    }

    class Memo{
        int index;
        int min;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[][] data = new int[quiet.length][quiet.length];
        for (int i = 0; i < richer.length; i++) {
            int n1 = richer[i][0];
            int n2 = richer[i][1];
            data[n1][n2] = 1;
            data[n2][n1] = -1;
        }
        int[] result = new int[quiet.length];
        Memo[] memo = new Memo[quiet.length];

        for (int i = 0; i < quiet.length; i++) {
            Memo memoData = this.min(i, data, quiet, memo);
            memo[i] = memoData;
            result[i] = memoData.index;
        }
        return result;
    }

    private Memo min(int i,int[][] data,int[] quiet,Memo[] memo){
        Memo result = new Memo();
        int min = quiet[i];
        int index = i;
        Stack<Integer> last = new Stack<>();
        last.add(i);
        while(!last.isEmpty()){
            Integer curIndex = last.pop();
            Memo memoData = memo[curIndex];
            if( memoData != null){
                if(memoData.min < min){
                    min = memoData.min;
                    index = memoData.index;
                }
                continue;
            }
            for(int j = 0; j < quiet.length; j ++){
                if(data[curIndex][j] < 0){
                    if(quiet[j] < min){
                        min = quiet[j];
                        index = j;
                    }
                    last.add(j);
                }
            }
        }

        result.index = index;
        result.min = min;

        return result;
    }


}
