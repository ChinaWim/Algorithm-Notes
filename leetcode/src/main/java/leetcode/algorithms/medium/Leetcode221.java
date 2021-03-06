package leetcode.algorithms.medium;


/**
 * [最大正方形]
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 *
 */
public class Leetcode221 {


    public int maximalSquare(char[][] matrix) {
        int maxValue = 0;
        for(int i = 0; i < matrix.length ;i ++){
            for(int j = 0; j < matrix[i].length ;j ++){
                int maxXCount = 0;
                int maxYCount = 0;
                int maxXYCount = 0;
                if(matrix[i][j] == '1'){
                    for(int kx = j + 1; kx < matrix[i].length; kx++){
                        if(matrix[i][kx] == '0'){
                            break;
                        }
                        if(matrix[i][kx] == '1'){
                            maxXCount++;
                        }
                    }
                    for(int ky = i + 1; ky < matrix.length; ky++){
                        if(matrix[ky][j] == '0'){
                            break;
                        }
                        if(matrix[ky][j] == '1'){
                            maxYCount++;
                        }
                    }

                    int kjTemp = j+1;
                    for(int ki = i + 1; ki < matrix.length; ki++ ){
                        boolean hasZero = false;
                        for(int kj = kjTemp; kj < matrix[i].length;){
                            if(matrix[ki][kj]  == '0'){
                                hasZero = true;
                                break;
                            }
                            if(matrix[ki][kj]  == '1'){
                                maxXYCount++;
                            }
                            break;
                        }
                        kjTemp++;
                        if(hasZero) {
                            break;
                        }
                    }

                    int minCount = Math.min(Math.min(maxXCount, maxYCount), maxXYCount);
                    int minCountTemp = minCount + 1;
                    boolean hasFinalDone = false;
                    while(minCountTemp-- >0){
                        boolean hasDone = true;
                        for(int fi = i ; fi<=i+minCountTemp ; fi++){
                            for(int fj = j ; fj<=j+minCountTemp ; fj++){
                                if(matrix[fi][fj] == '0'){
                                    hasDone = false;
                                    break;
                                }
                            }
                            if(!hasDone){
                                break;
                            }
                        }
                        if(hasDone){
                            minCount = minCountTemp;
                            hasFinalDone = true;
                            break;
                        }
                    }


                    if(hasFinalDone){
                        int edge = minCount + 1;
                        maxValue = Math.max(edge * edge,maxValue);
                    }

                }

            }
        }

        return maxValue;
    }




}
