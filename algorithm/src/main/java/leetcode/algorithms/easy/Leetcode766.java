package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [托普利茨矩阵]
 *
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 */
public class Leetcode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int[][] box = new int[21][21];
        for(int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j <matrix[i].length; j++) {
                if(box[i][j] != 0){
                    continue;
                }
                int k = i + 1;
                int l = j + 1;
                List<Integer> rows = new ArrayList<>();
                List<Integer> columns = new ArrayList<>();
                while( k < matrix.length && l < matrix[i].length){
                    if(matrix[k][l] != matrix[i][j]){
                        return false;
                    }
                    rows.add(k);
                    columns.add(l);
                    k ++;
                    l ++;
                }
               for(int i2 = 0 ; i2 < rows.size() ;i2++){
                   box[rows.get(i2)][columns.get(i2)] = 1;
               }
            }
        }
        return true;
    }
}
