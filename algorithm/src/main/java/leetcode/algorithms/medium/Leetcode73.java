package leetcode.algorithms.medium;

/**
 * [矩阵置零]
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *  考点：原地算法
 *
 */
public class Leetcode73 {

    public static void main(String[] args) {
        Leetcode73 l = new Leetcode73();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        l.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int[][] box = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                if(box[i][j] == 0 && matrix[i][j] == 0){
                    box[i][j] = 1;
                    int row = i;
                    int column = j;
                    while(row < matrix.length){
                        if(matrix[row][j] != 0){
                            box[row][j] = 1;
                            matrix[row][j] = 0;
                        }
                        row ++;
                    }
                    row = i;
                    while(row >= 0){
                        if(matrix[row][j] != 0){
                            box[row][j] = 1;
                            matrix[row][j] = 0;
                        }
                        row--;
                    }
                    while(column < matrix[i].length){
                        if(matrix[i][column] != 0){
                            box[i][column] = 1;
                            matrix[i][column] = 0;
                        }
                        column++;
                    }
                    column = j;
                    while(column >= 0){
                        if(matrix[i][column] != 0){
                            box[i][column] = 1;
                            matrix[i][column] = 0;
                        }
                        column--;
                    }
                }
            }
        }
    }


}
