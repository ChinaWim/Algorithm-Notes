package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * [螺旋矩阵]
 *
 *给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 */
public class Leetcode54 {

    public static void main(String[] args) {
        Leetcode54 l = new Leetcode54();
        int [][] matrix = new int [][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = l.spiralOrder(matrix);
        System.out.println(integers);
    }

    /**
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        int i = 0;
        int j = 0;
        while(result.size() < rowSize * columnSize ){
            //right
            for(int p = 0; p < column && j < columnSize; p ++,j++){
                result.add(matrix[i][j]);
            }
            if(result.size() == rowSize * columnSize){
                break;
            }
            i++;
            row--;
            j--;
            //down
            for(int p = 0; p < row && i < rowSize; p ++,i++){
                result.add(matrix[i][j]);
            }
            if(result.size() == rowSize * columnSize){
                break;
            }
            column--;
            j--;
            i--;
            //left
            for(int p = column - 1; p >= 0 && j >= 0; p --,j --){
                result.add(matrix[i][j]);
            }
            if(result.size() == rowSize * columnSize){
                break;
            }
            row--;
            i--;
            j++;
            //up
            for(int p = row - 1; p >= 0 && i >= 0; p --,i --){
                result.add(matrix[i][j]);
            }
            if(result.size() == rowSize * columnSize){
                break;
            }
            column--;
            j++;
            i++;
        }
        return result;
    }

}
