package leetcode.algorithms.medium;
import java.util.Arrays;


/**
 * [螺旋矩阵 II]
 *
 *给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 */
public class Leetcode59 {

    public int[][] generateMatrix(int n) {
         int[][] result = new int[n][n];
        boolean columnStart = true;
        boolean rowAddStart = true;
        boolean columnAddStart = true;
       int row = 0;
       int column = 0;
        result[0][0] = 1;
       if(n == 1){
           return result;
       }
       int p = 2;
        while(p <= n*n){
            if(columnStart){
                column =  columnAddStart ? column < n - 1 ? ++column : column  : column > 0 ? --column : column;
                if(columnAddStart && (column == n - 1 || result[row][column] != 0)){
                    if(result[row][column] != 0){
                        column --;
                        p--;
                    }
                    columnStart = false;
                    columnAddStart = false;
                }else if(column == 0 || result[row][column] != 0){
                    if(result[row][column] != 0){
                        column ++;
                        p--;
                    }
                    columnStart = false;
                    columnAddStart = true;
                }
            }else {
                row =  rowAddStart ? row < n - 1 ? ++row : row  : row > 0 ? --row : row;
                if(rowAddStart && (row == n - 1 || result[row][column] != 0)){
                    if(result[row][column] != 0){
                        row --;
                        p--;
                    }
                    columnStart = true;
                    rowAddStart = false;
                }else if(row == 0 || result[row][column] != 0){
                    if(result[row][column] != 0){
                        row ++;
                        p--;
                    }
                    columnStart = true;
                    rowAddStart = true;
                }
            }

            result[row][column] = p ++;

        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode59 demo1 = new Leetcode59();
        int[][] ints = demo1.generateMatrix(6);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
      ;
    }

}
