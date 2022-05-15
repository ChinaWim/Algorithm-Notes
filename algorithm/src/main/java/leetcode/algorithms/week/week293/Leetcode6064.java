package leetcode.algorithms.week.week293;

import java.util.Arrays;

/**
 * @description: 不含特殊楼层的最大连续楼层数
 *
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 *
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 *
 * 返回不含特殊楼层的 最大 连续楼层数。
 *
 *
 * @author: panweiming panweiming1@shein.com
 * @create: 2022-05-15 11:12
 **/
public class Leetcode6064{

    public static void main(String[] args){
        Leetcode6064 a = new Leetcode6064();
        System.out.println(a.maxConsecutive(2,9,new int[]{4,6}));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        Arrays.sort(special);
        for(int i = 0; i < special.length; i ++){
            int specialValue = special[i];
            if(i == 0){
                int diffBottom = specialValue - bottom;
                max = Math.max(max, diffBottom);
            }
            if(i == special.length - 1){
                int diffTop = (top - specialValue);
                max = Math.max(max, diffTop);
            }
            if( i != 0){
                int diffAfter = (specialValue - special[i-1]) - 1;
                max = Math.max(max, diffAfter);
            }
            if(i != special.length - 1){
                int diffBefore = (special[i+1] - specialValue) - 1;
                max = Math.max(max, diffBefore);
            }
        }
        return max;
    }

}
