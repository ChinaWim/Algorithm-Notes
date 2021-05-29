package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Leetcode118 {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int[][] data = new int[numRows + 1][numRows + 1];
        for (int i = 1; i <=numRows; i ++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 1; j<= i; j ++){
                 if(j == 1 || j == i){
                     data[i][j] = 1;
                 }else {
                     data[i][j] = data[i - 1][j] + data[i - 1][j - 1];
                 }
                row.add(data[i][j]);
            }
            resultList.add(row);
        }
        return resultList;
    }


}
