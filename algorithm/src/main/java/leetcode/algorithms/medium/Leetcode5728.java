package leetcode.algorithms.medium;

/**
 * [最少侧跳次数]
 *
 * 给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
 *
 * 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
 *
 * 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
 * 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
 *
 * 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
 * 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
 *
 * 注意：点 0 处和点 n 处的任一跑道都不会有障碍。
 *
 * 示例 1：
 *
 *
 * 输入：obstacles = [0,1,2,3,0]
 * 输出：2
 * 解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
 * 注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
 * todo
 *
 */
public class Leetcode5728 {

    public static void main(String[] args) {
        Leetcode5728 l = new Leetcode5728();
        int[] data = new int[]{0,0,0,2,0,0,3,3,0,3,0};
        System.out.println(l.minSideJumps(data));
    }

    public int minSideJumps(int[] obstacles) {
        int step = 0;
        int cur = 2;
        for(int i = 1; i < obstacles.length;){
            int curObs = obstacles[i - 1];
            if(cur == obstacles[i]){
                step ++;
                int firstObs = 0;
                int firstCurObs = 0;
               for(int j = i + 1; j < obstacles.length - 1; j ++){
                   if(obstacles[j] != 0){
                       firstObs = obstacles[j];
                       if(obstacles[j] != obstacles[i]){
                           firstCurObs = obstacles[j];
                           break;
                       }
                   }
               }
               if(firstObs == 0){
                   return step;
               }
              if(firstCurObs == 1){
                  cur = getCur(obstacles, cur, i, curObs);
              }else if(firstCurObs == 2){
                  cur = getCur(obstacles, cur, i, curObs);
              }else if(firstCurObs == 3){
                  cur = getCur(obstacles, cur, i, curObs);
              }
              if(cur == 2){
                  i ++;
              }
            }else {
                i ++;
            }
        }
        return step;
    }

    private int getCur(int[] obstacles, int cur, int i, int curObs) {
        if(obstacles[i] == 1){
            cur = 2;
        }else if(obstacles[i] == 2){
            cur = curObs != 3 ? 3 : 1;
        }else if(obstacles[i] == 3){
            cur = curObs != 2 ? 2 : 1;
        }
        return cur;
    }
}
