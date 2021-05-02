package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * [砖墙]
 *
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 *
 * 考点：前缀和
 */
public class Leetcode557 {
//    [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
    public static void main(String[] args) {
        Leetcode557 l = new Leetcode557();
        List<List<Integer>>  wall = new ArrayList<>();
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));
        System.out.println(l.leastBricks(wall));

    }

    /**
     * 超时法：把大砖分解为小砖头,然后算非裂缝数
     */
    public int leastBricks(List<List<Integer>> wall) {
       int[][] box = new int[wall.size()][100000000];
       for(int i = 0; i < wall.size(); i ++){
           List<Integer> ws = wall.get(i);
           int column = 0;
           for (Integer w : ws) {
               if(w == 1){
                   box[i][column++] = 1;
               }else {
                   for(int j = 0; j < w; j++){
                       if(j == w - 1){
                           box[i][column++] = 1;
                       }else {
                           box[i][column++] = 0;
                       }
                   }
               }
           }
       }
       int min = wall.size();
       for (int i = 0; i < box.length - 1; i ++) {
           int count = 0;
           for (int j = 0; j < box.length; j ++) {
               if(box[j][i] == 0){
                 count ++;
               }
           }
           if(count != 0){
               min = Math.min(min,count);
           }
       }
       return min;
    }

    /**
     * 正解法：直接算最大的重合裂缝，用HashMap记录
     */
    public int leastBricks2(List<List<Integer>> wall) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < wall.size(); i ++){
            List<Integer> ws = wall.get(i);
            int sum = 0;
            for(int j = 0; j < ws.size() - 1; j ++){
                sum += ws.get(j);
                hashMap.put(sum,hashMap.getOrDefault(sum,0) + 1);
                maxCount = Math.max(maxCount,hashMap.get(sum));
            }
        }
        return wall.size() - maxCount;
    }

}
